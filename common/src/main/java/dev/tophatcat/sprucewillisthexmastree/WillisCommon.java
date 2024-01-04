package dev.tophatcat.sprucewillisthexmastree;

import dev.tophatcat.sprucewillisthexmastree.entities.GrandfatherWillis;
import dev.tophatcat.sprucewillisthexmastree.entities.SpruceWillis;
import dev.tophatcat.sprucewillisthexmastree.platform.Services;
import net.minecraft.world.entity.EntityType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Supplier;

public class WillisCommon {

    public static final String MOD_ID = "sprucewillisthexmastree";
    public static final String MOD_NAME = "Spruce Willis the Xmas Tree";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);

    public static Supplier<EntityType<SpruceWillis>> SPRUCE_WILLIS = null;
    public static Supplier<EntityType<GrandfatherWillis>> GRANDFATHER_WILLIS = null;

    public static void init() {
        LOG.debug("We are currently loaded via the {} mod loader in a {} environment!",
            Services.PLATFORM.getPlatformName(), Services.PLATFORM.getEnvironmentName());
    }
}
