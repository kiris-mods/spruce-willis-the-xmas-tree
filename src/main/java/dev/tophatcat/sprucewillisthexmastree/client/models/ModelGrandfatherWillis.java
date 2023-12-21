/*
 * Spruce Willis the Xmas Tree - https://github.com/kiris-mods/spruce-willis-the-xmas-tree
 * Copyright (C) 2013-2023 <KiriCattus>
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
package dev.tophatcat.sprucewillisthexmastree.client.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.tophatcat.sprucewillisthexmastree.SpruceWillisTheXmasTree;
import dev.tophatcat.sprucewillisthexmastree.entities.EntityGrandfatherWillis;
import net.minecraft.client.model.*;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

public class ModelGrandfatherWillis<T extends EntityGrandfatherWillis> extends EntityModel<T> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
        new ResourceLocation(SpruceWillisTheXmasTree.MOD_ID, "spruce_willis_the_xmas_tree"),
        "main");

    private final ModelPart body;
    private final ModelPart legFrontLeft;
    private final ModelPart legFrontRight;
    private final ModelPart legBackLeft;
    private final ModelPart legBackRight;

    public ModelGrandfatherWillis(ModelPart root) {
        body = root.getChild("body");
        legFrontLeft = body.getChild("legFrontLeft");
        legFrontRight = body.getChild("legFrontRight");
        legBackLeft = body.getChild("legBackLeft");
        legBackRight = body.getChild("legBackRight");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-4.0F, -16.0F, -3.0F,
                                8.0F, 27.0F, 6.0F,
                                new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 7.0F, 0.0F));

        PartDefinition legFrontLeft = body.addOrReplaceChild("legFrontLeft",
                CubeListBuilder.create().texOffs(28, 0)
                        .addBox(-2.0F, 0.0F, -4.0F,
                                4.0F, 6.0F, 4.0F,
                                new CubeDeformation(0.0F)),
                PartPose.offset(-2.0F, 11.0F, -3.0F));

        PartDefinition legFrontRight = body.addOrReplaceChild("legFrontRight",
                CubeListBuilder.create().texOffs(28, 0)
                        .addBox(-2.0F, 0.0F, -5.0F,
                                4.0F, 6.0F, 4.0F,
                                new CubeDeformation(0.0F)),
                PartPose.offset(2.0F, 11.0F, -2.0F));

        PartDefinition legBackLeft = body.addOrReplaceChild("legBackLeft",
                CubeListBuilder.create().texOffs(28, 0)
                        .addBox(-2.0F, 0.0F, 0.0F,
                                4.0F, 6.0F, 4.0F,
                                new CubeDeformation(0.0F)),
                PartPose.offset(-2.0F, 11.0F, 3.0F));

        PartDefinition legBackRight = body.addOrReplaceChild("legBackRight",
                CubeListBuilder.create().texOffs(28, 0)
                        .addBox(-2.0F, 0.0F, 0.0F,
                                4.0F, 6.0F, 4.0F,
                                new CubeDeformation(0.0F)),
                PartPose.offset(2.0F, 11.0F, 3.0F));

        PartDefinition leaves1 = body.addOrReplaceChild("leaves1",
                CubeListBuilder.create().texOffs(28, 10)
                        .addBox(-10.0F, -6.0F, -10.0F,
                                20.0F, 6.0F, 20.0F,
                                new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 5.0F, 0.0F));

        PartDefinition ornament = leaves1.addOrReplaceChild("ornament",
                CubeListBuilder.create().texOffs(31, 10)
                        .addBox(-1.5F, -1.5F, -1.5F,
                                3.0F, 3.0F, 3.0F,
                                new CubeDeformation(0.0F)),
                PartPose.offset(4.0F, 1.0F, 7.0F));

        PartDefinition ornament_1 = leaves1.addOrReplaceChild("ornament_1",
                CubeListBuilder.create().texOffs(31, 16)
                        .addBox(-1.5F, -1.5F, -1.5F,
                                3.0F, 3.0F, 3.0F,
                                new CubeDeformation(0.0F)),
                PartPose.offset(7.0F, 1.0F, -1.0F));

        PartDefinition ornament_2 = leaves1.addOrReplaceChild("ornament_2",
                CubeListBuilder.create().texOffs(31, 22)
                        .addBox(-1.5F, -1.5F, -1.5F,
                                3.0F, 3.0F, 3.0F,
                                new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 1.0F, -6.0F));

        PartDefinition ornament_3 = leaves1.addOrReplaceChild("ornament_3",
                CubeListBuilder.create().texOffs(31, 16)
                        .addBox(-1.5F, -1.5F, -1.5F,
                                3.0F, 3.0F, 3.0F,
                                new CubeDeformation(0.0F)),
                PartPose.offset(-8.0F, 1.0F, 1.0F));

        PartDefinition leaves2 = body.addOrReplaceChild("leaves2",
                CubeListBuilder.create().texOffs(0, 36)
                        .addBox(-8.0F, -6.0F, -8.0F,
                                16.0F, 6.0F, 16.0F,
                                new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, -2.0F, 0.0F));

        PartDefinition ornament_4 = leaves2.addOrReplaceChild("ornament_4",
                CubeListBuilder.create().texOffs(31, 10)
                        .addBox(-1.5F, -1.5F, -1.5F,
                                3.0F, 3.0F, 3.0F,
                                new CubeDeformation(0.0F)),
                PartPose.offset(-6.0F, 1.0F, 1.0F));

        PartDefinition ornament_5 = leaves2.addOrReplaceChild("ornament_5",
                CubeListBuilder.create().texOffs(31, 22)
                        .addBox(-1.5F, -1.5F, -1.5F,
                                3.0F, 3.0F, 3.0F,
                                new CubeDeformation(0.0F)),
                PartPose.offset(5.0F, 1.0F, 6.0F));

        PartDefinition ornament_6 = leaves2.addOrReplaceChild("ornament_6",
                CubeListBuilder.create().texOffs(31, 16)
                        .addBox(-1.5F, -1.5F, -1.5F,
                                3.0F, 3.0F, 3.0F,
                                new CubeDeformation(0.0F)),
                PartPose.offset(-1.0F, 1.0F, -6.0F));

        PartDefinition leaves3 = body.addOrReplaceChild("leaves3",
                CubeListBuilder.create().texOffs(64, 36)
                        .addBox(-6.0F, -6.0F, -6.0F,
                                12.0F, 6.0F, 12.0F,
                                new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, -9.0F, 0.0F));

        PartDefinition ornament_7 = leaves3.addOrReplaceChild("ornament_7",
                CubeListBuilder.create().texOffs(31, 10)
                        .addBox(-1.5F, -1.5F, -1.5F,
                                3.0F, 3.0F, 3.0F,
                                new CubeDeformation(0.0F)),
                PartPose.offset(-0.5F, 1.0F, -4.0F));

        PartDefinition ornament_8 = leaves3.addOrReplaceChild("ornament_8",
                CubeListBuilder.create().texOffs(31, 16)
                        .addBox(-1.5F, -1.5F, -1.5F,
                                3.0F, 3.0F, 3.0F,
                                new CubeDeformation(0.0F)),
                PartPose.offset(3.5F, 1.0F, 4.0F));

        PartDefinition leaves4 = body.addOrReplaceChild("leaves4",
                CubeListBuilder.create().texOffs(92, 0)
                        .addBox(-4.0F, -6.0F, -4.0F,
                                8.0F, 6.0F, 8.0F,
                                new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, -16.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(@NotNull T entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                          float netHeadYaw, float headPitch) {
        legFrontLeft.xRot = Mth.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;
        legFrontRight.xRot = Mth.cos(limbSwing * 0.6662F
                + (float) Math.PI) * 0.5F * limbSwingAmount;
        legBackLeft.xRot = Mth.cos(limbSwing * 0.6662F
                + (float) Math.PI) * 0.5F * limbSwingAmount;
        legBackRight.xRot = Mth.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;
    }

    @Override
    public void renderToBuffer(@NotNull PoseStack matrixStack, @NotNull VertexConsumer buffer, int packedLight,
                       int packedOverlay, float red, float green, float blue, float alpha) {
        body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
