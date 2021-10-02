package dev.nikomaru.nikomaruec.events;

import dev.nikomaru.nikomaruec.utils.MakeGUI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class SellCloseEvent implements Listener {
	
	@EventHandler
	public void InventoryCloseEvent (@NotNull InventoryCloseEvent e) {
		Player p = (Player) e.getPlayer ();
		MakeGUI makegui = new MakeGUI ();
		if (e.getView ().title ().equals (makegui.getSellChest ())) {
			e.getInventory ();
			InventoryType inv = e.getInventory ().getType ();
			if (inv == InventoryType.CHEST) {
				
				if (e.getInventory ().getItem (3) != null) {
					
					p.getInventory ().addItem (Objects.requireNonNull (e.getInventory ().getItem (3)));
				}
			}
		}
	}
}
