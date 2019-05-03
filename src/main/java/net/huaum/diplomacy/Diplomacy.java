package net.huaum.diplomacy;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import net.huaum.diplomacy.common.block.JarBlock;

public class Diplomacy implements ModInitializer {

	public static final Block JAR_BLOCK = new JarBlock();

	@Override
	public void onInitialize() {
		System.out.println("Hello diplomats!");
		Registry.register(Registry.BLOCK, new Identifier("diplomacy", "jar"), JAR_BLOCK);
		Registry.register(Registry.ITEM, new Identifier("diplomacy", "jar"), new BlockItem(JAR_BLOCK, new Item.Settings().itemGroup(ItemGroup.MISC)));
	}

}
