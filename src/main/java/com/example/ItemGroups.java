package com.example;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ItemGroups {
	public static final ItemGroup LANDON_GROUP = Registry.register(Registries.ITEM_GROUP, Identifier.of("moltensmartians", "landon"), FabricItemGroup.builder().displayName(Text.translatable("itemgroup.landon")).icon(() -> new ItemStack(AllItems.LANDON_PUMPKIN_REGISTER)).entries((displayContext, entries) -> {
		entries.add(BlockRegistries.LANDON_PUMPKIN);
		entries.add(BlockRegistries.LANDON_ICE);
		entries.add(BlockRegistries.LANDON_PACKED_ICE);
		entries.add(BlockRegistries.LANDON_BLUE_ICE);
		entries.add(BlockRegistries.LANDON_DOOR);
		entries.add(BlockRegistries.LANDON_STAIRS);
		entries.add(AllItems.LANDON_PUMPKIN_REGISTER);
		entries.add(AllItems.EVIL_LANDON_REGISTER);
		entries.add(AllItems.BLUE_LANDON_REGISTER);
		entries.add(AllItems.YELLOW_LANDON_REGISTER);
		entries.add(AllItems.LIGHT_BLUE_LANDON_REGISTER);
		entries.add(AllItems.RADIATION_LANDON_REGISTER);
		entries.add(AllItems.THROWABLE_LANDON_REGISTER);
		entries.add(AllItems.GRAY_LANDON_REGISTER);
		entries.add(AllItems.PURPLE_LANDON_REGISTER);
		entries.add(AllItems.CONSUMABLE_LANDON_REGISTER);
		entries.add(AllItems.STARWALKER_LANDON_REGISTER);
		entries.add(AllItems.PHOTOSHOP_LANDON_REGISTER);
		entries.add(AllItems.PHOTONEGATIVE_LANDON_REGISTER);
		entries.add(AllItems.LAND_N_STEEL_REGISTER);
	}).build());
	
	public static void registerItemGroups() {
		ExampleMod.LOGGER.info("blahhhh");
	}
}
