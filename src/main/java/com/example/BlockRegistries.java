package com.example;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.Blocks;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class BlockRegistries {
	public static final Block LANDON_PUMPKIN = registerBlock("landon_pumpkin_block", new LandonPumpkinBlock(FabricBlockSettings.copyOf(Blocks.CARVED_PUMPKIN).hardness(0)));
	public static final Block LANDON_DOOR = registerBlock("landon_door", new DoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR), BlockSetType.OAK));
	public static final Block LANDON_ICE = registerBlock("landon_ice_block", new LandonIceBlock(FabricBlockSettings.copyOf(Blocks.ICE)));
	public static final Block LANDON_PACKED_ICE = registerBlock("landon_packed_ice_block", new LandonIceBlock(FabricBlockSettings.copyOf(Blocks.PACKED_ICE)));
	public static final Block LANDON_BLUE_ICE = registerBlock("landon_blue_ice_block", new LandonIceBlock(FabricBlockSettings.copyOf(Blocks.BLUE_ICE)));
	public static final Block LANDON_STAIRS = registerBlock("landon_stairs", new StairsBlock(LANDON_PUMPKIN.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_STAIRS).hardness(0)));
	
	private static Block registerBlock(String name, Block block) {
		registerBlockItem(name, block);
		return Registry.register(Registries.BLOCK, new Identifier("moltensmartians", name), block);
	}
	
	private static Item registerBlockItem(String name, Block block) {
		return Registry.register(Registries.ITEM, new Identifier("moltensmartians", name), new BlockItem(block, new FabricItemSettings()));
	}
	
	public static void registerModBlock() {
		ExampleMod.LOGGER.info("Oh boy time to make pumpkin");
	}
	
}
