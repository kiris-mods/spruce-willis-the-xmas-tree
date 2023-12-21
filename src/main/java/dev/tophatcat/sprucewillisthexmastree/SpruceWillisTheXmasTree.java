/*
 * Spruce Willis the Xmas Tree - https://github.com/kiris-mods/spruce-willis-the-xmas-tree
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

import dev.tophatcat.sprucewillisthexmastree.client.SpruceClientInit;
import dev.tophatcat.sprucewillisthexmastree.entities.EntityGrandfatherWillis;
import dev.tophatcat.sprucewillisthexmastree.entities.EntitySpruceWillis;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.ambient.AmbientCreature;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(SpruceWillisTheXmasTree.MOD_ID)
public class SpruceWillisTheXmasTree {

    public static final String MOD_ID = "sprucewillisthexmastree";

    private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(
        ForgeRegistries.ENTITY_TYPES, MOD_ID);

    public static final RegistryObject<EntityType<EntitySpruceWillis>> SPRUCE_WILLIS_THE_XMAS_TREE
        = ENTITIES.register("spruce_willis_the_xmas_tree", () -> EntityType.Builder.of(
            EntitySpruceWillis::new, MobCategory.CREATURE)
        .sized(1.0F, 2.0F)
        .setTrackingRange(10)
        .fireImmune()
        .build(MOD_ID + ":spruce_willis_the_xmas_tree"));

    public static final RegistryObject<EntityType<EntityGrandfatherWillis>> GRANDFATHER_SPRUCE_WILLIS
        = ENTITIES.register("grandfather_spruce_willis_the_xmas_tree", () -> EntityType.Builder.of(
            EntityGrandfatherWillis::new, MobCategory.CREATURE)
        .sized(2.0F, 6.0F)
        .setTrackingRange(10)
        .fireImmune()
        .build(MOD_ID + ":grandfather_spruce_willis_the_xmas_tree"));

    public SpruceWillisTheXmasTree() {
        IEventBus mod = FMLJavaModLoadingContext.get().getModEventBus();
        ENTITIES.register(mod);
        mod.addListener(SpruceWillisTheXmasTree::registerAttributes);
        mod.addListener(SpruceWillisTheXmasTree::registerSpawnPlacements);
        if (FMLEnvironment.dist == Dist.CLIENT) {
            mod.addListener(SpruceClientInit::registerEntityModels);
            mod.addListener(SpruceClientInit::registerLayerDefinitions);
        }
    }

    private static void registerSpawnPlacements(SpawnPlacementRegisterEvent event) {
        event.register(SPRUCE_WILLIS_THE_XMAS_TREE.get(),
            SpawnPlacements.Type.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            AmbientCreature::checkMobSpawnRules,
            SpawnPlacementRegisterEvent.Operation.OR);
    }

    private static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(SPRUCE_WILLIS_THE_XMAS_TREE.get(), EntitySpruceWillis.spruceWillisAttributes().build());
        event.put(GRANDFATHER_SPRUCE_WILLIS.get(), EntityGrandfatherWillis.grandfatherWillisAttributes().build());
    }
}
