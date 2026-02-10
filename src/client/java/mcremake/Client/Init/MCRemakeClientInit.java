package mcremake.Client.Init;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static mcremake.Server.Init.MCRemake.ID_Init.MOD_ID;

public class MCRemakeClientInit implements ClientModInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitializeClient() {
        LOGGER.info("");
        
    }
}
