package net.huaum.diplomacy.mixin;

import net.minecraft.block.entity.BellBlockEntity;
import net.minecraft.client.render.block.entity.BellBlockEntityRenderer;
import net.minecraft.client.render.block.entity.BellModel;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.util.Identifier;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(BellBlockEntityRenderer.class)
public abstract class MixinBellBlockEntityRenderer extends BlockEntityRenderer<BellBlockEntity> {

    @Shadow
    private static Identifier BELL_BODY_TEXTURE;

    @Shadow
    private BellModel model;

    @Redirect(method = "method_17139(Lnet/minecraft/block/entity/BellBlockEntity;DDDFI)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/block/entity/BellModel;method_17070(FFF)V"))
	public void animateBellExtreme(BellModel bellModel, float float_1, float float_2, float float_3) {
        bellModel.method_17070(float_1*150, float_2*150, 0.0625F);
     }
	
}
