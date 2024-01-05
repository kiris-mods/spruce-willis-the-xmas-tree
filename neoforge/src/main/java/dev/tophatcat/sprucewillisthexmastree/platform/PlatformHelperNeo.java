package dev.tophatcat.sprucewillisthexmastree.platform;

import dev.tophatcat.sprucewillisthexmastree.WillisCommon;
import dev.tophatcat.sprucewillisthexmastree.platform.services.IPlatformHelper;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLLoader;

public class PlatformHelperNeo implements IPlatformHelper {

    @Override
    public String getPlatformName() {
        return "NeoForge";
    }

    @Override
    public boolean isModLoaded(String modId) {
        return ModList.get().isLoaded(WillisCommon.MOD_ID);
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return !FMLLoader.isProduction();
    }
}
