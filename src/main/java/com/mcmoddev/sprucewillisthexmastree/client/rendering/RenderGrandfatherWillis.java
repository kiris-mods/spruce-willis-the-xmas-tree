package com.mcmoddev.sprucewillisthexmastree.client.rendering;

import com.mcmoddev.sprucewillisthexmastree.SpruceWillisTheXmasTree;
import com.mcmoddev.sprucewillisthexmastree.client.models.GrandfatherWillisModel;
import com.mcmoddev.sprucewillisthexmastree.common.entities.GrandfatherWillisEntity;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

/**
 * Render the Grandfather Spruce Willis model and texture.
 */
@OnlyIn(Dist.CLIENT)
public class RenderGrandfatherWillis extends MobRenderer<GrandfatherWillisEntity, GrandfatherWillisModel> {

	/**
	 * The location of the texture for the entity.
	 */
	private static final ResourceLocation resourceLocation = new ResourceLocation(SpruceWillisTheXmasTree.MODID,
		"textures/entity/spruce_willis_the_xmas_tree.png");

	/**
	 * @param rendererManager The render manager.
	 */
	public RenderGrandfatherWillis(EntityRendererManager rendererManager) {
		super(rendererManager, new GrandfatherWillisModel(), 0.8F);
	}

	/**
	 * @param entity          The entity.
	 * @param partialTickTime .
	 */
	@Override
	public void preRenderCallback(GrandfatherWillisEntity entity, float partialTickTime) {
		GlStateManager.scaled(2.5D, 2.5D, 2.5D);
	}

	/**
	 * Can the entity's name be rendered above the entity.
	 *
	 * @param entity The entity itself.
	 * @return true, false or entity.hasCustomName();
	 */
	@Override
	protected boolean canRenderName(GrandfatherWillisEntity entity) {
		return entity.hasCustomName();
	}

	/**
	 * Get the entity's texture location.
	 *
	 * @param entity The entity itself.
	 * @return The resource location for the texture.
	 */
	@Override
	protected ResourceLocation getEntityTexture(@Nonnull GrandfatherWillisEntity entity) {
		return resourceLocation;
	}
}
