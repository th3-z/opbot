package xyz.th3z.opbot;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import xyz.th3z.opbot.commands.*;
import xyz.th3z.opbot.events.PlayerCommandPreprocess;
import xyz.th3z.opbot.events.PlayerJoin;
import xyz.th3z.opbot.events.PlayerLeave;
import xyz.th3z.opbot.utils.Ticks;

public final class OpBot extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        System.out.println("OpBot starting...");

        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new PlayerLeave(), this);
        getServer().getPluginManager().registerEvents(new PlayerCommandPreprocess(), this);

        getCommand("help").setExecutor(new Help());
        getCommand("list").setExecutor(new List());
        getCommand("tps").setExecutor(new Tps());
        getCommand("whitelist").setExecutor(new Whitelist());
        getCommand("reload").setExecutor(new Reload());

        BukkitRunnable ticksRunnable = new Ticks();
        ticksRunnable.runTaskTimer(this, 0L, 1L);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic, ran on server shutdown
    }
}
