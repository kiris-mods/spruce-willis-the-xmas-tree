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
package dev.tophatcat.sprucewillisthexmastree.entities;

import dev.tophatcat.sprucewillisthexmastree.SpruceWillisTheXmasTree;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.AmbientEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class EntitySpruceWillis extends PathAwareEntity {

    public EntitySpruceWillis(EntityType<? extends PathAwareEntity> type, World world) {
        super(type, world);
    }

    @Override
    protected void initGoals() {
        goalSelector.add(2, new FleeEntityGoal<>(this, PlayerEntity.class,
                6.0F, 1.0D, 1.5D));
        goalSelector.add(2, new FollowMobGoal(new EntityGrandfatherWillis(
                SpruceWillisTheXmasTree.GRANDFATHER_SPRUCE_WILLIS, getWorld()), 1.0F, 0.5F, 1.5F));
        goalSelector.add(3, new WanderAroundFarGoal(this, 1.0D));
        goalSelector.add(4, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        goalSelector.add(5, new LookAroundGoal(this));
        goalSelector.add(6, new SwimGoal(this));
    }

    public static DefaultAttributeContainer.Builder spruceWillisAttributes() {
        return AmbientEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 40.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25D);
    }

    @NotNull
    @Override
    protected ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack heldItem = player.getStackInHand(hand);
        if (heldItem.getItem() == Items.BONE_MEAL) {
            getWorld().playSound(player, getX(), getY(), getZ(), SoundEvents.BLOCK_BELL_RESONATE, getSoundCategory(),
                    1.0F, random.nextFloat() * 0.4F + 0.8F);
            if (!getWorld().isClient) {
                convertTo(SpruceWillisTheXmasTree.GRANDFATHER_SPRUCE_WILLIS, false);
                if (!player.getAbilities().creativeMode) {
                    heldItem.decrement(1);
                }
            }

            return ActionResult.success(getWorld().isClient);
        } else {
            return super.interactMob(player, hand);
        }
    }

    @Override
    public void onStruckByLightning(@NotNull ServerWorld world, @NotNull LightningEntity lightningBolt) {
        convertTo(SpruceWillisTheXmasTree.GRANDFATHER_SPRUCE_WILLIS, false);
    }

    @Override
    protected SoundEvent getHurtSound(@NotNull DamageSource damageSourceIn) {
        return SoundEvents.BLOCK_WOOD_HIT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.BLOCK_WOOD_BREAK;
    }
}
