package com.mcmoddev.sprucewillisthexmastree;

import com.mcmoddev.sprucewillisthexmastree.common.init.WillisConfig;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLFingerprintViolationEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(SpruceWillisTheXmasTree.MODID)
@EventBusSubscriber(bus = Bus.MOD)
public class SpruceWillisTheXmasTree {

	/**
	 * Set the mods ID.
	 */
	public static final String MODID = "spruce-willis-the-xmas-tree";
	/**
	 * Setup the logger for the mod.
	 */
	private static final Logger LOGGER = LogManager.getLogger("Spruce Willis the Xmas Tree");

	/**
	 * Register things.
	 */
	public SpruceWillisTheXmasTree() {
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::fingerprintViolation);
		ModLoadingContext modLoadingContext = ModLoadingContext.get();
		modLoadingContext.registerConfig(ModConfig.Type.SERVER, WillisConfig.SERVER_SPECIFICATION);
	}

	/**
	 * Check if the mod is signed and warn if it is not.
	 *
	 * @param event the event fired.
	 */
	private void fingerprintViolation(FMLFingerprintViolationEvent event) {
		LOGGER.error("Invalid fingerprint detected! The file " + event.getSource().getName() + " may have been " +
			"tampered with. This version will NOT be supported! Please download the mod from CurseForge for a " +
			"supported and signed version of the mod.");
	}
}
