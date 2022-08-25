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

import net.minecraft.entity.EntityClassification;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class WillisSpawnHandler {

    public static void biomeLoad(BiomeLoadingEvent event) {
        ResourceLocation name = event.getName();
        if (name != null && event.getCategory() != Biome.Category.NETHER
            || event.getCategory() != Biome.Category.THEEND) {
            event.getSpawns().getSpawner(EntityClassification.CREATURE)
                .add(new MobSpawnInfo.Spawners(
                    WillisRegistry.SPRUCE_WILLIS_THE_XMAS_TREE.get(),
                    WillisConfig.CONFIG.weightMultiplierWillis.get(),
                    WillisConfig.CONFIG.minSpawnGroupWillis.get(),
                    WillisConfig.CONFIG.maxSpawnGroupWillis.get())
                );
        }
    }
}
