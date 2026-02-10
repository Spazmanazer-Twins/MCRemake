package mcremake.Server.Init.MCRemake;

import mcremake.Server.Util.*;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ID_Init implements ModInitializer {
	public static final String MOD_ID = "mcremake";

    // енто тугосеря в консоль
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        //  ну енто короч инециалезация придметав , блокав и блокав-придметав
        Items_Init.initialize();
        Blocks_Init.initialize();

        // ето модифи ванильных вкладак творчедроче режима
        CreativeTabBuildingBlocksModify.init();
        CreativeTabColoredBlocksModify.init();
        CreativeTabNaturalBlocksModify.init();
        CreativeTabFunctionalBlocksModify.init();
        CreativeTabRedstoneBlocksModify.init();
        CreativeTabToolsAndUtilitiesModify.init();
        CreativeTabCombatModify.init();
        CreativeTabFoodAndDrinksModify.init();
        CreativeTabIngredientsModify.init();
        CreativeTabSpawnEggsModify.init();
        CreativeTabSearchModify.init();
        CreativeTabOperatorModify.init();





        //высер тугосери в консоль
		LOGGER.info("");
	}
}