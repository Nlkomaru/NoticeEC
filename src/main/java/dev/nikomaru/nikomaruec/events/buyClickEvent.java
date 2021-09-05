package dev.nikomaru.nikomaruec.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

public class buyClickEvent implements Listener {
	
	//購入用のアイテムがクリックされたら購入用GUIに飛ぶ処理をする予定
	@EventHandler
	public void clickEvent(InventoryClickEvent e) {
		
		Player p = (Player) e.getWhoClicked();
		if (e.getView().getTitle().equalsIgnoreCase(ChatColor.GREEN + "物品購入所")) {
			if (e.getClickedInventory() != null) {
				InventoryType inv = e.getClickedInventory().getType();
				if (inv == InventoryType.CHEST) {
					int i = e.getSlot();
					
					e.setCancelled(true);
				}
			}
		}
	}
}