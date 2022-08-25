/*
 * Spruce Willis the Xmas Tree - https://github.com/tophatcats-mods/spruce-willis-the-xmas-tree
 * Copyright (C) 2016-2022 <KiriCattus>
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

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import dev.tophatcat.sprucewillisthexmastree.entities.GrandfatherWillisEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

import javax.annotation.Nonnull;

public class GrandfatherWillisModel extends EntityModel<GrandfatherWillisEntity> {

    public ModelRenderer body;
    public ModelRenderer legBackLeft;
    public ModelRenderer legBackRight;
    public ModelRenderer legFrontLeft;
    public ModelRenderer legFrontRight;
    public ModelRenderer leaves1;
    public ModelRenderer leaves2;
    public ModelRenderer leaves3;
    public ModelRenderer leaves4;
    public ModelRenderer ornament;
    public ModelRenderer ornament_1;
    public ModelRenderer ornament_2;
    public ModelRenderer ornament_3;
    public ModelRenderer ornament_4;
    public ModelRenderer ornament_5;
    public ModelRenderer ornament_6;
    public ModelRenderer ornament_7;
    public ModelRenderer ornament_8;

    public GrandfatherWillisModel() {
        texWidth = 128;
        texHeight = 128;

        body = new ModelRenderer(this);
        body.setPos(0.0F, 7.0F, 0.0F);
        body.texOffs(0, 0).addBox(-4.0F, -16.0F, -3.0F,
            8.0F, 27.0F, 6.0F, 0.0F, false);

        legFrontLeft = new ModelRenderer(this);
        legFrontLeft.setPos(-2.0F, 11.0F, -3.0F);
        body.addChild(legFrontLeft);
        legFrontLeft.texOffs(28, 0).addBox(-2.0F, 0.0F, -4.0F,
            4.0F, 6.0F, 4.0F, 0.0F, false);

        legFrontRight = new ModelRenderer(this);
        legFrontRight.setPos(2.0F, 11.0F, -2.0F);
        body.addChild(legFrontRight);
        legFrontRight.texOffs(28, 0).addBox(-2.0F, 0.0F, -5.0F,
            4.0F, 6.0F, 4.0F, 0.0F, false);

        legBackLeft = new ModelRenderer(this);
        legBackLeft.setPos(-2.0F, 11.0F, 3.0F);
        body.addChild(legBackLeft);
        legBackLeft.texOffs(28, 0).addBox(-2.0F, 0.0F, 0.0F,
            4.0F, 6.0F, 4.0F, 0.0F, false);

        legBackRight = new ModelRenderer(this);
        legBackRight.setPos(2.0F, 11.0F, 3.0F);
        body.addChild(legBackRight);
        legBackRight.texOffs(28, 0).addBox(-2.0F, 0.0F, 0.0F,
            4.0F, 6.0F, 4.0F, 0.0F, false);

        leaves1 = new ModelRenderer(this);
        leaves1.setPos(0.0F, 5.0F, 0.0F);
        body.addChild(leaves1);
        leaves1.texOffs(28, 10).addBox(-10.0F, -6.0F, -10.0F,
            20.0F, 6.0F, 20.0F, 0.0F, false);

        ornament = new ModelRenderer(this);
        ornament.setPos(4.0F, 1.0F, 7.0F);
        leaves1.addChild(ornament);
        ornament.texOffs(31, 10).addBox(-1.5F, -1.5F, -1.5F,
            3.0F, 3.0F, 3.0F, 0.0F, false);

        ornament_1 = new ModelRenderer(this);
        ornament_1.setPos(7.0F, 1.0F, -1.0F);
        leaves1.addChild(ornament_1);
        ornament_1.texOffs(31, 16).addBox(-1.5F, -1.5F, -1.5F,
            3.0F, 3.0F, 3.0F, 0.0F, false);

        ornament_2 = new ModelRenderer(this);
        ornament_2.setPos(0.0F, 1.0F, -6.0F);
        leaves1.addChild(ornament_2);
        ornament_2.texOffs(31, 22).addBox(-1.5F, -1.5F, -1.5F,
            3.0F, 3.0F, 3.0F, 0.0F, false);

        ornament_3 = new ModelRenderer(this);
        ornament_3.setPos(-8.0F, 1.0F, 1.0F);
        leaves1.addChild(ornament_3);
        ornament_3.texOffs(31, 16).addBox(-1.5F, -1.5F, -1.5F,
            3.0F, 3.0F, 3.0F, 0.0F, false);

        leaves2 = new ModelRenderer(this);
        leaves2.setPos(0.0F, -2.0F, 0.0F);
        body.addChild(leaves2);
        leaves2.texOffs(0, 36).addBox(-8.0F, -6.0F, -8.0F,
            16.0F, 6.0F, 16.0F, 0.0F, false);

        ornament_4 = new ModelRenderer(this);
        ornament_4.setPos(-6.0F, 1.0F, 1.0F);
        leaves2.addChild(ornament_4);
        ornament_4.texOffs(31, 10).addBox(-1.5F, -1.5F, -1.5F,
            3.0F, 3.0F, 3.0F, 0.0F, false);

        ornament_5 = new ModelRenderer(this);
        ornament_5.setPos(5.0F, 1.0F, 6.0F);
        leaves2.addChild(ornament_5);
        ornament_5.texOffs(31, 22).addBox(-1.5F, -1.5F, -1.5F,
            3.0F, 3.0F, 3.0F, 0.0F, false);

        ornament_6 = new ModelRenderer(this);
        ornament_6.setPos(-1.0F, 1.0F, -6.0F);
        leaves2.addChild(ornament_6);
        ornament_6.texOffs(31, 16).addBox(-1.5F, -1.5F, -1.5F,
            3.0F, 3.0F, 3.0F, 0.0F, false);

        leaves3 = new ModelRenderer(this);
        leaves3.setPos(0.0F, -9.0F, 0.0F);
        body.addChild(leaves3);
        leaves3.texOffs(64, 36).addBox(-6.0F, -6.0F, -6.0F,
            12.0F, 6.0F, 12.0F, 0.0F, false);

        ornament_7 = new ModelRenderer(this);
        ornament_7.setPos(-0.5F, 1.0F, -4.0F);
        leaves3.addChild(ornament_7);
        ornament_7.texOffs(31, 10).addBox(-1.5F, -1.5F, -1.5F,
            3.0F, 3.0F, 3.0F, 0.0F, false);

        ornament_8 = new ModelRenderer(this);
        ornament_8.setPos(3.5F, 1.0F, 4.0F);
        leaves3.addChild(ornament_8);
        ornament_8.texOffs(31, 16).addBox(-1.5F, -1.5F, -1.5F,
            3.0F, 3.0F, 3.0F, 0.0F, false);

        leaves4 = new ModelRenderer(this);
        leaves4.setPos(0.0F, -16.0F, 0.0F);
        body.addChild(leaves4);
        leaves4.texOffs(92, 0).addBox(-4.0F, -6.0F, -4.0F,
            8.0F, 6.0F, 8.0F, 0.0F, false);
    }

    @Override
    public void setupAnim(@Nonnull GrandfatherWillisEntity entity, float limbSwing, float limbSwingAmount,
                          float ageInTicks, float netHeadYaw, float headPitch) {
        legFrontLeft.xRot = MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;
        legFrontRight.xRot = MathHelper.cos(limbSwing * 0.6662F
            + (float) Math.PI) * 0.5F * limbSwingAmount;
        legBackLeft.xRot = MathHelper.cos(limbSwing * 0.6662F
            + (float) Math.PI) * 0.5F * limbSwingAmount;
        legBackRight.xRot = MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;
    }

    @Override
    public void renderToBuffer(@Nonnull MatrixStack matrixStack, @Nonnull IVertexBuilder buffer, int packedLight,
                               int packedOverlay, float red, float green, float blue, float alpha) {
        body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}
