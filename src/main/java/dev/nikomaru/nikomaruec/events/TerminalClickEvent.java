package dev.nikomaru.nikomaruec.events;

import dev.nikomaru.nikomaruec.GUI.BuyChestGUI;
import dev.nikomaru.nikomaruec.GUI.SellChestGUI;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class TerminalClickEvent implements Listener {

    @EventHandler
    public void clickEvent(InventoryClickEvent e){

        Player p = (Player) e.getWhoClicked ();
        if (e.getView ().getTitle().equalsIgnoreCase(ChatColor.AQUA + "Custom GUI")) {
            if(e.getSlot ()==0){
                BuyChestGUI buy = new BuyChestGUI ();
                p.openInventory (buy.Buy(p));
            }else if(e.getSlot ()==1){
                SellChestGUI sell = new SellChestGUI ();
                p.openInventory (sell.Sell(p));
            }else if(e.getSlot ()==8){
                p.closeInventory();
            }
            e.setCancelled (true);

        }
    }
}
