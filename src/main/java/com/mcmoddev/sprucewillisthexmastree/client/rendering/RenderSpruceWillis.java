package com.mcmoddev.sprucewillisthexmastree.client.rendering;

import com.mcmoddev.sprucewillisthexmastree.SpruceWillisTheXmasTree;
import com.mcmoddev.sprucewillisthexmastree.client.models.SpruceWillisModel;
import com.mcmoddev.sprucewillisthexmastree.common.entities.SpruceWillisEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

/**
 * Render the spruce willis model and texture.
 */
@OnlyIn(Dist.CLIENT)
public class RenderSpruceWillis extends MobRenderer<SpruceWillisEntity, SpruceWillisModel> {

	/**
	 * The location of the texture for the entity.
	 */
	private static final ResourceLocation resourceLocation = new ResourceLocation(SpruceWillisTheXmasTree.MODID,
		"textures/entity/spruce_willis_the_xmas_tree.png");

	/**
	 * @param rendererManager The render manager for entities.
	 */
	public RenderSpruceWillis(EntityRendererManager rendererManager) {
		super(rendererManager, new SpruceWillisModel(), 0.8F);
	}

	/**
	 * Can the entity's name be rendered above the entity.
	 *
	 * @param entity The entity itself.
	 * @return true, false or entity.hasCustomName();
	 */
	@Override
	protected boolean canRenderName(SpruceWillisEntity entity) {
		return entity.hasCustomName();
	}

	/**
	 * Get the entity's texture location.
	 *
	 * @param entity The entity itself.
	 * @return The resource location for the texture.
	 */
	@Nonnull
	@Override
	public ResourceLocation getEntityTexture(@Nonnull SpruceWillisEntity entity) {
		return resourceLocation;
	}
}
