/*
 * NoticeEC
 *
 * Written in 2021 by nikomaru
 *
 * To the extent possible under law, the author(s) have dedicated all copyright and related and neighboring rights to this software to the public domain worldwide. This software is distributed without any warranty.
 *
 * You should have received a copy of the CC0 Public Domain Dedication along with this software. If not, see <http://creativecommons.org/publicdomain/zero/1.0/>.
 */

package dev.nikomaru.noticeec.files.stocks;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.UUID;

public class ReadStockData {
    //アイテムのデータを取得する処理をする予定
    public static ArrayList<ArrayList<Object>> readData () {

        // {itemStack} {player uuid} {price} {description} {time}

        String path = "plugins\\NoticeEC\\stock.dat";

        ArrayList<ArrayList<Object>> storeStocks = new ArrayList<> ();
        ArrayList<ArrayList<Object>> restoreStocks = new ArrayList<> ();

        File file = new File (path);
        if (!file.exists ()) {
            return restoreStocks;
        }
        try {
            ObjectInputStream objInStream = new ObjectInputStream (new FileInputStream (path));
            SerializableStock ss = (SerializableStock) objInStream.readObject ();

            objInStream.close ();
            storeStocks = ss.getStocks ();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace ();
        }
        // {itemStack} {player uuid} {price} {description} {time}

        for (ArrayList<Object> objects : storeStocks) {
            ArrayList<Object> stock = new ArrayList<> ();

            String item = objects.get (0).toString ();
            UUID uuid = (UUID) objects.get (1);
            Long price = (Long) objects.get (2);
            String description = objects.get (3).toString ();
            ZonedDateTime time = (ZonedDateTime) objects.get (4);

            stock.add (item);
            stock.add (uuid);
            stock.add (price);
            stock.add (description);
            stock.add (time);

            restoreStocks.add (stock);
        }

        return restoreStocks;
    }
}
