package xyz.th3z.opbot.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Users implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Set<OfflinePlayer> players = Bukkit.getServer().getWhitelistedPlayers();
        List<String> usernames = new ArrayList<String>();

        for (OfflinePlayer player : players) {
            usernames.add(player.getName());
        }

        sender.sendMessage(ChatColor.AQUA + "Whitelisted players:\n    " + String.join("\n    ", usernames));

        return false;
    }
}
