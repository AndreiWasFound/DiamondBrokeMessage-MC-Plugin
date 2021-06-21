package andreiwasfound.diamondbrokemessage;

import andreiwasfound.diamondbrokemessage.Utilities.UpdateChecker;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinUpdateMessage implements Listener {

    private Main plugin;

    JoinUpdateMessage(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        if (player.hasPermission("diamondbrokemessage.updatemessage")) {
        new UpdateChecker(plugin, 80958).getLatestVersion(version -> {
            if (!(plugin.getDescription().getVersion().equalsIgnoreCase(version))) {
                player.sendMessage(ChatColor.AQUA + "DiamondBrokeMessage is " + ChatColor.RED + "outdated!");
                player.sendMessage(ChatColor.AQUA + "Newest version: " + ChatColor.GOLD +  version);
                player.sendMessage(ChatColor.AQUA + "Server version: " + ChatColor.RED + plugin.pluginymlVersion);
                player.sendMessage(ChatColor.AQUA + "Please Update Here: " + ChatColor.RED + plugin.pluginymlWebsite);
            }
        });
    }
    }
}
