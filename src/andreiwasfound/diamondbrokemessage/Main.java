package andreiwasfound.diamondbrokemessage;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new DiamondOre(this), this);
        saveDefaultConfig();
        this.getCommand("diamondbrokemessage").setTabCompleter(new CommandTabCompleter());
    }

    @Override
    public void onDisable() {

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("diamondbrokemessage")) {
            if (!sender.hasPermission("diamondbrokemessage.reload")) {
                sender.sendMessage(ChatColor.RED + "You don't have permission to run this command.");
                return true;
            }
            if (args.length == 0) {
                sender.sendMessage(ChatColor.RED + "Usage: /diamondbrokemessage reload");
                return true;
            }
            if (args.length > 0) {
                if (args[0].equalsIgnoreCase("reload")) {
                    reloadConfig();
                    sender.sendMessage(ChatColor.RED + "[DiamondBrokeMessage] DiamondBrokeMessage has been reloaded");
                }
            }
        }
        return false;
    }
}
