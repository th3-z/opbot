package xyz.th3z.opbot;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.chat.ComponentSerializer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.th3z.opbot.events.PlayerJoin;
import xyz.th3z.opbot.events.PlayerLeave;
import xyz.th3z.opbot.utils.Ticks;

public final class OpBot extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        System.out.println("OpBot starting...");
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new PlayerLeave(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic, ran on server shutdown
    }

    private void broadcastRaw(String message) {
        BaseComponent[] bc = ComponentSerializer.parse(message);
        Bukkit.getOnlinePlayers().stream().forEach(player -> player.spigot().sendMessage(bc));
    }

    @EventHandler
    public void onChat(PlayerChatEvent event) {
        String message = event.getMessage();
        if (message.length() < 1) return;

        String[] args = message.split(" ");

        if (args[0].charAt(0) == '!') {
            String command = args[0].substring(1);

            switch (command) {
                case "whitelist":
                    if (args.length < 2) {
                        getServer().broadcastMessage(ChatColor.AQUA + "Missing argument: username");
                    } else {
                        OfflinePlayer target = getServer().getOfflinePlayer(args[1]);
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
                                "[\"\", %s, {\"text\":\" has been added to the whitelist. \"}]",
                                link
                            ));
                            target.setWhitelisted(true);
                        } else {
                            broadcastRaw(String.format(
                                "[\"\", %s, {\"text\":\" has been removed from the whitelist. \"}]",
                                link
                            ));
                            target.setWhitelisted(false);
                        }
                    }
                    break;
                case "help":
                    getServer().broadcastMessage(ChatColor.AQUA + "Type !list for commands reference.");
                    break;
                case "list":
                    getServer().broadcastMessage(ChatColor.AQUA + "!whitelist <username> - Toggle whitelist for user\n!tps - display server tps\n!s - toggle spectator mode");
                    break;
                case "tps":
                    double tps = Ticks.getTPS();
                    getServer().broadcastMessage(ChatColor.AQUA + "Current TPS is " + tps);
                    break;
                case "s":
                    Player player = event.getPlayer();
                    if (player.getGameMode() == GameMode.SPECTATOR)
                        player.setGameMode(GameMode.SURVIVAL);
                    else
                        player.setGameMode(GameMode.SPECTATOR);
                    break;
                default:
                    break;
            }
        }

    }
}
