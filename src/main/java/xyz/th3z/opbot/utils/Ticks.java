package xyz.th3z.opbot.utils;

import org.bukkit.scheduler.BukkitRunnable;
import java.util.stream.LongStream;

import static com.google.common.primitives.Doubles.min;

public class Ticks extends BukkitRunnable {
    private static int tickCount = 0;

    // 1200 ticks = 1m @ 20TPS
    private static long[] ticks = new long[1200];

    public static double getTPS() {
        if (tickCount < ticks.length) return 0.0D;

        long[] ticksSorted = LongStream.of(ticks).sorted().toArray();
        long elapsed = ticksSorted[ticks.length - 1] - ticksSorted[0];

        return min(ticks.length / (elapsed / 1000.0D), 20.0D);
    }

    public void run() {
        ticks[(tickCount % ticks.length)] = System.currentTimeMillis();
        tickCount++;
    }
}
