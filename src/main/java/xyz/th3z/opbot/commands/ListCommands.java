package xyz.th3z.opbot.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Arrays;
import java.util.List;

// Not named `List` due to name collision
public class ListCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        List<String> commands = Arrays.asList(
            "/whitelist <username> - Toggle whitelist for user\n",
            "/tps - Display server tps\n",
            "/map - Provides a link to the world map\n",
            "/web - Provides a link to Vanilluxe's website\n",
            "/help - Display help text\n",
            "/list - List all commands\n"
        );
        sender.sendMessage(ChatColor.AQUA + String.join("", commands));

        return false;
    }
}
