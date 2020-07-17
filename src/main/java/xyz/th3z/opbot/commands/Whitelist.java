package xyz.th3z.opbot.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static xyz.th3z.opbot.utils.Messages.broadcastRaw;

public class Whitelist implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 1) {
            sender.sendMessage(ChatColor.AQUA + "Missing argument: username");
        } else {
            OfflinePlayer target = Bukkit.getServer().getOfflinePlayer(args[0]);
            String link = String.format(
                "{" +
                    "\"text\": \"%s\"," +
                    "\"color\": \"dark_aqua\"," +
                    "\"underlined\": true," +
                    "\"clickEvent\": {\"action\": \"open_url\", \"value\": \"https://namemc.com/profile/%s\"}" +
                "}",
                target.getName(),
                target.getUniqueId()
            );

            if (!target.isWhitelisted()) {
                broadcastRaw(String.format(
                    "[\"\", %s, {\"text\":\" has been added to the whitelist by %s. \"}]",
                    link,
                    sender.getName()
                ));
                target.setWhitelisted(true);
            } else {
                broadcastRaw(String.format(
                    "[\"\", %s, {\"text\":\" has been removed from the whitelist by %s. \"}]",
                    link,
                    sender.getName()
                ));
                target.setWhitelisted(false);
            }
        }

        return false;
    }
}
