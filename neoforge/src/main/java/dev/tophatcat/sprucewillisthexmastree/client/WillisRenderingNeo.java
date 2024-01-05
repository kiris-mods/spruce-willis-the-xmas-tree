package dev.tophatcat.sprucewillisthexmastree.client;

import dev.tophatcat.sprucewillisthexmastree.WillisCommon;
import dev.tophatcat.sprucewillisthexmastree.client.models.SpruceWillisModel;
import dev.tophatcat.sprucewillisthexmastree.client.rendering.GrandfatherWillisRenderer;
import dev.tophatcat.sprucewillisthexmastree.client.rendering.SpruceWillisRenderer;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

public class WillisRenderingNeo {

    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(WillisCommon.SPRUCE_WILLIS.get(), SpruceWillisRenderer::new);
        event.registerEntityRenderer(WillisCommon.GRANDFATHER_WILLIS.get(), GrandfatherWillisRenderer::new);
    }

    public static void registerModelLayers(final EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(SpruceWillisModel.LAYER_LOCATION, SpruceWillisModel::createBodyLayer);
    }
}
