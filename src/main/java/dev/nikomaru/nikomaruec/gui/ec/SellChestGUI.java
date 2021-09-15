package dev.nikomaru.nikomaruec.gui.ec;

import dev.nikomaru.nikomaruec.utils.MakeGUI;
import dev.nikomaru.nikomaruec.utils.SetItemData;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class SellChestGUI {

    //販売用のGUIを作成する処理をする予定
    public Inventory Sell(Player p) {

        MakeGUI makegui = new MakeGUI();
        Inventory gui = makegui.getGui(p, 9, "物品販売所", 251, 107, 255);

        SetItemData setItemData = new SetItemData();

        gui.setItem(0, setItemData.getSetItemGlassItem());
        gui.setItem(1, setItemData.getSetItemGlassItem());
        gui.setItem(2, setItemData.getSetItemGlassItem());
        gui.setItem(4, setItemData.getSetItemGlassItem());
        gui.setItem(5, setItemData.getSetItemGlassItem());
        gui.setItem(6, setItemData.getSetItemGlassItem());
        gui.setItem(7, setItemData.getAcceptItem());
        gui.setItem(8, setItemData.getCloseItem());

        return gui;
    }

}