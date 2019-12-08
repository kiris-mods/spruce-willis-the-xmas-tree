package com.mcmoddev.sprucewillisthexmastree.common.entities;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MoveTowardsVillageGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

/**
 *
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
	}

	/**
	 * Register the mobs attributes.
	 */
	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.20D);
	}

	/**
	 * @param damageSourceIn The source of the pain.
	 * @return The sound the mob should make when it's hurt.
	 */
	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
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
