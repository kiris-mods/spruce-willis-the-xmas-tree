package dev.tophatcat.sprucewillisthexmastree;

import dev.tophatcat.sprucewillisthexmastree.client.WillisRenderingForge;
import dev.tophatcat.sprucewillisthexmastree.entities.GrandfatherWillis;
import dev.tophatcat.sprucewillisthexmastree.entities.SpruceWillis;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod(WillisCommon.MOD_ID)
public class WillisForge {

    private static final DeferredRegister<EntityType<?>> ENTITIES
        = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, WillisCommon.MOD_ID);

    public WillisForge() {
        WillisCommon.init();
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        setUpMobs();
        ENTITIES.register(bus);
        bus.addListener(this::registerAttributes);
        if (FMLEnvironment.dist == Dist.CLIENT) {
            bus.addListener(WillisRenderingForge::registerRenderers);
            bus.addListener(WillisRenderingForge::registerModelLayers);
        }
    }

    private void setUpMobs() {
        WillisCommon.SPRUCE_WILLIS = ENTITIES.register("spruce_willis_the_xmas_tree",
            () -> EntityType.Builder.of(SpruceWillis::new, MobCategory.CREATURE)
                .sized(1.0F, 2.0F)
                .clientTrackingRange(10)
                .fireImmune()
                .build(WillisCommon.MOD_ID + ":spruce_willis_the_xmas_tree"));

        WillisCommon.GRANDFATHER_WILLIS = ENTITIES.register("grandfather_spruce_willis",
            () -> EntityType.Builder.of(GrandfatherWillis::new, MobCategory.CREATURE)
                .sized(2.0F, 6.0F)
                .clientTrackingRange(10)
                .fireImmune()
                .build(WillisCommon.MOD_ID + ":grandfather_spruce_willis"));
    }

    private void registerAttributes(final EntityAttributeCreationEvent event) {
        event.put(WillisCommon.SPRUCE_WILLIS.get(), SpruceWillis.createAttributes().build());
        event.put(WillisCommon.GRANDFATHER_WILLIS.get(), GrandfatherWillis.createAttributes().build());
    }
}
