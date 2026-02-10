package mcremake.Server.Init.Minecraft;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ID_Init implements ModInitializer {
    // ебать , регистрация придметав с id игры я вахуи просто пизда
	public static final String MOD_ID = "minecraft";

    // енто тугосеря в консоль
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        //  ну енто короч инециалезация придметав , блокав и блокав-придметав
        Items_Init.initialize();
        Blocks_Init.initialize();



        //высер тугосери в консоль
		LOGGER.info("");
	}
}