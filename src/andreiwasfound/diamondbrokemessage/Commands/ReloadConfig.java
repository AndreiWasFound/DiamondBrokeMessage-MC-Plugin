package andreiwasfound.diamondbrokemessage.Commands;

import andreiwasfound.diamondbrokemessage.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadConfig implements CommandExecutor {

    private final Main main;
    public ReloadConfig(Main main) {
        this.main = main;
    }

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
                    if (sender.hasPermission("diamondbrokemessage.reload")) {
                    main.reloadConfig();
                    sender.sendMessage(ChatColor.RED + "DiamondBrokeMessage config has been reloaded");
                    main.printToConsole(ChatColor.RED + "DiamondBrokeMessage config has been reloaded");
                    return true;
                    }
                }
            }
        }
        return false;
    }
}
