package andreiwasfound.diamondbrokemessage;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class DiamondOre implements Listener {

    private final Main main;
    public DiamondOre(Main main) {
        this.main = main;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        if (e.getBlock().getType().equals(Material.DIAMOND_ORE)) {
            Player player = e.getPlayer();

            if (!(main.getConfig().getBoolean("only-console"))) {
                for(String msg : main.getConfig().getStringList("Msg")) {
                    main.printToConsole(player.getDisplayName() + " " + msg);
                }
                for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
                    for (String msg : main.getConfig().getStringList("Msg")) {
                        if (main.getConfig().getBoolean("only-ops")) {
                            if (onlinePlayers.hasPermission("diamondbrokemessage.getmessage")) {
                                TextComponent message = new TextComponent(ChatColor.AQUA + player.getDisplayName() + " " + msg);
                                message.setColor(ChatColor.AQUA);
                                message.setHoverEvent(new HoverEvent(net.md_5.bungee.api.chat.HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder(player.getDisplayName() + " broke this diamond ore at X: " + player.getLocation().getBlockX() + " Y: " + player.getLocation().getBlockY() + " Z: " + player.getLocation().getBlockZ())).color(ChatColor.GRAY).create()));
                                onlinePlayers.spigot().sendMessage(message);
                            }
                        }
                        if (!(main.getConfig().getBoolean("only-ops"))) {
                            TextComponent message = new TextComponent(ChatColor.AQUA + player.getDisplayName() + " " + msg);
                            message.setColor(ChatColor.AQUA);
                            message.setHoverEvent(new HoverEvent(net.md_5.bungee.api.chat.HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder(player.getDisplayName() + " broke this diamond ore at X: " + player.getLocation().getBlockX() + " Y: " + player.getLocation().getBlockY() + " Z: " + player.getLocation().getBlockZ())).color(ChatColor.GRAY).create()));
                            onlinePlayers.spigot().sendMessage(message);
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