package net.huaum.diplomacy.goal;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.ai.goal.FollowTargetGoal;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class FollowTargetWithoutCarrotGoal<T extends LivingEntity> extends FollowTargetGoal<T> {

   public FollowTargetWithoutCarrotGoal(MobEntity entity, Class<T> targetEntity, boolean checkVisiblity) {
      super(entity, targetEntity, checkVisiblity, false);
      this.targetPredicate = (new TargetPredicate()).setBaseMaxDistance(this.getFollowRange()).setPredicate(potentialTarget -> {
         return !isHoldingCarrot(potentialTarget);
      });
   }

   public static boolean isHoldingCarrot(LivingEntity entity) {
      if (entity != null) {
         Stream<ItemStack> heldItems = StreamSupport.stream(entity.getItemsHand().spliterator(), true);
		   boolean holdingCarrot = heldItems.anyMatch(stack->stack.getItem() == Items.CARROT);
	   	return holdingCarrot;
      }
		return false;
	}

   @Override
   public boolean shouldContinue() {
      if (super.shouldContinue()) {
         LivingEntity livingEntity = this.entity.getTarget();
         if (livingEntity == null) {
            livingEntity = this.target;
         }
         return !isHoldingCarrot(livingEntity);
      }
      return false;
   }

}
