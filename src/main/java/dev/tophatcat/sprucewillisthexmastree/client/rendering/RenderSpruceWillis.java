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
package dev.tophatcat.sprucewillisthexmastree.client.rendering;

import dev.tophatcat.sprucewillisthexmastree.SpruceWillisTheXmasTree;
import dev.tophatcat.sprucewillisthexmastree.client.models.SpruceWillisModel;
import dev.tophatcat.sprucewillisthexmastree.entities.SpruceWillisEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;

public class RenderSpruceWillis extends MobRenderer<SpruceWillisEntity, SpruceWillisModel> {

    private static final ResourceLocation RESOURCE_LOCATION = new ResourceLocation(SpruceWillisTheXmasTree.MOD_ID,
        "textures/entity/spruce_willis_the_xmas_tree.png");

    public RenderSpruceWillis(EntityRendererManager rendererManager) {
        super(rendererManager, new SpruceWillisModel(), 0.8F);
    }

    @Nonnull
    @Override
    public ResourceLocation getTextureLocation(@Nonnull final SpruceWillisEntity entity) {
        return RESOURCE_LOCATION;
    }
}
