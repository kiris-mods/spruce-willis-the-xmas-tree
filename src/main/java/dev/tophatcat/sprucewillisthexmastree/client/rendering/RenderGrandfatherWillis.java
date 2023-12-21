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
package dev.tophatcat.sprucewillisthexmastree.client.rendering;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.tophatcat.sprucewillisthexmastree.SpruceWillisTheXmasTree;
import dev.tophatcat.sprucewillisthexmastree.client.models.ModelGrandfatherWillis;
import dev.tophatcat.sprucewillisthexmastree.entities.EntityGrandfatherWillis;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class RenderGrandfatherWillis extends MobRenderer<EntityGrandfatherWillis,
        ModelGrandfatherWillis<EntityGrandfatherWillis>> {

    private static final ResourceLocation RESOURCE_LOCATION = new ResourceLocation(SpruceWillisTheXmasTree.MOD_ID,
        "textures/entity/spruce_willis_the_xmas_tree.png");

    public RenderGrandfatherWillis(EntityRendererProvider.Context context) {
        super(context, new ModelGrandfatherWillis<>(
                context.bakeLayer(ModelGrandfatherWillis.LAYER_LOCATION)), 0.8F);
    }

    protected void scale(@NotNull EntityGrandfatherWillis entity, @NotNull PoseStack matrixStack,
                         float partialTickTime) {
        matrixStack.scale(2.5F, 2.5F, 2.5F);
    }

    @NotNull
    @Override
    public ResourceLocation getTextureLocation(@NotNull final EntityGrandfatherWillis entity) {
        return RESOURCE_LOCATION;
    }
}
