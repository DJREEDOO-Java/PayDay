package de.djreedoo.payday.commands;

import de.djreedoo.payday.main.PayDay;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PayDayCommand implements CommandExecutor {
    private PayDay plugin;
    public PayDayCommand(PayDay plugin){
        this.plugin = plugin;
        plugin.getCommand("pay").setExecutor(this);

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender instanceof Player){
            Player p = (Player)sender;
            if(args[0].equalsIgnoreCase("tag")){
                if (PayDay.eco.getBalance(p) < 1000) {
                    p.sendMessage("§cDu hast nicht genügend Geld du benötigst §a1 Tausend §d€");
                    return false;
                }

                PayDay.eco.withdrawPlayer(p, 1000);
                p.setPlayerTime(12000, true);
                p.sendMessage("§6Du hast soeben für §2Tag §6bezahlt vielen Dank!");
            }

            if(args[0].equalsIgnoreCase("nacht")){
                if (PayDay.eco.getBalance(p) < 1000) {
                    p.sendMessage("§cDu hast nicht genügend Geld du benötigst §a1 Tausend §d€");
                    return false;

                }
                PayDay.eco.withdrawPlayer(p, 1000);
                p.setPlayerTime(45000, true);
                p.sendMessage("§6Du hast soeben für §2Nacht §6bezahlt vielen Dank!");
            }
        }
        return false;
    }
}
