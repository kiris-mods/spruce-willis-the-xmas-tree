/*
 * Spruce Willis the Xmas Tree - https://github.com/tophatcats-mods/spruce-willis-the-xmas-tree
 * Copyright (C) 2013-2023 <KiriCattus>
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

import dev.tophatcat.sprucewillisthexmastree.entities.EntityGrandfatherWillis;
import dev.tophatcat.sprucewillisthexmastree.entities.EntitySpruceWillis;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.util.Identifier;

public class SpruceWillisTheXmasTree implements ModInitializer {

    public static final String MOD_ID = "sprucewillisthexmastree";

    public static final EntityType<EntitySpruceWillis> SPRUCE_WILLIS_THE_XMAS_TREE = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(SpruceWillisTheXmasTree.MOD_ID, "spruce_willis_the_xmas_tree"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, EntitySpruceWillis::new)
                    .dimensions(EntityDimensions.fixed(1.0F, 3.0F))
                    .trackRangeChunks(1)
                    .forceTrackedVelocityUpdates(true)
                    .trackRangeBlocks(80)
                    .build());

    public static final EntityType<EntityGrandfatherWillis> GRANDFATHER_SPRUCE_WILLIS = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(SpruceWillisTheXmasTree.MOD_ID,
                    "grandfather_spruce_willis_the_xmas_tree"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, EntityGrandfatherWillis::new)
                    .fireImmune()
                    .dimensions(EntityDimensions.fixed(2.0F, 7.0F))
                    .trackRangeChunks(1)
                    .forceTrackedVelocityUpdates(true)
                    .trackRangeChunks(80)
                    .build());

    public static final Item WILLIS_SPAWN_EGG = new SpawnEggItem(SPRUCE_WILLIS_THE_XMAS_TREE,
            0x00FF00, 0xFF0000, new FabricItemSettings());

    @Override
    public void onInitialize() {
        FabricDefaultAttributeRegistry.register(SPRUCE_WILLIS_THE_XMAS_TREE,
                EntitySpruceWillis.spruceWillisAttributes());
        FabricDefaultAttributeRegistry.register(GRANDFATHER_SPRUCE_WILLIS,
                EntityGrandfatherWillis.grandfatherWillisAttributes());

        Registry.register(Registries.ITEM, new Identifier(MOD_ID,
                "spruce_willis_the_xmas_tree_spawn_egg"), WILLIS_SPAWN_EGG);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(content -> content.add(WILLIS_SPAWN_EGG));

        BiomeModifications.addSpawn(biome -> biome.getBiomeRegistryEntry().isIn(BiomeTags.IS_OVERWORLD),
                SpawnGroup.CREATURE, SPRUCE_WILLIS_THE_XMAS_TREE,
                15, 1, 2);
    }
}
