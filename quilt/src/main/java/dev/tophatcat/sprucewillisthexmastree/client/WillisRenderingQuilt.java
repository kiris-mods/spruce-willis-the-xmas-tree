package dev.tophatcat.sprucewillisthexmastree.client;

import dev.tophatcat.sprucewillisthexmastree.WillisCommon;
import dev.tophatcat.sprucewillisthexmastree.client.models.SpruceWillisModel;
import dev.tophatcat.sprucewillisthexmastree.client.rendering.GrandfatherWillisRenderer;
import dev.tophatcat.sprucewillisthexmastree.client.rendering.SpruceWillisRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;

public class WillisRenderingQuilt implements ClientModInitializer {

    @Override
    public void onInitializeClient(ModContainer mod) {
        EntityRendererRegistry.register(WillisCommon.SPRUCE_WILLIS.get(), SpruceWillisRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(SpruceWillisModel.LAYER_LOCATION,
            SpruceWillisModel::createBodyLayer);
        EntityRendererRegistry.register(WillisCommon.GRANDFATHER_WILLIS.get(), GrandfatherWillisRenderer::new);
    }
}
