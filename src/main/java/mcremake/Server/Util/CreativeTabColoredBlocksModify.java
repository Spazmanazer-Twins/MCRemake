package mcremake.Server.Util;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.CreativeModeTabs;

public class CreativeTabColoredBlocksModify {

    public static void init() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COLORED_BLOCKS)
            .register(entries -> {

                entries.getDisplayStacks().clear();// вкладка отображения
                entries.getSearchTabStacks().clear();// вкладка поиска





            }
        );
    }
}