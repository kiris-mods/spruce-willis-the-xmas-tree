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
package dev.tophatcat.sprucewillisthexmastree.client.rendering;

import dev.tophatcat.sprucewillisthexmastree.WillisCommon;
import dev.tophatcat.sprucewillisthexmastree.client.models.SpruceWillisModel;
import dev.tophatcat.sprucewillisthexmastree.entities.SpruceWillis;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class SpruceWillisRenderer extends MobRenderer<SpruceWillis, SpruceWillisModel<SpruceWillis>> {

    public SpruceWillisRenderer(EntityRendererProvider.Context context) {
        super(context, new SpruceWillisModel<>(
                context.bakeLayer(SpruceWillisModel.LAYER_LOCATION)), 0.8F);
    }

    @NotNull
    @Override
    public ResourceLocation getTextureLocation(@NotNull SpruceWillis entity) {
        return ResourceLocation.fromNamespaceAndPath(WillisCommon.MOD_ID,
            "textures/entity/spruce_willis_the_xmas_tree.png");
    }
}
