/*
 * Spruce Willis the Xmas Tree - https://github.com/tophatcats-mods/spruce-willis-the-xmas-tree
 * Copyright (C) 2016-2022 <KiriCattus>
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation;
 * Specifically version 2.1 of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301
 * USA
 * https://www.gnu.org/licenses/old-licenses/lgpl-2.1.html
 */
package dev.tophatcat.sprucewillisthexmastree;

import dev.tophatcat.sprucewillisthexmastree.client.WillisRenderingRegistry;
import dev.tophatcat.sprucewillisthexmastree.init.WillisRegistry;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;

@Mod(SpruceWillisTheXmasTree.MOD_ID)
public class SpruceWillisTheXmasTree {

    public static final String MOD_ID = "sprucewillisthexmastree";

    public SpruceWillisTheXmasTree() {
        IEventBus mod = FMLJavaModLoadingContext.get().getModEventBus();
        WillisRegistry.ENTITIES.register(mod);
        WillisRegistry.ITEMS.register(mod);
        mod.addListener(WillisRegistry::registerAttributes);
        mod.addListener(WillisRegistry::registerSpawns);
        if (FMLEnvironment.dist == Dist.CLIENT) {
            mod.addListener(WillisRenderingRegistry::registerEntityModels);
            mod.addListener(WillisRenderingRegistry::registerLayerDefinition);
            mod.addListener(WillisRegistry::addToCreativeTabs);
        }
    }
}
