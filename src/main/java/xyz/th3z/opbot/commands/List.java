package xyz.th3z.opbot.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class List implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(ChatColor.AQUA + "!whitelist <username> - Toggle whitelist for user\n!tps - display server tps\n!s - toggle spectator mode");
        return false;
    }
}
