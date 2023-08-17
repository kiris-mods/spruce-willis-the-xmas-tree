/*
 * Spruce Willis the Xmas Tree - https://github.com/tophatcats-mods/spruce-willis-the-xmas-tree
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
import dev.tophatcat.sprucewillisthexmastree.client.models.ModelSpruceWillis;
import dev.tophatcat.sprucewillisthexmastree.client.rendering.RenderGrandfatherWillis;
import dev.tophatcat.sprucewillisthexmastree.client.rendering.RenderSpruceWillis;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class SpruceClientInit implements ClientModInitializer {

    public static final EntityModelLayer LAYER_LOCATION = new EntityModelLayer(
            new Identifier(SpruceWillisTheXmasTree.MOD_ID, "spruce_willis_the_xmas_tree"),
            "main");

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(SpruceWillisTheXmasTree.SPRUCE_WILLIS_THE_XMAS_TREE,
                RenderSpruceWillis::new);
        EntityModelLayerRegistry.registerModelLayer(LAYER_LOCATION, ModelSpruceWillis::getTextureModelData);
        EntityRendererRegistry.register(SpruceWillisTheXmasTree.GRANDFATHER_SPRUCE_WILLIS,
                RenderGrandfatherWillis::new);
    }
}
