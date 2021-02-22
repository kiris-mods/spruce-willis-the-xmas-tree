package cat.tophat.sprucewillisthexmastree.client;

import cat.tophat.sprucewillisthexmastree.SpruceWillisTheXmasTree;
import cat.tophat.sprucewillisthexmastree.client.rendering.RenderGrandfatherWillis;
import cat.tophat.sprucewillisthexmastree.client.rendering.RenderSpruceWillis;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;

/**
 * The rendering class for this mod.
 */
@SuppressWarnings("unused")
@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = SpruceWillisTheXmasTree.MOD_ID,
    bus = Mod.EventBusSubscriber.Bus.MOD)
public class WillisRenderingRegistry {

    /**
     * Register our things for rendering.
     */
    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(SpruceWillisTheXmasTree.SPRUCE_WILLIS_THE_XMAS_TREE,
            RenderSpruceWillis::new);
        RenderingRegistry.registerEntityRenderingHandler(SpruceWillisTheXmasTree.GRANDFATHER_SPRUCE_WILLIS,
            RenderGrandfatherWillis::new);
    }
}
