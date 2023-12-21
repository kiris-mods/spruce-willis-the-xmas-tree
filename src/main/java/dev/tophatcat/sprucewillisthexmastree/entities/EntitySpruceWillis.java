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
package dev.tophatcat.sprucewillisthexmastree.entities;

import dev.tophatcat.sprucewillisthexmastree.SpruceWillisTheXmasTree;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ambient.AmbientCreature;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class EntitySpruceWillis extends PathfinderMob {

    public EntitySpruceWillis(EntityType<? extends PathfinderMob> type, Level world) {
        super(type, world);
    }

    @Override
    protected void registerGoals() {
        goalSelector.addGoal(2, new AvoidEntityGoal<>(this, Player.class,
                6.0F, 1.0D, 1.5D));
        goalSelector.addGoal(2, new FollowMobGoal(new EntityGrandfatherWillis(
                SpruceWillisTheXmasTree.GRANDFATHER_SPRUCE_WILLIS.get(), level()), 1.0F, 0.5F, 1.5F));
        goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 8.0F));
        goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        goalSelector.addGoal(6, new FloatGoal(this));
    }

    public static AttributeSupplier.Builder spruceWillisAttributes() {
        return AmbientCreature.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 40.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.25D);
    }

    @NotNull
    @Override
    protected InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack heldItem = player.getItemInHand(hand);
        if (heldItem.getItem() == Items.BONE_MEAL) {
            level().playSound(player, getX(), getY(), getZ(), SoundEvents.BELL_RESONATE, getSoundSource(),
                    1.0F, random.nextFloat() * 0.4F + 0.8F);
            if (!level().isClientSide) {
                convertTo(SpruceWillisTheXmasTree.GRANDFATHER_SPRUCE_WILLIS.get(), false);
                if (!player.getAbilities().instabuild) {
                    heldItem.shrink(1);
                }
            }

            return InteractionResult.sidedSuccess(level().isClientSide);
        } else {
            return super.mobInteract(player, hand);
        }
    }

    @Override
    public void thunderHit(@NotNull ServerLevel world, @NotNull LightningBolt lightningBolt) {
        convertTo(SpruceWillisTheXmasTree.GRANDFATHER_SPRUCE_WILLIS.get(), false);
    }

    @Override
    protected SoundEvent getHurtSound(@NotNull DamageSource damageSourceIn) {
        return SoundEvents.WOOD_HIT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.WOOD_BREAK;
    }
}
