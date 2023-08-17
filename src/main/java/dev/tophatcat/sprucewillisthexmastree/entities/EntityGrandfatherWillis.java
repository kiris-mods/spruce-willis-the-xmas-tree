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

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.AmbientEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class EntityGrandfatherWillis extends PathAwareEntity {

    public EntityGrandfatherWillis(EntityType<? extends PathAwareEntity> type, World level) {
        super(type, level);
    }

    @Override
    protected void initGoals() {
        goalSelector.add(1, new MoveThroughVillageGoal(this, 1.0F,
                false, 4, this::canBreakDoors));
        goalSelector.add(3, new WanderAroundFarGoal(this, 1.0D));
        goalSelector.add(4, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        goalSelector.add(5, new LookAroundGoal(this));
        goalSelector.add(6, new SwimGoal(this));
    }

    private boolean canBreakDoors() {
        return false;
    }

    public static DefaultAttributeContainer.Builder grandfatherWillisAttributes() {
        return AmbientEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 75.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.20D);
    }

    @Override
    protected SoundEvent getHurtSound(@NotNull DamageSource damageSource) {
        return SoundEvents.BLOCK_WOOD_HIT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.BLOCK_WOOD_BREAK;
    }
}
