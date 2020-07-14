package andreiwasfound.diamondbrokemessage;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.logging.Logger;

public class DiamondOre implements Listener {

    public Main main;

    public DiamondOre(Main main) {
        this.main = main;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        if (e.getBlock().getType().equals(Material.DIAMOND_ORE)) {

            // This lines tells the online players that PLAYERNAME broke a diamond ore
            Player player = e.getPlayer();
            for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
                for(String msg : main.getConfig().getStringList("Msg")) {
                    onlinePlayers.sendMessage(ChatColor.AQUA + player.getDisplayName() + " " + msg);
                }

                // This lines tells the console that PLAYERNAME broke a diamond ore
                Logger log = Bukkit.getLogger();
                for(String msg : main.getConfig().getStringList("Msg")) {
                    log.info("[DiamondBrokeMessage] " + player.getDisplayName() + " " + msg);
                }
            }
        }
    }
}
