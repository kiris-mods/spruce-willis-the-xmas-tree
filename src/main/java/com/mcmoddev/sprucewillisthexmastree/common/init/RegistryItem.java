package com.mcmoddev.sprucewillisthexmastree.common.init;

import com.mcmoddev.sprucewillisthexmastree.SpruceWillisTheXmasTree;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.awt.*;

@Mod.EventBusSubscriber(modid = SpruceWillisTheXmasTree.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegistryItem {

	/**
	 * @param event Add items and block items to the item registry.
	 */
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(
			new SpawnEggItem(RegistryEntity.SPRUCE_WILLIS_THE_XMAS_TREE, Color.GREEN.getRGB(), Color.RED.getRGB(),
				new Item.Properties().group(ItemGroup.MISC))
				.setRegistryName(SpruceWillisTheXmasTree.MODID + ":spruce_willis_the_xmas_tree_spawn_egg")
		);
	}
}
