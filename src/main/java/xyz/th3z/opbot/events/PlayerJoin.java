package xyz.th3z.opbot.events;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.chat.ComponentSerializer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String link = String.format(
                "{" +
                    "\"text\": \"%s\"," +
                    "\"color\": \"dark_aqua\"," +
                    "\"underlined\": true," +
                    "\"clickEvent\": {\"action\": \"open_url\", \"value\": \"https://vanilluxe.th3-z.xyz\"}" +
                "}",
                "Vanilluxe"
        );

        String message = String.format(
            "[\"\", {\"text\":\"%s joined, welcome to \", \"color\":\"red\"}, %s]",
            player.getDisplayName(), link
        );

        BaseComponent[] bc = ComponentSerializer.parse(message);
        Bukkit.getOnlinePlayers().stream().forEach(onlinePlayer -> onlinePlayer.spigot().sendMessage(bc));

        player.sendMessage(ChatColor.AQUA + "/list for commands");

        event.setJoinMessage("");
    }
}
