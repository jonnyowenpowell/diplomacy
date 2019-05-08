package net.huaum.diplomacy.common.block.entity;

import net.huaum.diplomacy.Diplomacy;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.network.packet.BlockEntityUpdateS2CPacket;
import net.minecraft.nbt.CompoundTag;

public class JarBlockEntity extends BlockEntity {

   public JarBlockEntity() {
      super(Diplomacy.JAR_BLOCK_ENTITY);
   }

   public void fromTag(CompoundTag compoundTag) {
      super.fromTag(compoundTag);
   }

   public CompoundTag toTag(CompoundTag compoundTag) {
      super.toTag(compoundTag);
      return compoundTag;
   }

   public BlockEntityUpdateS2CPacket toUpdatePacket() {
      return new BlockEntityUpdateS2CPacket(this.pos, 1, this.toInitialChunkDataTag());
   }

}
