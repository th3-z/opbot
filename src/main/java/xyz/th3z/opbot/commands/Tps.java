package xyz.th3z.opbot.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import xyz.th3z.opbot.utils.Ticks;

public class Tps implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        double tps = Ticks.getTPS();
        sender.sendMessage(ChatColor.AQUA + "Current TPS is " + tps);
        return false;
    }
}
