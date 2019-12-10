package com.mcmoddev.sprucewillisthexmastree.common.init;

import com.mcmoddev.sprucewillisthexmastree.SpruceWillisTheXmasTree;
import com.mcmoddev.sprucewillisthexmastree.common.entities.GrandfatherWillisEntity;
import com.mcmoddev.sprucewillisthexmastree.common.entities.SpruceWillisEntity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * The Entity Registry we use to register out mobs.
 */
@Mod.EventBusSubscriber(modid = SpruceWillisTheXmasTree.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegistryEntity {

	/**
	 * The Spruce Willis the Xmas Tree mob.
	 */
	@SuppressWarnings("unchecked")
	public static final EntityType<SpruceWillisEntity> SPRUCE_WILLIS_THE_XMAS_TREE =
		(EntityType<SpruceWillisEntity>) EntityType.Builder.create(SpruceWillisEntity::new,
			EntityClassification.CREATURE)
			.size(1.0F, 3.0F)
			.setTrackingRange(80)
			.setUpdateInterval(1)
			.setShouldReceiveVelocityUpdates(true)
			.build(SpruceWillisTheXmasTree.MODID + ":spruce_willis_the_xmas_tree")
			.setRegistryName("spruce_willis_the_xmas_tree");

	/**
	 * The grandfather Spruce Willis mob.
	 */
	@SuppressWarnings("unchecked")
	public static final EntityType<GrandfatherWillisEntity> GRANDFATHER_SPRUCE_WILLIS =
		(EntityType<GrandfatherWillisEntity>) EntityType.Builder.create(GrandfatherWillisEntity::new,
			EntityClassification.CREATURE)
			.immuneToFire()
			.size(2.0F, 7.0F)
			.setTrackingRange(80)
			.setUpdateInterval(1)
			.setShouldReceiveVelocityUpdates(true)
			.build(SpruceWillisTheXmasTree.MODID + ":grandfather_spruce_willis")
			.setRegistryName("grandfather_spruce_willis");

	/**
	 * @param event The RegistryEvent where we register this mods mobs.
	 */
	@SubscribeEvent
	@SuppressWarnings("unused")
	public static void registerEntity(RegistryEvent.Register<EntityType<?>> event) {
		event.getRegistry().registerAll(
			SPRUCE_WILLIS_THE_XMAS_TREE,
			GRANDFATHER_SPRUCE_WILLIS
		);

		EntitySpawnPlacementRegistry.register(SPRUCE_WILLIS_THE_XMAS_TREE,
			EntitySpawnPlacementRegistry.PlacementType.ON_GROUND,
			Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, CreatureEntity::canSpawnOn);
	}
}
