package dev.tophatcat.sprucewillisthexmastree.client.rendering;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.tophatcat.sprucewillisthexmastree.WillisCommon;
import dev.tophatcat.sprucewillisthexmastree.client.models.GrandfatherWillisModel;
import dev.tophatcat.sprucewillisthexmastree.entities.GrandfatherWillis;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class GrandfatherWillisRenderer extends MobRenderer<GrandfatherWillis,
    GrandfatherWillisModel<GrandfatherWillis>> {

    private static final ResourceLocation RESOURCE_LOCATION = new ResourceLocation(WillisCommon.MOD_ID,
        "textures/entity/spruce_willis_the_xmas_tree.png");

    public GrandfatherWillisRenderer(EntityRendererProvider.Context context) {
        super(context, new GrandfatherWillisModel<>(
                context.bakeLayer(GrandfatherWillisModel.LAYER_LOCATION)), 0.8F);
    }

    protected void scale(@NotNull GrandfatherWillis entity, @NotNull PoseStack matrixStack,
                         float partialTickTime) {
        matrixStack.scale(2.5F, 2.5F, 2.5F);
    }

    @NotNull
    @Override
    public ResourceLocation getTextureLocation(@NotNull final GrandfatherWillis entity) {
        return RESOURCE_LOCATION;
    }
}
