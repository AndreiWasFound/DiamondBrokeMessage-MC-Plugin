package andreiwasfound.diamondbrokemessage;

import andreiwasfound.diamondbrokemessage.Commands.ReloadConfig;
import andreiwasfound.diamondbrokemessage.Utilities.CommandTabCompleter;
import andreiwasfound.diamondbrokemessage.Utilities.MetricsLite;
import andreiwasfound.diamondbrokemessage.Utilities.UpdateChecker;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        printToConsole("Commands are trying to register");
        registerCommands();
        printToConsole("Commands have been registered successfully");
        printToConsole("Events are trying to register");
        registerEvents();
        printToConsole("Events have been registered successfully");
        printToConsole("Config.yml is trying to register");
        saveDefaultConfig();
        printToConsole("Config.yml has been registered successfully");
        printToConsole("bStats is trying to register");
        int pluginId = 8254;
        MetricsLite metrics = new MetricsLite(this, pluginId);
        printToConsole("bStats has been registered successfully");
        printToConsole("UpdateChecker is trying to register");
        updateChecker();
        printToConsole("UpdateChecker has been registered successfully");
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
            pm.registerEvents(new JoinUpdateMessage(this), this);
        if (getServer().getVersion().contains("1.17")) {
            pm.registerEvents(new DeepslateDiamondOre(this), this);
        }
    }

    public void printToConsole(String msg) {
        this.getServer().getConsoleSender().sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "DiamondBrokeMessage" + ChatColor.DARK_GRAY + "]" + ChatColor.RESET + " " + msg);
    }

    public void updateChecker() {
        new UpdateChecker(this, 80958).getLatestVersion(version -> {
            if (this.getDescription().getVersion().equalsIgnoreCase(version)) {
                printToConsole("DiamondBrokeMessage is up to date!");
            } else {
                printToConsole("DiamondBrokeMessage is outdated!");
                printToConsole("Newest version: " + version);
                printToConsole("Your version: " + pluginymlVersion);
                printToConsole("Please Update Here: " + pluginymlWebsite);
            }
        });
    }

    PluginDescriptionFile pluginyml = this.getDescription();
    String pluginymlVersion = pluginyml.getVersion();
    String pluginymlWebsite = pluginyml.getWebsite();
}
