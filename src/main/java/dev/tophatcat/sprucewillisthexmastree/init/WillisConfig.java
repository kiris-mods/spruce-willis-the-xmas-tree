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

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class WillisConfig {

    public static final ForgeConfigSpec SERVER_SPEC;
    public static final SpruceWillisConfig CONFIG;

    static {
        Pair<SpruceWillisConfig, ForgeConfigSpec> specificationPair
            = new ForgeConfigSpec.Builder().configure(SpruceWillisConfig::new);
        SERVER_SPEC = specificationPair.getRight();
        CONFIG = specificationPair.getLeft();
    }

    public static class SpruceWillisConfig {
        public final ForgeConfigSpec.IntValue weightMultiplierWillis;
        public final ForgeConfigSpec.IntValue minSpawnGroupWillis;
        public final ForgeConfigSpec.IntValue maxSpawnGroupWillis;

        public SpruceWillisConfig(ForgeConfigSpec.Builder builder) {
            builder.push("Ghostly Creeper");
            builder.comment("Set how much of a chance Spruce Willis will have to spawn in the world and the min/max "
                + "group size. (Set Spawn Weight to 0 to prevent them spawning)");
            weightMultiplierWillis = builder.defineInRange("Spawn Weight",
                20, 0, 500);
            minSpawnGroupWillis = builder.defineInRange("Minimum Group Spawn Count",
                1, 1, 64);
            maxSpawnGroupWillis = builder.defineInRange("Maximum Group Spawn Count",
                3, 1, 64);
            builder.pop();
        }
    }
}
