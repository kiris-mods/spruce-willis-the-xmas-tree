package dev.tophatcat.sprucewillisthexmastree;

import dev.tophatcat.sprucewillisthexmastree.client.WillisRenderingNeo;
import dev.tophatcat.sprucewillisthexmastree.entities.GrandfatherWillis;
import dev.tophatcat.sprucewillisthexmastree.entities.SpruceWillis;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(WillisCommon.MOD_ID)
public class WillisNeo {

    private static final DeferredRegister<EntityType<?>> ENTITIES
        = DeferredRegister.create(Registries.ENTITY_TYPE, WillisCommon.MOD_ID);

    public WillisNeo(IEventBus bus) {
        WillisCommon.init();
        setUpMobs();
        ENTITIES.register(bus);
        bus.addListener(this::registerAttributes);
        if (FMLEnvironment.dist == Dist.CLIENT) {
            bus.addListener(WillisRenderingNeo::registerRenderers);
            bus.addListener(WillisRenderingNeo::registerModelLayers);
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
