package dev.nikomaru.nikomaruec.events.click;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

public class sellClickEvent implements Listener {
    //販売用のアイテムがクリックされたら販売用GUIに飛ぶ処理をする予定
    @EventHandler public void clickEvent (InventoryClickEvent e) {

        Player p = (Player) e.getWhoClicked ();
        if (e.getView ().getTitle ().equalsIgnoreCase (ChatColor.RED + "Sell GUI")
                && Objects.requireNonNull (e.getClickedInventory ()).getType () == InventoryType.CHEST) {

            int s = e.getSlot ();

            if (0 <= s && s <= 2 || 4 <= s && s <= 8) {

                if (s == 8) {
                    p.closeInventory ();

                } else if (s == 7) {

                    ItemStack item = Objects.requireNonNull (e.getClickedInventory ()).getItem (4);
                    if (item != null) {
                        p.closeInventory ();
                        List<Object> data = new ArrayList<> ();
                        data.add (item);
                        //NikomaruECのYoutubeでもみろ

                    }
                    e.setCancelled (true);
                }
            }

        }
    }

}
