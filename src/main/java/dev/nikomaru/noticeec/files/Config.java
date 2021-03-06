/*
 * NoticeEC
 *
 * Written in 2021 by nikomaru
 *
 * To the extent possible under law, the author(s) have dedicated all copyright and related and neighboring rights to this software to the public domain worldwide. This software is distributed without any warranty.
 *
 * You should have received a copy of the CC0 Public Domain Dedication along with this software. If not, see <http://creativecommons.org/publicdomain/zero/1.0/>.
 */

package dev.nikomaru.noticeec.files;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

public class Config {
    //コンフィグから値を取得する処理をする予定
    private final Plugin plugin;
    private FileConfiguration config = null;
    private int addDays;
    private int addHours;
    private long maxPrice;
    private long minPrice;

    public Config (Plugin plugin) {
        this.plugin = plugin;
        load ();
    }

    public void load () {
        // 設定ファイルを保存
        plugin.saveDefaultConfig ();
        if (config != null) {
            plugin.reloadConfig ();
        }
        config = plugin.getConfig ();

        if (!config.isInt ("SetLimit.DaysLater")) {
            config.set ("SetLimit.DaysLater","7");
        }
        if (!config.isInt ("SetLimit.HoursLater")) {
            config.set ("SetLimit.HoursLater","0");
        }
        if (!config.isInt ("Price.Max")) {
            config.set ("Price.Max","1000000");
        }
        if (!config.isInt ("Price.Min")) {
            config.set ("Price.Min","0");
        }
        addDays = config.getInt ("SetLimit.DaysLater");
        addHours = config.getInt ("SetLimit.HoursLater");
        maxPrice = config.getLong ("Price.Max");
        minPrice = config.getLong ("Price.Min");
    }

    public int getAddDays () {
        return this.addDays;
    }

    public int getAddHours () {
        return this.addHours;
    }

    public long getMaxPrice () {
        return this.maxPrice;
    }

    public long getMinPrice () {
        return this.minPrice;
    }
}
