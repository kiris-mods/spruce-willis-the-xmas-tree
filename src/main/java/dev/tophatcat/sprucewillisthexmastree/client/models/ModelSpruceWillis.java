/*
 * Spruce Willis the Xmas Tree - https://github.com/tophatcats-mods/spruce-willis-the-xmas-tree
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

import dev.tophatcat.sprucewillisthexmastree.entities.EntitySpruceWillis;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import org.jetbrains.annotations.NotNull;

public class ModelSpruceWillis<T extends EntitySpruceWillis> extends EntityModel<T> {

    private final ModelPart body;
    private final ModelPart legFrontLeft;
    private final ModelPart legFrontRight;
    private final ModelPart legBackLeft;
    private final ModelPart legBackRight;

    public ModelSpruceWillis(ModelPart root) {
        body = root.getChild("body");
        legFrontLeft = body.getChild("legFrontLeft");
        legFrontRight = body.getChild("legFrontRight");
        legBackLeft = body.getChild("legBackLeft");
        legBackRight = body.getChild("legBackRight");
    }

    public static TexturedModelData getTextureModelData() {
        ModelData meshdefinition = new ModelData();
        ModelPartData partdefinition = meshdefinition.getRoot();

        ModelPartData body = partdefinition.addChild("body",
                ModelPartBuilder.create().uv(0, 0)
                        .cuboid(-4.0F, -16.0F, -3.0F,
                                8.0F, 27.0F, 6.0F,
                                new Dilation(0.0F)),
                ModelTransform.pivot(0.0F, 7.0F, 0.0F));

        ModelPartData legFrontLeft = body.addChild("legFrontLeft",
                ModelPartBuilder.create().uv(28, 0)
                        .cuboid(-2.0F, 0.0F, -4.0F,
                                4.0F, 6.0F, 4.0F,
                                new Dilation(0.0F)),
                ModelTransform.pivot(-2.0F, 11.0F, -3.0F));

        ModelPartData legFrontRight = body.addChild("legFrontRight",
                ModelPartBuilder.create().uv(28, 0)
                        .cuboid(-2.0F, 0.0F, -5.0F,
                                4.0F, 6.0F, 4.0F,
                                new Dilation(0.0F)),
                ModelTransform.pivot(2.0F, 11.0F, -2.0F));

        ModelPartData legBackLeft = body.addChild("legBackLeft",
                ModelPartBuilder.create().uv(28, 0)
                        .cuboid(-2.0F, 0.0F, 0.0F,
                                4.0F, 6.0F, 4.0F,
                                new Dilation(0.0F)),
                ModelTransform.pivot(-2.0F, 11.0F, 3.0F));

        ModelPartData legBackRight = body.addChild("legBackRight",
                ModelPartBuilder.create().uv(28, 0)
                        .cuboid(-2.0F, 0.0F, 0.0F,
                                4.0F, 6.0F, 4.0F,
                                new Dilation(0.0F)),
                ModelTransform.pivot(2.0F, 11.0F, 3.0F));

        ModelPartData leaves1 = body.addChild("leaves1",
                ModelPartBuilder.create().uv(28, 10)
                        .cuboid(-10.0F, -6.0F, -10.0F,
                                20.0F, 6.0F, 20.0F,
                                new Dilation(0.0F)),
                ModelTransform.pivot(0.0F, 5.0F, 0.0F));

        ModelPartData ornament = leaves1.addChild("ornament",
                ModelPartBuilder.create().uv(31, 10)
                        .cuboid(-1.5F, -1.5F, -1.5F,
                                3.0F, 3.0F, 3.0F,
                                new Dilation(0.0F)),
                ModelTransform.pivot(4.0F, 1.0F, 7.0F));

        ModelPartData ornament_1 = leaves1.addChild("ornament_1",
                ModelPartBuilder.create().uv(31, 16)
                        .cuboid(-1.5F, -1.5F, -1.5F,
                                3.0F, 3.0F, 3.0F,
                                new Dilation(0.0F)),
                ModelTransform.pivot(7.0F, 1.0F, -1.0F));

        ModelPartData ornament_2 = leaves1.addChild("ornament_2",
                ModelPartBuilder.create().uv(31, 22)
                        .cuboid(-1.5F, -1.5F, -1.5F,
                                3.0F, 3.0F, 3.0F,
                                new Dilation(0.0F)),
                ModelTransform.pivot(0.0F, 1.0F, -6.0F));

        ModelPartData ornament_3 = leaves1.addChild("ornament_3",
                ModelPartBuilder.create().uv(31, 16)
                        .cuboid(-1.5F, -1.5F, -1.5F,
                                3.0F, 3.0F, 3.0F,
                                new Dilation(0.0F)),
                ModelTransform.pivot(-8.0F, 1.0F, 1.0F));

        ModelPartData leaves2 = body.addChild("leaves2",
                ModelPartBuilder.create().uv(0, 36)
                        .cuboid(-8.0F, -6.0F, -8.0F,
                                16.0F, 6.0F, 16.0F,
                                new Dilation(0.0F)),
                ModelTransform.pivot(0.0F, -2.0F, 0.0F));

        ModelPartData ornament_4 = leaves2.addChild("ornament_4",
                ModelPartBuilder.create().uv(31, 10)
                        .cuboid(-1.5F, -1.5F, -1.5F,
                                3.0F, 3.0F, 3.0F,
                                new Dilation(0.0F)),
                ModelTransform.pivot(-6.0F, 1.0F, 1.0F));

        ModelPartData ornament_5 = leaves2.addChild("ornament_5",
                ModelPartBuilder.create().uv(31, 22)
                        .cuboid(-1.5F, -1.5F, -1.5F,
                                3.0F, 3.0F, 3.0F,
                                new Dilation(0.0F)),
                ModelTransform.pivot(5.0F, 1.0F, 6.0F));

        ModelPartData ornament_6 = leaves2.addChild("ornament_6",
                ModelPartBuilder.create().uv(31, 16)
                        .cuboid(-1.5F, -1.5F, -1.5F,
                                3.0F, 3.0F, 3.0F,
                                new Dilation(0.0F)),
                ModelTransform.pivot(-1.0F, 1.0F, -6.0F));

        ModelPartData leaves3 = body.addChild("leaves3",
                ModelPartBuilder.create().uv(64, 36)
                        .cuboid(-6.0F, -6.0F, -6.0F,
                                12.0F, 6.0F, 12.0F,
                                new Dilation(0.0F)),
                ModelTransform.pivot(0.0F, -9.0F, 0.0F));

        ModelPartData ornament_7 = leaves3.addChild("ornament_7",
                ModelPartBuilder.create().uv(31, 10)
                        .cuboid(-1.5F, -1.5F, -1.5F,
                                3.0F, 3.0F, 3.0F,
                                new Dilation(0.0F)),
                ModelTransform.pivot(-0.5F, 1.0F, -4.0F));

        ModelPartData ornament_8 = leaves3.addChild("ornament_8",
                ModelPartBuilder.create().uv(31, 16)
                        .cuboid(-1.5F, -1.5F, -1.5F,
                                3.0F, 3.0F, 3.0F,
                                new Dilation(0.0F)),
                ModelTransform.pivot(3.5F, 1.0F, 4.0F));

        ModelPartData leaves4 = body.addChild("leaves4",
                ModelPartBuilder.create().uv(92, 0)
                        .cuboid(-4.0F, -6.0F, -4.0F,
                                8.0F, 6.0F, 8.0F,
                                new Dilation(0.0F)),
                ModelTransform.pivot(0.0F, -16.0F, 0.0F));

        return TexturedModelData.of(meshdefinition, 128, 128);
    }

    @Override
    public void setAngles(@NotNull T entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                          float netHeadYaw, float headPitch) {
        legFrontLeft.pitch = MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;
        legFrontRight.pitch = MathHelper.cos(limbSwing * 0.6662F
                + (float) Math.PI) * 0.5F * limbSwingAmount;
        legBackLeft.pitch = MathHelper.cos(limbSwing * 0.6662F
                + (float) Math.PI) * 0.5F * limbSwingAmount;
        legBackRight.pitch = MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;
    }

    @Override
    public void render(@NotNull MatrixStack matrixStack, @NotNull VertexConsumer buffer, int packedLight,
                       int packedOverlay, float red, float green, float blue, float alpha) {
        body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
