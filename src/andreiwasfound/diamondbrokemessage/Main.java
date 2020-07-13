package andreiwasfound.diamondbrokemessage;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new DiamondOre(), this);
    }

    @Override
    public void onDisable() {

    }
}
