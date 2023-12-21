/*
 * Spruce Willis the Xmas Tree - https://github.com/kiris-mods/spruce-willis-the-xmas-tree
 * Copyright (C) 2013-2023 <KiriCattus>
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
import dev.tophatcat.sprucewillisthexmastree.client.models.ModelGrandfatherWillis;
import dev.tophatcat.sprucewillisthexmastree.client.models.ModelSpruceWillis;
import dev.tophatcat.sprucewillisthexmastree.client.rendering.RenderGrandfatherWillis;
import dev.tophatcat.sprucewillisthexmastree.client.rendering.RenderSpruceWillis;
import net.minecraftforge.client.event.EntityRenderersEvent;

public class SpruceClientInit {

    public static void registerEntityModels(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(SpruceWillisTheXmasTree.SPRUCE_WILLIS_THE_XMAS_TREE.get(),
            RenderSpruceWillis::new);
        event.registerEntityRenderer(SpruceWillisTheXmasTree.GRANDFATHER_SPRUCE_WILLIS.get(),
            RenderGrandfatherWillis::new);
    }

    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModelSpruceWillis.LAYER_LOCATION,
            ModelSpruceWillis::createBodyLayer);
        event.registerLayerDefinition(ModelGrandfatherWillis.LAYER_LOCATION,
            ModelGrandfatherWillis::createBodyLayer);
    }
}
