package xyz.th3z.opbot.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;

public class PlayerEnterBed implements Listener {
    @EventHandler
    void onPlayerEnterBed(PlayerBedEnterEvent event) {
        for (World world : Bukkit.getServer().getWorlds()) {
            if (world.getTime() >= 12541 && world.getName().equalsIgnoreCase("world")) {
                world.setTime(0);
                Bukkit.getServer().broadcastMessage(ChatColor.RED + String.format(
                        "%s slept in a bed", event.getPlayer().getName()
                ));
            }
        }
    }
}
