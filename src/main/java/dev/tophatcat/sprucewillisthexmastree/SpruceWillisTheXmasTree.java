/*
 * Spruce Willis the Xmas Tree - https://github.com/tophatcats-mods/spruce-willis-the-xmas-tree
 * Copyright (C) 2016-2022 <KiriCattus>
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation;
 * Specifically version 2.1 of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301
 * USA
 * https://www.gnu.org/licenses/old-licenses/lgpl-2.1.html
 */
package dev.tophatcat.sprucewillisthexmastree;

import dev.tophatcat.sprucewillisthexmastree.common.entities.GrandfatherWillisEntity;
import dev.tophatcat.sprucewillisthexmastree.common.entities.SpruceWillisEntity;
import dev.tophatcat.sprucewillisthexmastree.common.init.WillisConfig;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import java.awt.Color;

@Mod(SpruceWillisTheXmasTree.MOD_ID)
@EventBusSubscriber(bus = Bus.MOD)
public class SpruceWillisTheXmasTree {

    /**
     * This is the mod's ID used for registering things and identifying the mod.
     */
    public static final String MOD_ID = "spruce-willis-the-xmas-tree";

    /**
     * Setup the mod.
     */
    public SpruceWillisTheXmasTree() {
        ModLoadingContext modLoadingContext = ModLoadingContext.get();
        modLoadingContext.registerConfig(ModConfig.Type.SERVER, WillisConfig.SERVER_SPECIFICATION);
    }

    /**
     * Setup the Spruce Willis the Xmas Tree entity.
     */
    @SuppressWarnings("unchecked")
    public static final EntityType<SpruceWillisEntity> SPRUCE_WILLIS_THE_XMAS_TREE
        = (EntityType<SpruceWillisEntity>) EntityType.Builder.create(SpruceWillisEntity::new,
        EntityClassification.CREATURE)
        .size(1.0F, 3.0F)
        .setTrackingRange(80)
        .setUpdateInterval(1)
        .setShouldReceiveVelocityUpdates(true)
        .build(SpruceWillisTheXmasTree.MOD_ID + ":spruce_willis_the_xmas_tree")
        .setRegistryName(new ResourceLocation(SpruceWillisTheXmasTree.MOD_ID, "spruce_willis_the_xmas_tree"));

    /**
     * Setup the Grandfather Spruce Willis mob.
     */
    @SuppressWarnings("unchecked")
    public static final EntityType<GrandfatherWillisEntity> GRANDFATHER_SPRUCE_WILLIS
        = (EntityType<GrandfatherWillisEntity>) EntityType.Builder.create(GrandfatherWillisEntity::new,
        EntityClassification.CREATURE)
        .immuneToFire()
        .size(2.0F, 7.0F)
        .setTrackingRange(80)
        .setUpdateInterval(1)
        .setShouldReceiveVelocityUpdates(true)
        .build(SpruceWillisTheXmasTree.MOD_ID + ":grandfather_spruce_willis")
        .setRegistryName(new ResourceLocation(SpruceWillisTheXmasTree.MOD_ID, "grandfather_spruce_willis"));

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

    /**
     * Setup entity attributes.
     */
    @SuppressWarnings("unused")
    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            GlobalEntityTypeAttributes.put(SPRUCE_WILLIS_THE_XMAS_TREE,
                SpruceWillisEntity.spruceWillisAttributes().create());
            GlobalEntityTypeAttributes.put(GRANDFATHER_SPRUCE_WILLIS,
                GrandfatherWillisEntity.grandfatherWillisAttributes().create());
        });
    }

    /**
     * Register our spawn eggs.
     */
    @SubscribeEvent
    @SuppressWarnings("unused")
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
            new SpawnEggItem(SPRUCE_WILLIS_THE_XMAS_TREE, Color.GREEN.getRGB(), Color.RED.getRGB(),
                new Item.Properties().group(ItemGroup.MISC))
                .setRegistryName(SpruceWillisTheXmasTree.MOD_ID, "spruce_willis_the_xmas_tree_spawn_egg")
        );
    }
}
