package mcremake.Server.Util;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.item.CreativeModeTabs;

public class CreativeTabRedstoneBlocksModify {

    public static void init() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.REDSTONE_BLOCKS)
            .register(entries -> {

                entries.getDisplayStacks().clear();// вкладка отображения
                entries.getSearchTabStacks().clear();// вкладка поиска





            }
        );
    }
}