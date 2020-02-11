package com.mcmoddev.sprucewillisthexmastree.common.init;

import com.mcmoddev.sprucewillisthexmastree.SpruceWillisTheXmasTree;
import com.mcmoddev.sprucewillisthexmastree.client.rendering.RenderGrandfatherWillis;
import com.mcmoddev.sprucewillisthexmastree.client.rendering.RenderSpruceWillis;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;

/**
 * The rendering class for this mod.
 */
@SuppressWarnings("unused")
@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = SpruceWillisTheXmasTree.MODID,
	bus = Mod.EventBusSubscriber.Bus.MOD)
public class WillisRenderingRegistry {

	/**
	 * @param event The ModelRegistryEvent where we register our models.
	 */
	@SubscribeEvent
	@SuppressWarnings("unused")
	public static void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(WillisEntityRegistry.SPRUCE_WILLIS_THE_XMAS_TREE, RenderSpruceWillis::new);
		RenderingRegistry.registerEntityRenderingHandler(WillisEntityRegistry.GRANDFATHER_SPRUCE_WILLIS, RenderGrandfatherWillis::new);
	}
}
