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
package dev.tophatcat.sprucewillisthexmastree.client.rendering;

import dev.tophatcat.sprucewillisthexmastree.SpruceWillisTheXmasTree;
import dev.tophatcat.sprucewillisthexmastree.client.SpruceClientInit;
import dev.tophatcat.sprucewillisthexmastree.client.models.ModelSpruceWillis;
import dev.tophatcat.sprucewillisthexmastree.entities.EntitySpruceWillis;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

public class RenderSpruceWillis extends MobEntityRenderer<EntitySpruceWillis, ModelSpruceWillis<EntitySpruceWillis>> {

    public RenderSpruceWillis(EntityRendererFactory.Context context) {
        super(context, new ModelSpruceWillis<>(
                context.getPart(SpruceClientInit.LAYER_LOCATION)), 0.8F);
    }

    @NotNull
    @Override
    public Identifier getTexture(@NotNull final EntitySpruceWillis entity) {
        return new Identifier(SpruceWillisTheXmasTree.MOD_ID, "textures/entity/spruce_willis_the_xmas_tree.png");
    }
}
