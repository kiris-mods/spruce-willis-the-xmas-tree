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
        return new ResourceLocation(WillisCommon.MOD_ID, "textures/entity/spruce_willis_the_xmas_tree.png");
    }
}
