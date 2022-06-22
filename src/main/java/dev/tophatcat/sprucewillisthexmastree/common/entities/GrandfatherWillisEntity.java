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
package dev.tophatcat.sprucewillisthexmastree.common.entities;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

/**
 * The setup class for Grandfather Spruce Willis.
 */
public class GrandfatherWillisEntity extends CreatureEntity {

    /**
     * @param type  The type of entity.
     * @param world The world.
     */
    public GrandfatherWillisEntity(EntityType<? extends CreatureEntity> type, World world) {
        super(type, world);
    }

    /**
     * Register the mobs AI tasks.
     */
    @Override
    protected void registerGoals() {
        goalSelector.addGoal(1, new MoveTowardsVillageGoal(this, 1.0F));
        goalSelector.addGoal(3, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        goalSelector.addGoal(4, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        goalSelector.addGoal(5, new LookRandomlyGoal(this));
        goalSelector.addGoal(6, new SwimGoal(this));
    }

    /**
     * Register the mobs attributes.
     */
    public static AttributeModifierMap.MutableAttribute grandfatherWillisAttributes() {
        return CreatureEntity.registerAttributes()
            .createMutableAttribute(Attributes.MAX_HEALTH, 75.0D)
            .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.20D);
    }

    /**
     * @param damageSource The source of the pain.
     * @return The sound the mob should make when it's hurt.
     */
    @Override
    protected SoundEvent getHurtSound(@Nonnull DamageSource damageSource) {
        return SoundEvents.BLOCK_WOOD_HIT;
    }

    /**
     * @return The sound the mob should make when it dies.
     */
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.BLOCK_WOOD_BREAK;
    }
}
