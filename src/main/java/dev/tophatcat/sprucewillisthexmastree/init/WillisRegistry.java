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
package dev.tophatcat.sprucewillisthexmastree.init;

import dev.tophatcat.sprucewillisthexmastree.SpruceWillisTheXmasTree;
import dev.tophatcat.sprucewillisthexmastree.entities.GrandfatherWillisEntity;
import dev.tophatcat.sprucewillisthexmastree.entities.SpruceWillisEntity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class WillisRegistry {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(
        ForgeRegistries.ITEMS, SpruceWillisTheXmasTree.MOD_ID);

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(
        ForgeRegistries.ENTITIES, SpruceWillisTheXmasTree.MOD_ID);

    public static final RegistryObject<EntityType<SpruceWillisEntity>> SPRUCE_WILLIS_THE_XMAS_TREE = ENTITIES.register(
        "spruce_willis_the_xmas_tree", () -> EntityType.Builder.of(
                SpruceWillisEntity::new, EntityClassification.CREATURE)
            .sized(1.0F, 3.0F)
            .setTrackingRange(80)
            .setUpdateInterval(1)
            .setShouldReceiveVelocityUpdates(true)
            .build(new ResourceLocation(SpruceWillisTheXmasTree.MOD_ID,
                "spruce_willis_the_xmas_tree").toString())
    );

    public static final RegistryObject<EntityType<GrandfatherWillisEntity>> GRANDFATHER_SPRUCE_WILLIS
        = ENTITIES.register("grandfather_spruce_willis_the_xmas_tree", () -> EntityType.Builder.of(
            GrandfatherWillisEntity::new, EntityClassification.CREATURE)
        .fireImmune()
        .sized(2.0F, 7.0F)
        .setTrackingRange(80)
        .setUpdateInterval(1)
        .setShouldReceiveVelocityUpdates(true)
        .build(SpruceWillisTheXmasTree.MOD_ID + ":grandfather_spruce_willis"));

    private static final RegistryObject<SpawnEggItem> SPRUCE_WILLIS_THE_XMAS_TREE_SPAWN_EGG = ITEMS.register(
        "spruce_willis_the_xmas_tree_spawn_egg", () -> new ForgeSpawnEggItem(SPRUCE_WILLIS_THE_XMAS_TREE,
            0x00FF00, 0xff0000, new Item.Properties().tab(ItemGroup.TAB_MISC))
    );

    public static void registerSpawns(FMLCommonSetupEvent event) {
        EntitySpawnPlacementRegistry.register(WillisRegistry.SPRUCE_WILLIS_THE_XMAS_TREE.get(),
            EntitySpawnPlacementRegistry.PlacementType.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, CreatureEntity::checkMobSpawnRules);
    }

    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(SPRUCE_WILLIS_THE_XMAS_TREE.get(), SpruceWillisEntity.spruceWillisAttributes().build());
        event.put(GRANDFATHER_SPRUCE_WILLIS.get(), GrandfatherWillisEntity.grandfatherWillisAttributes().build());
    }
}
