package andreiwasfound.diamondbrokemessage;

import andreiwasfound.diamondbrokemessage.Utilities.UpdateChecker;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinUpdateMessage implements Listener {

    private Main plugin;

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        new UpdateChecker(plugin, 80958).getLatestVersion(version -> {
            if (plugin.getDescription().getVersion().equalsIgnoreCase(version)) {
                player.sendMessage(ChatColor.AQUA + "DiamondBrokeMessage is up to date!");
            } else {
                player.sendMessage(ChatColor.AQUA + "DiamondBrokeMessage is outdated!");
                player.sendMessage(ChatColor.AQUA + "Newest version: " + version);
                player.sendMessage(ChatColor.AQUA + "Your version: " + plugin.configVersion);
                player.sendMessage(ChatColor.AQUA + "Please Update Here: " + plugin.configWebsite);
            }
        });
    }
}
