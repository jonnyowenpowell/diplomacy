package net.huaum.diplomacy.client.render.block.entity;

import com.mojang.blaze3d.platform.GlStateManager;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.huaum.diplomacy.common.block.entity.JarBlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.CreeperEntity;

@Environment(EnvType.CLIENT)
public class JarBlockEntityRenderer extends BlockEntityRenderer<JarBlockEntity> {

   private CreeperEntity renderedEntity;
   private float scale;

   @Override
   public void render(JarBlockEntity jarBlockEntity, double x, double y, double z, float delta, int pass) {
      if (this.renderedEntity == null) {
         this.renderedEntity = new CreeperEntity(EntityType.CREEPER, jarBlockEntity.getWorld());
         this.scale = 0.3F / Math.max(renderedEntity.getWidth(), renderedEntity.getHeight());
      }

      GlStateManager.pushMatrix();
      GlStateManager.translatef((float)x + 0.5F, (float)y + 0.05F, (float)z + 0.5F);
      GlStateManager.scalef(scale, scale, scale);
      MinecraftClient.getInstance().getEntityRenderManager().render(renderedEntity, 0.0D, 0.0D, 0.0D, 0.0F, delta, false);
      GlStateManager.popMatrix();
   }

}
