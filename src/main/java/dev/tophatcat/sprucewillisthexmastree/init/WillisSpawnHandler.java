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


import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class WillisSpawnHandler {

    public static void biomeLoad(BiomeLoadingEvent event) {
        ResourceLocation name = event.getName();
        if (name != null && event.getCategory() != Biome.BiomeCategory.NETHER
            || event.getCategory() != Biome.BiomeCategory.THEEND) {
            event.getSpawns().getSpawner(MobCategory.CREATURE)
                .add(new MobSpawnSettings.SpawnerData(
                    WillisRegistry.SPRUCE_WILLIS_THE_XMAS_TREE.get(),
                    WillisConfig.CONFIG.weightMultiplierWillis.get(),
                    WillisConfig.CONFIG.minSpawnGroupWillis.get(),
                    WillisConfig.CONFIG.maxSpawnGroupWillis.get())
                );
        }
    }
}
