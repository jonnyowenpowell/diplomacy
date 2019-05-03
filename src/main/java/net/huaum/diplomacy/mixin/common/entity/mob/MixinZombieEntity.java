package net.huaum.diplomacy.mixin.common.entity.mob;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.FollowTargetGoal;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.huaum.diplomacy.common.entity.ai.goal.FollowTargetWithoutCarrotGoal;

@Mixin(ZombieEntity.class)
public abstract class MixinZombieEntity extends HostileEntity {

	@Shadow
	public static EntityAttribute SPAWN_REINFORCEMENTS;

	protected MixinZombieEntity(EntityType<? extends HostileEntity> type, World world) {
		super(type, world);
	}

	@Redirect(method = "initCustomGoals()V", at = @At(value = "NEW", target = "<init>(Lnet/minecraft/entity/mob/MobEntity;Ljava/lang/Class;Z)Lnet/minecraft/entity/ai/goal/FollowTargetGoal;"))
	public <T extends LivingEntity> FollowTargetGoal<T> replaceFollowTargetGoalPlayerEntity(MobEntity entity, Class<T> targetEntity, boolean checkVisiblity) {
		if (targetEntity == PlayerEntity.class) {
			return new FollowTargetWithoutCarrotGoal<>(entity, targetEntity, checkVisiblity);
		} else {
			return new FollowTargetGoal<>(entity, targetEntity, checkVisiblity);
		}
	}

	@Override
	public boolean isAngryAt(PlayerEntity playerEntity) {
		return !FollowTargetWithoutCarrotGoal.isHoldingCarrot(playerEntity);
	}
	
}
