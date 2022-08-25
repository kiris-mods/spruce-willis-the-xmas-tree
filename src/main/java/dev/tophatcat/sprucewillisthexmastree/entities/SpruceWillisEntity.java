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
package dev.tophatcat.sprucewillisthexmastree.entities;

import dev.tophatcat.sprucewillisthexmastree.init.WillisRegistry;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MoveTowardsTargetGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nonnull;

public class SpruceWillisEntity extends CreatureEntity {

    public SpruceWillisEntity(EntityType<? extends CreatureEntity> type, World world) {
        super(type, world);
    }

    @Override
    protected void registerGoals() {
        goalSelector.addGoal(2, new AvoidEntityGoal<>(this, PlayerEntity.class, 6.0F,
            1.0D, 1.5D));
        goalSelector.addGoal(2, new MoveTowardsTargetGoal(new GrandfatherWillisEntity(
            WillisRegistry.GRANDFATHER_SPRUCE_WILLIS.get(), level), 1.0D, 1.5F));
        goalSelector.addGoal(3, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        goalSelector.addGoal(4, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        goalSelector.addGoal(5, new LookRandomlyGoal(this));
        goalSelector.addGoal(6, new SwimGoal(this));
    }

    public static AttributeModifierMap.MutableAttribute spruceWillisAttributes() {
        return CreatureEntity.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 40.0D)
            .add(Attributes.MOVEMENT_SPEED, 0.25D);
    }

    @Nonnull
    @Override
    protected ActionResultType mobInteract(PlayerEntity player, @Nonnull Hand hand) {
        ItemStack heldItem = player.getItemInHand(hand);
        GrandfatherWillisEntity grandWillis = WillisRegistry.GRANDFATHER_SPRUCE_WILLIS.get().create(level);
        if (heldItem.getItem() == Items.BONE_MEAL) {
            level.playSound(player, getX(), getY(), getZ(), SoundEvents.BELL_RESONATE, getSoundSource(),
                1.0F, random.nextFloat() * 0.4F + 0.8F);
            if (!level.isClientSide) {
                assert grandWillis != null;
                grandWillis.moveTo(xOld, yOld, zOld, yRot, xRot);
                level.addFreshEntity(grandWillis);
                remove();
                if (!player.abilities.instabuild) {
                    heldItem.shrink(1);
                }
            }

            return ActionResultType.sidedSuccess(level.isClientSide);
        } else {
            return super.mobInteract(player, hand);
        }
    }

    @Override
    public void thunderHit(@Nonnull ServerWorld world, @Nonnull LightningBoltEntity lightningBolt) {
        GrandfatherWillisEntity grandWillis = WillisRegistry.GRANDFATHER_SPRUCE_WILLIS.get().create(world);
        assert grandWillis != null;
        grandWillis.moveTo(xOld, yOld, zOld, yRot, xRot);
        level.addFreshEntity(grandWillis);
        remove();
    }

    @Override
    protected SoundEvent getHurtSound(@Nonnull DamageSource damageSourceIn) {
        return SoundEvents.WOOD_HIT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.WOOD_BREAK;
    }
}
