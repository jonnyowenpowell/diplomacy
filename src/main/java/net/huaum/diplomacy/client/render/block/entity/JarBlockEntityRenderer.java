package net.huaum.diplomacy.client.render.block.entity;

import com.mojang.blaze3d.platform.GlStateManager;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.huaum.diplomacy.common.block.entity.JarBlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
public class JarBlockEntityRenderer extends BlockEntityRenderer<JarBlockEntity> {

   private Entity renderedEntity;

   public JarBlockEntityRenderer() {
      super();
   }

   @Override
   public void render(JarBlockEntity jarBlockEntity, double double_1, double double_2, double double_3, float float_1, int int_1) {
      GlStateManager.pushMatrix();
      GlStateManager.translatef((float)double_1 + 0.5F, (float)double_2, (float)double_3 + 0.5F);
      if (this.renderedEntity == null) {
         this.renderedEntity = new PigEntity(EntityType.PIG, jarBlockEntity.getWorld());
      }
      if (renderedEntity != null) {
         float float_2 = 0.23125F;
         float float_3 = Math.max(renderedEntity.getWidth(), renderedEntity.getHeight());
         if ((double)float_3 > 1.0D) {
            float_2 /= float_3;
         }

         GlStateManager.translatef(0.0F, 0.4F, 0.0F);
         GlStateManager.rotatef((float)MathHelper.lerp((double)float_1, 0, 0) * 10.0F, 0.0F, 1.0F, 0.0F);
         GlStateManager.translatef(0.0F, -0.2F, 0.0F);
         GlStateManager.rotatef(-30.0F, 1.0F, 0.0F, 0.0F);
         GlStateManager.scalef(float_2, float_2, float_2);
         renderedEntity.setPositionAndAngles(double_1, double_2, double_3, 0.0F, 0.0F);
         MinecraftClient.getInstance().getEntityRenderManager().render(renderedEntity, 0.0D, 0.0D, 0.0D, 0.0F, float_1, false);
      }
      GlStateManager.popMatrix();
   }

}
