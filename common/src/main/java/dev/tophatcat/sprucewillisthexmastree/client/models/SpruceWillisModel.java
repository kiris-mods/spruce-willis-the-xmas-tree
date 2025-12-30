/*
 * A Minecraft mod made for WinterJam 2019, contains an Xmas tree named Spruce Willis.
 * Copyright (C) KiriCattus 2013 - 2025
 * https://github.com/kiris-mods/spruce-willis-the-xmas-tree/blob/dev/LICENSE.md
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE
 */
package dev.tophatcat.sprucewillisthexmastree.client.models;

import dev.tophatcat.sprucewillisthexmastree.client.rendering.WillisAnimations;
import dev.tophatcat.sprucewillisthexmastree.client.rendering.WillisRenderState;
import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class SpruceWillisModel extends EntityModel<WillisRenderState> {

    private final KeyframeAnimation idleAnimation;
    private final KeyframeAnimation walkingAnimation;

    public SpruceWillisModel(ModelPart root) {
        super(root);

        this.idleAnimation = WillisAnimations.SPRUCE_WILLIS_IDLE_ANIMATION.bake(root);
        this.walkingAnimation = WillisAnimations.SPRUCE_WILLIS_WALKING_ANIMATION.bake(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild(
            "body",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-4.0F, -16.0F, -3.0F, 8.0F, 27.0F, 6.0F,
                    new CubeDeformation(0.0F)),
            PartPose.offset(0.0F, 7.0F, 0.0F));

        PartDefinition frontLeftLeg = body.addOrReplaceChild(
            "frontLeftLeg",
            CubeListBuilder.create()
                .texOffs(28, 0)
                .addBox(-2.0F, 0.0F, -4.0F, 4.0F, 6.0F, 4.0F,
                    new CubeDeformation(0.0F)),
            PartPose.offset(-2.0F, 11.0F, -3.0F));

        PartDefinition frontRightLeg = body.addOrReplaceChild(
            "frontRightLeg",
            CubeListBuilder.create()
                .texOffs(28, 0)
                .addBox(-2.0F, 0.0F, -5.0F, 4.0F, 6.0F, 4.0F,
                    new CubeDeformation(0.0F)),
            PartPose.offset(2.0F, 11.0F, -2.0F));

        PartDefinition backLeftLeg = body.addOrReplaceChild(
            "backLeftLeg",
            CubeListBuilder.create()
                .texOffs(28, 0)
                .addBox(-2.0F, 0.0F, 0.0F, 4.0F, 6.0F, 4.0F,
                    new CubeDeformation(0.0F)),
            PartPose.offset(-2.0F, 11.0F, 3.0F));

        PartDefinition backRightleg = body.addOrReplaceChild(
            "backRightLeg",
            CubeListBuilder.create()
                .texOffs(28, 0)
                .addBox(-2.0F, 0.0F, 0.0F, 4.0F, 6.0F, 4.0F,
                    new CubeDeformation(0.0F)),
            PartPose.offset(2.0F, 11.0F, 3.0F));

        PartDefinition leaves1 = body.addOrReplaceChild(
            "leaves1",
            CubeListBuilder.create()
                .texOffs(28, 10)
                .addBox(-10.0F, -6.0F, -10.0F, 20.0F, 6.0F, 20.0F,
                    new CubeDeformation(0.0F)),
            PartPose.offset(0.0F, 5.0F, 0.0F));

        PartDefinition ornament = leaves1.addOrReplaceChild(
            "ornament",
            CubeListBuilder.create()
                .texOffs(31, 10)
                .addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)),
            PartPose.offset(4.0F, 1.0F, 7.0F));

        PartDefinition ornament_1 = leaves1.addOrReplaceChild(
            "ornament_1",
            CubeListBuilder.create()
                .texOffs(31, 16)
                .addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)),
            PartPose.offset(7.0F, 1.0F, -1.0F));

        PartDefinition ornament_2 = leaves1.addOrReplaceChild(
            "ornament_2",
            CubeListBuilder.create()
                .texOffs(31, 22)
                .addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)),
            PartPose.offset(0.0F, 1.0F, -6.0F));

        PartDefinition ornament_3 = leaves1.addOrReplaceChild(
            "ornament_3",
            CubeListBuilder.create()
                .texOffs(31, 16)
                .addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)),
            PartPose.offset(-8.0F, 1.0F, 1.0F));

        PartDefinition leaves2 = body.addOrReplaceChild(
            "leaves2",
            CubeListBuilder.create()
                .texOffs(0, 36)
                .addBox(-8.0F, -6.0F, -8.0F, 16.0F, 6.0F, 16.0F, new CubeDeformation(0.0F)),
            PartPose.offset(0.0F, -2.0F, 0.0F));

        PartDefinition ornament_4 = leaves2.addOrReplaceChild(
            "ornament_4",
            CubeListBuilder.create()
                .texOffs(31, 10)
                .addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)),
            PartPose.offset(-6.0F, 1.0F, 1.0F));

        PartDefinition ornament_5 = leaves2.addOrReplaceChild(
            "ornament_5",
            CubeListBuilder.create()
                .texOffs(31, 22)
                .addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)),
            PartPose.offset(5.0F, 1.0F, 6.0F));

        PartDefinition ornament_6 = leaves2.addOrReplaceChild(
            "ornament_6",
            CubeListBuilder.create()
                .texOffs(31, 16)
                .addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)),
            PartPose.offset(-1.0F, 1.0F, -6.0F));

        PartDefinition leaves3 = body.addOrReplaceChild(
            "leaves3",
            CubeListBuilder.create()
                .texOffs(64, 36)
                .addBox(-6.0F, -6.0F, -6.0F, 12.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)),
            PartPose.offset(0.0F, -9.0F, 0.0F));

        PartDefinition ornament_7 = leaves3.addOrReplaceChild(
            "ornament_7",
            CubeListBuilder.create()
                .texOffs(31, 10)
                .addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)),
            PartPose.offset(-0.5F, 1.0F, -4.0F));

        PartDefinition ornament_8 = leaves3.addOrReplaceChild(
            "ornament_8",
            CubeListBuilder.create()
                .texOffs(31, 16)
                .addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)),
            PartPose.offset(3.5F, 1.0F, 4.0F));

        PartDefinition leaves4 = body.addOrReplaceChild(
            "leaves4",
            CubeListBuilder.create()
                .texOffs(92, 0)
                .addBox(-4.0F, -6.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)),
            PartPose.offset(0.0F, -16.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(WillisRenderState renderState) {
        super.setupAnim(renderState);
        walkingAnimation.applyWalk(renderState.walkAnimationPos, renderState.walkAnimationSpeed, 3.5F, 3.5F);
        idleAnimation.apply(renderState.idleAnimationState, renderState.ageInTicks);
    }
}
