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
package dev.tophatcat.sprucewillisthexmastree.common.init;

import dev.tophatcat.sprucewillisthexmastree.SpruceWillisTheXmasTree;
import com.google.common.collect.Sets;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Mod.EventBusSubscriber(modid = SpruceWillisTheXmasTree.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EventHandler {

    private static Collection<Biome> biomes = null;
    private static Biome.SpawnListEntry entry = null;

    @SubscribeEvent
    public static void onLoad(ModConfig.Loading event) {
        if (event.getConfig().getSpec() != WillisConfig.SERVER_SPECIFICATION) {
            return;
        }

        if (entry != null) {
            biomes.stream().map(biome -> biome.getSpawns(EntityClassification.MONSTER)).forEach(list ->
                list.remove(entry));
            biomes = Collections.emptyList();
        }

        if (WillisConfig.SERVER.SpruceWillisSpawnNaturally.get()) {
            int currentWeight = WillisConfig.SERVER.SpruceWillisSpawnWeight.get();

            if (currentWeight > 0) {
                biomes = ForgeRegistries.BIOMES.getValues();
                if (WillisConfig.SERVER.BiomeWhitelist.get() != null && WillisConfig.SERVER.BiomeWhitelist.get().size() > 0) {
                    Set<String> whitelist = Sets.newHashSet(WillisConfig.SERVER.BiomeWhitelist.get());
                    biomes = biomes.stream().filter(b ->
                        whitelist.contains(b.getRegistryName().toString())).collect(Collectors.toList());
                } else {
                    if (WillisConfig.SERVER.BiomeBlacklist.get() != null && WillisConfig.SERVER.BiomeBlacklist.get().size() > 0) {
                        Set<String> blacklist = Sets.newHashSet(WillisConfig.SERVER.BiomeBlacklist.get());
                        biomes = biomes.stream().filter(b ->
                            !blacklist.contains(b.getRegistryName().toString())).collect(Collectors.toList());
                    }
                }

                entry = new Biome.SpawnListEntry(WillisEntityRegistry.SPRUCE_WILLIS_THE_XMAS_TREE,
                    WillisConfig.SERVER.SpruceWillisSpawnWeight.get(), 1, 5);
                biomes.stream().map(biome -> biome.getSpawns(EntityClassification.MONSTER)).forEach(list ->
                    list.add(entry));
            }
        }
    }
}
