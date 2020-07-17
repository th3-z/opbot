package xyz.th3z.opbot.commands;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.chat.ComponentSerializer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Map implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String link = String.format(
            "{" +
                "\"text\": \"%s\"," +
                "\"color\": \"dark_aqua\"," +
                "\"underlined\": true," +
                "\"clickEvent\": {\"action\": \"open_url\", \"value\": \"https://vanilluxe.th3-z.xyz/map/\"}" +
            "}",
            "here"
        );

        String message = String.format(
            "[\"\", {\"text\":\"See Vanilluxe's world map \", \"color\":\"aqua\"}, %s]",
            link
        );

        BaseComponent[] bc = ComponentSerializer.parse(message);
        sender.spigot().sendMessage(bc);

        return false;
    }
}
