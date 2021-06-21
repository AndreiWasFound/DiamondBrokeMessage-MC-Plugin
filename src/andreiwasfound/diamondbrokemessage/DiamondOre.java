package andreiwasfound.diamondbrokemessage;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class DiamondOre implements Listener {

    private Main main;

    public DiamondOre(Main main) {
        this.main = main;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        if (e.getBlock().getType().equals(Material.DIAMOND_ORE)) {
                Block block = e.getBlock();
                Player player = e.getPlayer();

                if (!(main.getConfig().getBoolean("only-console"))) {
                    for (String msg : main.getConfig().getStringList("Msg")) {
                        main.printToConsole(player.getDisplayName() + " " + msg);
                    }
                    for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
                        for (String msg : main.getConfig().getStringList("Msg")) {
                            if (main.getConfig().getBoolean("only-ops")) {
                                if (onlinePlayers.hasPermission("diamondbrokemessage.getmessage")) {
                                    TextComponent message = new TextComponent(ChatColor.AQUA + player.getDisplayName() + " " + msg);
                                    message.setColor(ChatColor.AQUA);
                                    message.setHoverEvent(new HoverEvent(net.md_5.bungee.api.chat.HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder(player.getDisplayName() + " broke this diamond ore at X: " + block.getLocation().getBlockX() + " Y: " + block.getLocation().getBlockY() + " Z: " + block.getLocation().getBlockZ())).color(ChatColor.GRAY).create()));
                                    onlinePlayers.spigot().sendMessage(message);
                                }
                            }
                            if (!(main.getConfig().getBoolean("only-ops"))) {
                                TextComponent message = new TextComponent(ChatColor.AQUA + player.getDisplayName() + " " + msg);
                                message.setColor(ChatColor.AQUA);
                                message.setHoverEvent(new HoverEvent(net.md_5.bungee.api.chat.HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder(player.getDisplayName() + " broke this diamond ore at X: " + block.getLocation().getBlockX() + " Y: " + block.getLocation().getBlockY() + " Z: " + block.getLocation().getBlockZ())).color(ChatColor.GRAY).create()));
                                onlinePlayers.spigot().sendMessage(message);
                            }
                        }
                    }
                }

                if (main.getConfig().getBoolean("only-console")) {
                    for (String msg : main.getConfig().getStringList("Msg")) {
                        main.printToConsole(player.getDisplayName() + " " + msg + " broke this diamond ore at X: " + block.getLocation().getBlockX() + " Y: " + block.getLocation().getBlockY() + " Z: " + block.getLocation().getBlockZ());
                    }
                }
            }


        if (e.getBlock().getType().equals(Material.DEEPSLATE_DIAMOND_ORE)) {
            Block block = e.getBlock();
            Player player = e.getPlayer();

            if (!(main.getConfig().getBoolean("only-console"))) {
                for (String msg : main.getConfig().getStringList("Msg")) {
                    main.printToConsole(player.getDisplayName() + " " + msg);
                }
                for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
                    for (String msg : main.getConfig().getStringList("Msg")) {
                        if (main.getConfig().getBoolean("only-ops")) {
                            if (onlinePlayers.hasPermission("diamondbrokemessage.getmessage")) {
                                TextComponent message = new TextComponent(ChatColor.AQUA + player.getDisplayName() + " " + msg);
                                message.setColor(ChatColor.AQUA);
                                message.setHoverEvent(new HoverEvent(net.md_5.bungee.api.chat.HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder(player.getDisplayName() + " broke this diamond ore at X: " + block.getLocation().getBlockX() + " Y: " + block.getLocation().getBlockY() + " Z: " + block.getLocation().getBlockZ())).color(ChatColor.GRAY).create()));
                                onlinePlayers.spigot().sendMessage(message);
                            }
                        }
                        if (!(main.getConfig().getBoolean("only-ops"))) {
                            TextComponent message = new TextComponent(ChatColor.AQUA + player.getDisplayName() + " " + msg);
                            message.setColor(ChatColor.AQUA);
                            message.setHoverEvent(new HoverEvent(net.md_5.bungee.api.chat.HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder(player.getDisplayName() + " broke this diamond ore at X: " + block.getLocation().getBlockX() + " Y: " + block.getLocation().getBlockY() + " Z: " + block.getLocation().getBlockZ())).color(ChatColor.GRAY).create()));
                            onlinePlayers.spigot().sendMessage(message);
                        }
                    }
                }
            }

            if (main.getConfig().getBoolean("only-console")) {
                for (String msg : main.getConfig().getStringList("Msg")) {
                    main.printToConsole(player.getDisplayName() + " " + msg + " broke this diamond ore at X: " + block.getLocation().getBlockX() + " Y: " + block.getLocation().getBlockY() + " Z: " + block.getLocation().getBlockZ());
                }
            }
        }
        }
    }
