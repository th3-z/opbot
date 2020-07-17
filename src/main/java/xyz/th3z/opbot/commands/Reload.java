package xyz.th3z.opbot.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import xyz.th3z.opbot.utils.Messages;

import java.io.File;

public class Reload implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Messages.broadcastRaw("{" +
            "\"text\": \"Reloading plugins...\"," +
            "\"color\": \"aqua\"" +
        "}");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "reload confirm");
        Messages.broadcastRaw("{" +
            "\"text\": \"Plugins reloaded\"," +
            "\"color\": \"aqua\"" +
        "}");

        return false;
    }
}
