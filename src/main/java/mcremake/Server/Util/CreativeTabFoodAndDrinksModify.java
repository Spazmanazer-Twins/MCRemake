package mcremake.Server.Util;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.item.CreativeModeTabs;

public class CreativeTabFoodAndDrinksModify {

    public static void init() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS)
            .register(entries -> {

                entries.getDisplayStacks().clear();// вкладка отображения
                entries.getSearchTabStacks().clear();// вкладка поиска





            }
        );
    }
}