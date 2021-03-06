package net.huaum.diplomacy.common.block;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.huaum.diplomacy.common.block.entity.JarBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderLayer;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.VerticalEntityPosition;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class JarBlock extends BlockWithEntity {

    private static final VoxelShape jar_body_shape;
    private static final VoxelShape jar_neck_shape;
    private static final VoxelShape jar_cork_shape;
    private static final VoxelShape jar_shape;

    public JarBlock() {
        super(FabricBlockSettings.of(Material.GLASS).strength(1f, 1f).sounds(BlockSoundGroup.GLASS).build());
    }

    public BlockEntity createBlockEntity(BlockView blockView) {
        return new JarBlockEntity();
     }

    @Environment(EnvType.CLIENT)
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

    @Environment(EnvType.CLIENT)
    public BlockRenderType getRenderType(BlockState blockState) {
        return BlockRenderType.MODEL;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState blockState, BlockView blockView, BlockPos blockPos, VerticalEntityPosition verticalEntityPosition) {
        return jar_shape;
    }

    static {
        jar_body_shape = Block.createCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 10.0D, 13.0D);
        jar_neck_shape = Block.createCuboidShape(5.5D, 10.0D, 5.5D, 5.5D, 11.5D, 5.5D);
        jar_cork_shape = Block.createCuboidShape(6.0D, 10.0D, 6.0D, 10.0D, 12.0D, 10.0D);
        jar_shape = VoxelShapes.union(jar_body_shape, jar_neck_shape, jar_cork_shape);
    }

}
