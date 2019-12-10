package com.mcmoddev.sprucewillisthexmastree.common.entities;

import com.mcmoddev.sprucewillisthexmastree.common.init.RegistryEntity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
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
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

/**
 * The Spruce Willis mob setup class.
 */
public class SpruceWillisEntity extends CreatureEntity {

	/**
	 * @param type  The type of entity.
	 * @param world The world.
	 */
	public SpruceWillisEntity(EntityType<? extends CreatureEntity> type, World world) {
		super(type, world);
	}

	/**
	 * Register the mobs AI tasks.
	 */
	@Override
	protected void registerGoals() {
		goalSelector.addGoal(2, new AvoidEntityGoal<>(this, PlayerEntity.class, 6.0F,
			1.0D, 1.5D));
		goalSelector.addGoal(2, new MoveTowardsTargetGoal(new GrandfatherWillisEntity(
			RegistryEntity.GRANDFATHER_SPRUCE_WILLIS, world), 1.0D, 1.5F));
		goalSelector.addGoal(3, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		goalSelector.addGoal(4, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		goalSelector.addGoal(5, new LookRandomlyGoal(this));
		goalSelector.addGoal(6, new SwimGoal(this));
	}

	/**
	 * Register the mobs attributes.
	 */
	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
	}

	/**
	 * When right clicked with bone meal Spruce Willis the Xmas Tree should be replaced with Grandfather Spruce Willis
	 * the Xmas tree.
	 *
	 * @param player The player interacting with the entity.
	 * @param hand   The players hand.
	 * @return Return if the interaction event was successful or not.
	 */
	@Override
	protected boolean processInteract(PlayerEntity player, Hand hand) {
		ItemStack heldItem = player.getHeldItem(hand);
		GrandfatherWillisEntity grandWillis = RegistryEntity.GRANDFATHER_SPRUCE_WILLIS.create(world);
		if (heldItem.getItem() == Items.BONE_MEAL) {
			world.playSound(player, posX, posY, posZ, SoundEvents.BLOCK_BELL_USE, getSoundCategory(),
				1.0F, rand.nextFloat() * 0.4F + 0.8F);
			player.swingArm(hand);
			if (!world.isRemote) {
				grandWillis.setLocationAndAngles(posX, posY, posZ, rotationYaw, rotationPitch);
				world.addEntity(grandWillis);
				remove();
				if (!player.abilities.isCreativeMode) {
					heldItem.shrink(1);
				}
				return true;
			}
		}
		return super.processInteract(player, hand);
	}

	/**
	 * When this entity is struck by lightning it turns into Grandfather Spruce Willis the Wise.
	 *
	 * @param lightningBolt The lightning bolt entity.
	 */
	@Override
	public void onStruckByLightning(LightningBoltEntity lightningBolt) {
		GrandfatherWillisEntity grandWillis = RegistryEntity.GRANDFATHER_SPRUCE_WILLIS.create(world);
		grandWillis.setLocationAndAngles(posX, posY, posZ, rotationYaw, rotationPitch);
		if (this.hasCustomName()) {
			grandWillis.setCustomName(getCustomName());
			grandWillis.setCustomNameVisible(isCustomNameVisible());
		}

		world.addEntity(grandWillis);
		remove();
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
