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

import dev.tophatcat.sprucewillisthexmastree.SpruceWillisCommon;
import dev.tophatcat.sprucewillisthexmastree.client.WillisRenderState;
import dev.tophatcat.sprucewillisthexmastree.client.models.GrandfatherWillisModel;
import dev.tophatcat.sprucewillisthexmastree.entities.GrandfatherWillis;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import org.jetbrains.annotations.NotNull;

public class GrandfatherWillisRenderer extends MobRenderer<GrandfatherWillis, WillisRenderState,
    GrandfatherWillisModel> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
        Identifier.fromNamespaceAndPath(SpruceWillisCommon.MOD_ID, "spruce_willis_the_xmas_tree"), "main");

    private static final Identifier TEXTURE_LOCATION = Identifier.fromNamespaceAndPath(SpruceWillisCommon.MOD_ID,
        "textures/entity/spruce_willis_the_xmas_tree.png");

    public GrandfatherWillisRenderer(EntityRendererProvider.Context context) {
        super(context, new GrandfatherWillisModel(
                context.bakeLayer(LAYER_LOCATION)), 0.8F);
    }

    @NotNull
    @Override
    public Identifier getTextureLocation(WillisRenderState renderState) {
        return TEXTURE_LOCATION;
    }

    @Override
    public WillisRenderState createRenderState() {
        return new WillisRenderState();
    }

    @Override
    public void extractRenderState(GrandfatherWillis entity, WillisRenderState renderState, float partialTick) {
        super.extractRenderState(entity, renderState, partialTick);
        renderState.walkingAnimationState.copyFrom(entity.walkingAnimationState);
        renderState.idleAnimationState.copyFrom(entity.idleAnimationState);
        renderState.scale = 2.5F;
    }
}
