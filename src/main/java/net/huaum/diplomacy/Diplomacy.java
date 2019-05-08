package net.huaum.diplomacy;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.render.BlockEntityRendererRegistry;
import net.huaum.diplomacy.client.render.block.entity.JarBlockEntityRenderer;
import net.huaum.diplomacy.common.block.JarBlock;
import net.huaum.diplomacy.common.block.entity.JarBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Diplomacy implements ModInitializer {

	public static final Block JAR_BLOCK = new JarBlock();
	public static final BlockEntityType<JarBlockEntity> JAR_BLOCK_ENTITY = BlockEntityType.Builder.create(JarBlockEntity::new).build(null);

	@Override
	public void onInitialize() {
		System.out.println("Hello diplomats!");
		Registry.register(Registry.BLOCK, new Identifier("diplomacy", "jar"), JAR_BLOCK);
		Registry.register(Registry.ITEM, new Identifier("diplomacy", "jar"), new BlockItem(JAR_BLOCK, new Item.Settings().itemGroup(ItemGroup.MISC)));
		BlockEntityRendererRegistry.INSTANCE.register(JarBlockEntity.class, new JarBlockEntityRenderer());
		Registry.register(Registry.BLOCK_ENTITY, new Identifier("diplomacy", "jar"), JAR_BLOCK_ENTITY);
	}

}
