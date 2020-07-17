package xyz.th3z.opbot.utils;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.chat.ComponentSerializer;
import org.bukkit.Bukkit;

public class Messages {
    public static void broadcastRaw(String message) {
        BaseComponent[] bc = ComponentSerializer.parse(message);
        Bukkit.getOnlinePlayers().stream().forEach(player -> player.spigot().sendMessage(bc));
    }
}
