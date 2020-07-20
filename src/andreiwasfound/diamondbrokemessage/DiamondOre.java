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
            Player player = e.getPlayer();

            Logger log = Bukkit.getLogger();
            if (!(main.getConfig().getBoolean("only-console"))) {
                for(String msg : main.getConfig().getStringList("Msg")) {
                    main.printToConsole(player.getDisplayName() + " " + msg);
                }
                for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
                    for (String msg : main.getConfig().getStringList("Msg")) {
                        if (main.getConfig().getBoolean("only-ops")) {
                            if (onlinePlayers.hasPermission("diamondbrokemessage.getmessage")) {
                                onlinePlayers.sendMessage(ChatColor.AQUA + player.getDisplayName() + " " + msg);
                            }
                        }
                        if (!(main.getConfig().getBoolean("only-ops"))) {
                            onlinePlayers.sendMessage(ChatColor.AQUA + player.getDisplayName() + " " + msg);
                        }
                    }
                }
            }

            if (main.getConfig().getBoolean("only-console")) {
                for(String msg : main.getConfig().getStringList("Msg")) {
                    main.printToConsole(player.getDisplayName() + " " + msg);
                }
            }
        }
    }
}