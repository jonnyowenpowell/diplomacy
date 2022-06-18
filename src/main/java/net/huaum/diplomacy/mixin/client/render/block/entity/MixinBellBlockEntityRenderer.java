package net.huaum.diplomacy.mixin.client.render.block.entity;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.minecraft.block.entity.BellBlockEntity;
import net.minecraft.client.render.block.entity.BellBlockEntityRenderer;
import net.minecraft.client.render.block.entity.BellModel;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.util.Identifier;

@Mixin(BellBlockEntityRenderer.class)
public abstract class MixinBellBlockEntityRenderer extends BlockEntityRenderer<BellBlockEntity> {

    @Shadow
    private static Identifier BELL_BODY_TEXTURE;
    
    @Shadow
    private BellModel model;

    @Redirect(method = "method_17139(Lnet/minecraft/block/entity/BellBlockEntity;DDDFI)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/block/entity/BellModel;method_17070(FFF)V"))
    public void animateBellExtreme(BellModel bellModel, float pitch, float roll, float scale) {
        bellModel.method_17070(pitch*20, roll*20, 0.0625F);
    }
}
