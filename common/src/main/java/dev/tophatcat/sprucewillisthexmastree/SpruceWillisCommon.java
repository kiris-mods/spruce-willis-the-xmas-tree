/*
 * A Minecraft mod made for WinterJam 2019, contains an Xmas tree named Spruce Willis.
 * Copyright (C) KiriCattus 2013 - 2025
 * https://github.com/kiris-mods/spruce-willis-the-xmas-tree/blob/dev/LICENSE.md
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE
 */
package dev.tophatcat.sprucewillisthexmastree;

import dev.tophatcat.sprucewillisthexmastree.entities.GrandfatherWillis;
import dev.tophatcat.sprucewillisthexmastree.entities.SpruceWillis;
import dev.tophatcat.sprucewillisthexmastree.platform.IPlatform;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ambient.AmbientCreature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ServiceLoader;
import java.util.function.Supplier;

public class SpruceWillisCommon {

    public static final String MOD_ID = "sprucewillisthexmastree";
    public static final String MOD_NAME = "Spruce Willis the Xmas Tree";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);
    public static final IPlatform COMMON_PLATFORM = ServiceLoader.load(IPlatform.class).findFirst().orElseThrow();

    public static Supplier<EntityType<SpruceWillis>> SPRUCE_WILLIS = null;
    public static Supplier<EntityType<GrandfatherWillis>> GRANDFATHER_WILLIS = null;

    public static void init() {
        LOG.debug("We are currently loaded via the {} mod loader in a {} environment!",
            COMMON_PLATFORM.getPlatformName(), COMMON_PLATFORM.getEnvironmentName());
    }

    public static AttributeSupplier.Builder createWillisAttributes() {
        return AmbientCreature.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 40.0D)
            .add(Attributes.MOVEMENT_SPEED, 0.25D);
    }

    public static AttributeSupplier.Builder createGrandfatherWillisAttributes() {
        return AmbientCreature.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 75.0D)
            .add(Attributes.MOVEMENT_SPEED, 0.20D);
    }
}
