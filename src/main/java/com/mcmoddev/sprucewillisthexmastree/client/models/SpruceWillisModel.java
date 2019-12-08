package com.mcmoddev.sprucewillisthexmastree.client.models;

import com.mcmoddev.sprucewillisthexmastree.common.entities.SpruceWillisEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.util.math.MathHelper;

/**
 * Model for the Spruce Willis the Xmas Tree mob made by Coda as a Winterjam commission.
 */
public class SpruceWillisModel extends EntityModel<SpruceWillisEntity> {

	/**
	 * The entities main body.
	 */
	public RendererModel body;

	/**
	 * The entities back left leg.
	 */
	public RendererModel legBackLeft;

	/**
	 * The entities back right leg.
	 */
	public RendererModel legBackRight;

	/**
	 * The entities front left leg.
	 */
	public RendererModel legFrontLeft;

	/**
	 * The entities front right leg.
	 */
	public RendererModel legFrontRight;

	/**
	 * First block of leaves.
	 */
	public RendererModel leaves1;

	/**
	 * Second block of leaves.
	 */
	public RendererModel leaves2;

	/**
	 * Third block of leaves.
	 */
	public RendererModel leaves3;

	/**
	 * Fourth block of leaves.
	 */
	public RendererModel leaves4;

	/**
	 * The ornaments hanging off the leaves.
	 */
	public RendererModel ornament;

	/**
	 * The ornaments hanging off the leaves.
	 */
	public RendererModel ornament_1;

	/**
	 * The ornaments hanging off the leaves.
	 */
	public RendererModel ornament_2;

	/**
	 * The ornaments hanging off the leaves.
	 */
	public RendererModel ornament_3;

	/**
	 * The ornaments hanging off the leaves.
	 */
	public RendererModel ornament_4;

	/**
	 * The ornaments hanging off the leaves.
	 */
	public RendererModel ornament_5;

	/**
	 * The ornaments hanging off the leaves.
	 */
	public RendererModel ornament_6;

	/**
	 * The ornaments hanging off the leaves.
	 */
	public RendererModel ornament_7;

	/**
	 * The ornaments hanging off the leaves.
	 */
	public RendererModel ornament_8;

	/**
	 * The model itself and the texture properties.
	 */
	public SpruceWillisModel() {
		textureWidth = 128;
		textureHeight = 128;

		//Body
		body = new RendererModel(this, 0, 0);
		body.setRotationPoint(0.0F, 7.0F, 0.0F);
		body.addBox(-4.0F, -16.0F, -3.0F, 8, 27, 6, 0.0F);

		//Legs
		legFrontLeft = new RendererModel(this, 28, 0);
		legFrontLeft.setRotationPoint(2.0F, 11.0F, -3.0F);
		legFrontLeft.addBox(-2.0F, 0.0F, -4.0F, 4, 6, 4, 0.0F);

		legFrontRight = new RendererModel(this, 28, 0);
		legFrontRight.setRotationPoint(-2.0F, 11.0F, -2.0F);
		legFrontRight.addBox(-2.0F, 0.0F, -5.0F, 4, 6, 4, 0.0F);

		legBackLeft = new RendererModel(this, 28, 0);
		legBackLeft.setRotationPoint(2.0F, 11.0F, 3.0F);
		legBackLeft.addBox(-2.0F, 0.0F, 0.0F, 4, 6, 4, 0.0F);

		legBackRight = new RendererModel(this, 28, 0);
		legBackRight.setRotationPoint(-2.0F, 11.0F, 3.0F);
		legBackRight.addBox(-2.0F, 0.0F, 0.0F, 4, 6, 4, 0.0F);

		//Leaves
		leaves1 = new RendererModel(this, 28, 10);
		leaves1.setRotationPoint(0.0F, 5.0F, 0.0F);
		leaves1.addBox(-10.0F, -6.0F, -10.0F, 20, 6, 20, 0.0F);

		leaves2 = new RendererModel(this, 0, 36);
		leaves2.setRotationPoint(0.0F, -2.0F, 0.0F);
		leaves2.addBox(-8.0F, -6.0F, -8.0F, 16, 6, 16, 0.0F);

		leaves3 = new RendererModel(this, 64, 36);
		leaves3.setRotationPoint(0.0F, -9.0F, 0.0F);
		leaves3.addBox(-6.0F, -6.0F, -6.0F, 12, 6, 12, 0.0F);

		leaves4 = new RendererModel(this, 92, 0);
		leaves4.setRotationPoint(0.0F, -16.0F, 0.0F);
		leaves4.addBox(-4.0F, -6.0F, -4.0F, 8, 6, 8, 0.0F);

		//Ornaments
		ornament = new RendererModel(this, 31, 10);
		ornament.setRotationPoint(-4.0F, 1.0F, 7.0F);
		ornament.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3, 0.0F);

		ornament_1 = new RendererModel(this, 31, 16);
		ornament_1.setRotationPoint(-7.0F, 1.0F, -1.0F);
		ornament_1.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3, 0.0F);

		ornament_2 = new RendererModel(this, 31, 22);
		ornament_2.setRotationPoint(0.0F, 1.0F, -6.0F);
		ornament_2.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3, 0.0F);

		ornament_3 = new RendererModel(this, 31, 16);
		ornament_3.setRotationPoint(8.0F, 1.0F, 1.0F);
		ornament_3.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3, 0.0F);

		ornament_4 = new RendererModel(this, 31, 10);
		ornament_4.setRotationPoint(6.0F, 1.0F, 1.0F);
		ornament_4.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3, 0.0F);

		ornament_5 = new RendererModel(this, 31, 22);
		ornament_5.setRotationPoint(-5.0F, 1.0F, 6.0F);
		ornament_5.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3, 0.0F);

		ornament_6 = new RendererModel(this, 31, 16);
		ornament_6.setRotationPoint(1.0F, 1.0F, -6.0F);
		ornament_6.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3, 0.0F);

		ornament_7 = new RendererModel(this, 31, 10);
		ornament_7.setRotationPoint(0.5F, 1.0F, -4.0F);
		ornament_7.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3, 0.0F);

		ornament_8 = new RendererModel(this, 31, 16);
		ornament_8.setRotationPoint(-3.5F, 1.0F, 4.0F);
		ornament_8.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3, 0.0F);

		//Parenting
		//Legs
		body.addChild(legFrontLeft);
		body.addChild(legFrontRight);
		body.addChild(legBackLeft);
		body.addChild(legBackRight);

		//Leaves
		body.addChild(leaves1);
		body.addChild(leaves2);
		body.addChild(leaves3);
		body.addChild(leaves4);

		//Ornaments
		leaves1.addChild(ornament);
		leaves1.addChild(ornament_1);
		leaves1.addChild(ornament_2);
		leaves1.addChild(ornament_3);
		leaves2.addChild(ornament_4);
		leaves2.addChild(ornament_5);
		leaves2.addChild(ornament_6);
		leaves3.addChild(ornament_7);
		leaves3.addChild(ornament_8);
	}

	/**
	 * @param entity The entity.
	 * @param f
	 * @param f1
	 * @param f2
	 * @param f3
	 * @param f4
	 * @param f5
	 */
	@Override
	public void render(SpruceWillisEntity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		body.render(f5);
	}

	/**
	 * @param entity          The entity.
	 * @param limbSwing
	 * @param limbSwingAmount
	 * @param ageInTicks
	 * @param netHeadYaw
	 * @param headPitch
	 * @param scaleFactor
	 */
	@Override
	public void setRotationAngles(SpruceWillisEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
								  float netHeadYaw, float headPitch, float scaleFactor) {
		legFrontLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;
		legFrontRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.5F * limbSwingAmount;
		legBackLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.5F * limbSwingAmount;
		legBackRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;
	}
}
