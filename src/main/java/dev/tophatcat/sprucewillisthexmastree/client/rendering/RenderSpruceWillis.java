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
import dev.tophatcat.sprucewillisthexmastree.common.entities.SpruceWillisEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

/**
 * Render the spruce willis model and texture.
 */
@OnlyIn(Dist.CLIENT)
public class RenderSpruceWillis extends MobRenderer<SpruceWillisEntity, SpruceWillisModel> {

    /**
     * The location of the texture for the entity.
     */
    private static final ResourceLocation resourceLocation = new ResourceLocation(SpruceWillisTheXmasTree.MOD_ID,
        "textures/entity/spruce_willis_the_xmas_tree.png");

    /**
     * @param rendererManager The render manager for entities.
     */
    public RenderSpruceWillis(EntityRendererManager rendererManager) {
        super(rendererManager, new SpruceWillisModel(), 0.8F);
    }

    /**
     * Can the entity's name be rendered above the entity.
     *
     * @param entity The entity itself.
     * @return true, false or entity.hasCustomName();
     */
    @Override
    protected boolean canRenderName(SpruceWillisEntity entity) {
        return entity.hasCustomName();
    }

    /**
     * Get the entity's texture location.
     *
     * @param entity The entity itself.
     * @return The resource location for the texture.
     */
    @Nonnull
    @Override
    public ResourceLocation getEntityTexture(@Nonnull SpruceWillisEntity entity) {
        return resourceLocation;
    }
}
