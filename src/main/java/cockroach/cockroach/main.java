package cockroach.cockroach;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class main extends JavaPlugin {

    public static main plugin;
    public static main instance;
    public main(){instance = this;}
    public static main getInstance(){return instance;}
    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        Bukkit.getPluginManager().registerEvents(new EventListener(),this);
        super.onEnable();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static main getPlugin(){
        return plugin;
    }
}
