package xyz.th3z.opbot.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class PlayerCommandPreprocess implements Listener {

    @EventHandler
    void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
        if (event.getMessage().equalsIgnoreCase("/tps")) {
            // Override paper's /tps command with alias to my /tps
            event.setMessage("/t");
        } else if (event.getMessage().equalsIgnoreCase("/reload")) {
            // Override paper's /reload command with alias to my /reload
            event.setMessage("/r");
        }
    }
}
