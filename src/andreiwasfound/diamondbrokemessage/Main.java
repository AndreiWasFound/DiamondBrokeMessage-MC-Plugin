package andreiwasfound.diamondbrokemessage;

import andreiwasfound.diamondbrokemessage.Commands.ReloadConfig;
import andreiwasfound.diamondbrokemessage.Utilities.CommandTabCompleter;
import andreiwasfound.diamondbrokemessage.Utilities.MetricsLite;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        printToConsole("Commands are trying to register");
        registerCommands();
        printToConsole("Commands have been registered successfully");
        printToConsole("Events are trying to register");
        registerEvents();
        printToConsole("Events have been registered successfully");
        saveDefaultConfig();

        int pluginId = 8254;
        MetricsLite metrics = new MetricsLite(this, pluginId);
    }

    @Override
    public void onDisable() {

    }

    public void registerCommands() {
        getCommand("diamondbrokemessage").setExecutor(new ReloadConfig(this));
        getCommand("diamondbrokemessage").setTabCompleter(new CommandTabCompleter());
    }

    private void registerEvents() {
        PluginManager pm = this.getServer().getPluginManager();
            pm.registerEvents(new DiamondOre(this), this);
    }

    public String chatPrepend() {
        return ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "DiamondBrokeMessage" + ChatColor.DARK_GRAY + "]" + ChatColor.RESET + " ";
    }
    public void printToConsole(String msg) {
        this.getServer().getConsoleSender().sendMessage(this.chatPrepend() + msg);
    }
}
