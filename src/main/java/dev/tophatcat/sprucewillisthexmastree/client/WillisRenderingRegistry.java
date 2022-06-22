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
package dev.tophatcat.sprucewillisthexmastree.client;

import dev.tophatcat.sprucewillisthexmastree.SpruceWillisTheXmasTree;
import dev.tophatcat.sprucewillisthexmastree.client.rendering.RenderGrandfatherWillis;
import dev.tophatcat.sprucewillisthexmastree.client.rendering.RenderSpruceWillis;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;

/**
 * The rendering class for this mod.
 */
@SuppressWarnings("unused")
@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = SpruceWillisTheXmasTree.MOD_ID,
    bus = Mod.EventBusSubscriber.Bus.MOD)
public class WillisRenderingRegistry {

    /**
     * Register our things for rendering.
     */
    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(SpruceWillisTheXmasTree.SPRUCE_WILLIS_THE_XMAS_TREE,
            RenderSpruceWillis::new);
        RenderingRegistry.registerEntityRenderingHandler(SpruceWillisTheXmasTree.GRANDFATHER_SPRUCE_WILLIS,
            RenderGrandfatherWillis::new);
    }
}
