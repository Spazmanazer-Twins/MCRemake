package mcremake.Server.Util;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.item.CreativeModeTabs;

public class CreativeTabSearchModify {

    public static void init() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.SEARCH);
    }
}