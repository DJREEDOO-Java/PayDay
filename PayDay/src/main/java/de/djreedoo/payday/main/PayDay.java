package de.djreedoo.payday.main;

import de.djreedoo.payday.commands.PayDayCommand;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
//Programmiert von DJREEDOO
//Codet from DJREEDOO

public class PayDay extends JavaPlugin {
    public static PayDay instance;
    public static Economy eco = null;

    public static PayDay getInstance() {
        return PayDay.instance;
    }

    public void onEnable(){
        Bukkit.getConsoleSender().sendMessage("§2Payday aktiviert");
        instance = this;
        commands();
        if(!setupEconomy()){
            Bukkit.shutdown();
        }
    }

    public boolean setupEconomy(){
        RegisteredServiceProvider<Economy> economyprovider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if(economyprovider !=  null){
            eco = economyprovider.getProvider();
        }
        return (eco != null);
    }

    public void commands(){
        new PayDayCommand(this);
    }

    public void onDisable(){
        Bukkit.getConsoleSender().sendMessage("§2Payday deaktiviert");
    }

}
