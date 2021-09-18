package dev.nikomaru.nikomaruec.gui.ec;

import dev.nikomaru.nikomaruec.NikomaruEC;
import dev.nikomaru.nikomaruec.utils.MakeGUI;
import dev.nikomaru.nikomaruec.utils.SetItemData;
import dev.nikomaru.nikomaruec.utils.StockDataList;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import static dev.nikomaru.nikomaruec.utils.StockDataList.getPlayerNowStockNum;


@SuppressWarnings({"ALL", "DuplicatedCode"})
public class NowStockChestGUI {

    // 未来へのヒント indexOf()を使用すること
    final SetItemData setItemData = new SetItemData();

    public Inventory nowPlayerStock(Player p, int pages) {

        MakeGUI makegui = new MakeGUI();
        Inventory gui = Bukkit.createInventory(p, 54, makegui.getNowStockChest());
        int i = 0;
        int num = 45;
        int j = 0;
        getPlayerNowStockNum().remove(p.getUniqueId());
        HashMap<Integer, Integer> stockNum = new HashMap<>();
        while (i < num) {

            int itemNum = (pages - 1) * 45 + i;

            if (NikomaruEC.getStocks().size() > itemNum) {
                List<Object> stock = NikomaruEC.getStocks().get(itemNum);



                Player Seller = (Player) Bukkit.getOfflinePlayer((UUID) stock.get(1));


                if (stock.get(1).equals(p.getUniqueId())) {



                    stockNum.put(i, j);
                    getPlayerNowStockNum().put(p.getUniqueId(), stockNum);

                    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
                    String limitTime = format.format((ZonedDateTime) stock.get(4));

                    // {itemStack} {player uuid} {price} {description} {time}

                    ItemStack item = (ItemStack) stock.get(0);
                    String name = Seller.getName();
                    String price = Long.valueOf((long) stock.get(2)).toString();
                    String description = (String) stock.get(3);

                    gui.setItem(i, setItemData.getSellerItem(item, name, price, limitTime, description));


                    StockDataList.getPlayerNowStockNum().put(p.getUniqueId(),stockNum);
                    j++;
                }
            } else {
                gui.setItem(i, setItemData.getNoDataGlassItem());

            }
            i++;
        }
        gui.setItem(45, setItemData.getPrevItem());
        gui.setItem(46, setItemData.getReloadItem());
        gui.setItem(47, setItemData.getNextItem());
        gui.setItem(48, setItemData.getLeftoversItem());
        gui.setItem(49, setItemData.getStoreItem());
        gui.setItem(50, setItemData.getBuyHistoryItem());
        gui.setItem(51, setItemData.getSellHistoryItem());
        gui.setItem(52, setItemData.getTerminalItem());
        gui.setItem(53, setItemData.getCloseItem());


        return gui;

    }

    @NotNull
    private SetItemData getSetItemData() {
        return setItemData;
    }
}
