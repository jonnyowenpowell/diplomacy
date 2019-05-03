package net.huaum.diplomacy.mixin;

import net.minecraft.entity.ai.goal.CreeperIgniteGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.CreeperEntity;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CreeperIgniteGoal.class)
public abstract class MixinCreeperIgniteGoal extends Goal {

	@Shadow
	private CreeperEntity owner;

	@Inject(method = "tick()V", at = @At("RETURN"), cancellable = true)
	private void onTick(CallbackInfo ci) {
		CreeperEntity creeper = this.owner;
		if(creeper.getFuseSpeed() > 0 && creeper.isTouchingWater()) {
			creeper.setFuseSpeed(-1);
		}
	}
	
}
