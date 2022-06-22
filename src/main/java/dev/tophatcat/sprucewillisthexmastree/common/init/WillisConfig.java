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

import com.google.common.collect.Lists;
import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

/**
 * The configuration setup class.
 */
public class WillisConfig {

    public static final ServerConfig SERVER;
    public static final ForgeConfigSpec SERVER_SPECIFICATION;

    static {
        Pair<ServerConfig, ForgeConfigSpec> specificationPair = new ForgeConfigSpec.Builder().configure(ServerConfig::new);
        SERVER_SPECIFICATION = specificationPair.getRight();
        SERVER = specificationPair.getLeft();
    }

    public static class ServerConfig {
        public final ForgeConfigSpec.BooleanValue SpruceWillisSpawnNaturally;
        public final ForgeConfigSpec.IntValue SpruceWillisSpawnWeight;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> BiomeWhitelist;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> BiomeBlacklist;

        ServerConfig(ForgeConfigSpec.Builder builder) {
            SpruceWillisSpawnNaturally = builder.comment("If Spruce Willis should spawn naturally in the world.")
                .define("enableNaturalSpawning", true);

            SpruceWillisSpawnWeight = builder.comment("If -1, the default spawn weight will be used.")
                .defineInRange("spawnWeight", 10, -1, Integer.MAX_VALUE);

            BiomeWhitelist = builder.comment("If biomes are specified here,"
                + " Spruce Willis will spawn in ONLY these biomes. (The blacklist is ignored while this is set!)")
                .defineList("whitelist", Lists.newArrayList(), o -> o instanceof String);

            BiomeBlacklist = builder.comment("If the whitelist is not used, use this list to specify the"
                + " biomes that Spruce Willis should not spawn in.")
                .defineList("blacklist",
                    Lists.newArrayList(
                        "minecraft:the_void",
                        "minecraft:ocean",
                        "minecraft:nether",
                        "minecraft:frozen_river",
                        "minecraft:frozen_ocean",
                        "minecraft:desert",
                        "minecraft:warm_ocean",
                        "minecraft:lukewarm_ocean",
                        "minecraft:cold_ocean",
                        "minecraft:deep_lukewarm_ocean",
                        "minecraft:deep_cold_ocean",
                        "minecraft:deep_frozen_ocean"
                    ), o -> o instanceof String);
        }
    }
}
