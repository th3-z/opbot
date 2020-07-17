package xyz.th3z.opbot.utils;

import org.bukkit.scheduler.BukkitRunnable;

public class Ticks extends BukkitRunnable {
    public static int tickCount = 0;

    // 300 ticks = 30s @ 20TPS
    public static long[] ticks = new long[300];

    public static double getTPS() {
        if (tickCount < ticks.length) return 0.0D;

        int target = (tickCount - 1 - ticks.length) % ticks.length;
        long elapsed = System.currentTimeMillis() - ticks[target];

        return ticks.length / (elapsed / 1000.0D);
    }

    public void run() {
        ticks[(tickCount % ticks.length)] = System.currentTimeMillis();
        tickCount += 1;
    }
}
