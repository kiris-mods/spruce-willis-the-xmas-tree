package dev.tophatcat.sprucewillisthexmastree;

import com.google.common.base.Suppliers;
import dev.tophatcat.sprucewillisthexmastree.entities.GrandfatherWillis;
import dev.tophatcat.sprucewillisthexmastree.entities.SpruceWillis;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class WillisFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        WillisCommon.init();
        setUpMobs();
        setUpSpawnLocations();
        FabricDefaultAttributeRegistry.register(WillisCommon.SPRUCE_WILLIS.get(),
            SpruceWillis.createAttributes());
        FabricDefaultAttributeRegistry.register(WillisCommon.GRANDFATHER_WILLIS.get(),
            GrandfatherWillis.createAttributes());
    }

    private void setUpMobs() {
        WillisCommon.SPRUCE_WILLIS = Suppliers.ofInstance(Registry.register(BuiltInRegistries.ENTITY_TYPE,
            new ResourceLocation(WillisCommon.MOD_ID, "spruce_willis_the_xmas_tree"),
            EntityType.Builder.of(SpruceWillis::new, MobCategory.CREATURE)
                .sized(1.0F, 2.0F)
                .clientTrackingRange(10)
                .fireImmune()
                .build(WillisCommon.MOD_ID + ":spruce_willis_the_xmas_tree")));

        WillisCommon.GRANDFATHER_WILLIS = Suppliers.ofInstance(Registry.register(BuiltInRegistries.ENTITY_TYPE,
            new ResourceLocation(WillisCommon.MOD_ID, "grandfather_spruce_willis"),
            EntityType.Builder.of(GrandfatherWillis::new, MobCategory.CREATURE)
                .sized(2.0F, 6.0F)
                .clientTrackingRange(10)
                .fireImmune()
                .build(WillisCommon.MOD_ID + ":grandfather_spruce_willis")));
    }

    private void setUpSpawnLocations() {
        BiomeModifications.addSpawn(biome -> biome.getBiomeRegistryEntry().is(BiomeTags.IS_FOREST),
            MobCategory.CREATURE, WillisCommon.SPRUCE_WILLIS.get(), 10, 1, 3);
    }
}
