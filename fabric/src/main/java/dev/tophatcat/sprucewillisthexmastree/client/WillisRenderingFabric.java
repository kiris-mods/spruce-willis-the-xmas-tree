package dev.tophatcat.sprucewillisthexmastree.client;

import dev.tophatcat.sprucewillisthexmastree.WillisCommon;
import dev.tophatcat.sprucewillisthexmastree.client.models.SpruceWillisModel;
import dev.tophatcat.sprucewillisthexmastree.client.rendering.GrandfatherWillisRenderer;
import dev.tophatcat.sprucewillisthexmastree.client.rendering.SpruceWillisRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class WillisRenderingFabric implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(WillisCommon.SPRUCE_WILLIS.get(), SpruceWillisRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(SpruceWillisModel.LAYER_LOCATION,
            SpruceWillisModel::createBodyLayer);
        EntityRendererRegistry.register(WillisCommon.GRANDFATHER_WILLIS.get(), GrandfatherWillisRenderer::new);
    }
}
