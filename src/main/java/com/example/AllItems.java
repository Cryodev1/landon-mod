package com.example;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class AllItems {
	public static final Item LANDON_PUMPKIN_REGISTER = register(new LandonPumpkinItem(new FabricItemSettings()), "landon_pumpkin");
	public static final Item EVIL_LANDON_REGISTER = register(new EvilLandonItem(new FabricItemSettings()), "evil_landon");
	public static final Item BLUE_LANDON_REGISTER = register(new BlueLandonItem(new FabricItemSettings()), "blue_landon");
	public static final Item YELLOW_LANDON_REGISTER = register(new YellowLandonItem(new FabricItemSettings()), "yellow_landon");
	public static final Item LIGHT_BLUE_LANDON_REGISTER = register(new LightBlueLandonItem(new FabricItemSettings()), "light_blue_landon");
	public static final Item RADIATION_LANDON_REGISTER = register(new RadiationLandonItem(new FabricItemSettings()), "radiation_landon");
	public static final Item THROWABLE_LANDON_REGISTER = register(new ThrowableLandon(new FabricItemSettings()), "throwable_landon");
	public static final Item GRAY_LANDON_REGISTER = register(new GrayLandonItem(new FabricItemSettings()), "gray_landon");
	public static final Item PURPLE_LANDON_REGISTER = register(new PurpleLandonItem(new FabricItemSettings()), "purple_landon");
	public static final Item CONSUMABLE_LANDON_REGISTER = register(new Item(new FabricItemSettings().food(LandonFoodComponents.LANDON)), "consumable_landon");
	public static final Item STARWALKER_LANDON_REGISTER = register(new StarwalkerLandonItem(new FabricItemSettings()), "starwalker_landon");
	public static final Item PHOTOSHOP_LANDON_REGISTER = register(new PhotoshopLandonItem(new FabricItemSettings()), "photoshop_landon");
	public static final Item PHOTONEGATIVE_LANDON_REGISTER = register(new PhotonegativeLandonItem(new FabricItemSettings()), "photonegative_landon");
	public static final Item LAND_N_STEEL_REGISTER = register(new Item(new FabricItemSettings()), "land_n_steel");
	
	public static Item register(Item item, String id) {
		return Registry.register(Registries.ITEM, Identifier.of("moltensmartians", id), item);
	}
	
	
	public static void registerModItems() {
		ExampleMod.LOGGER.info("making da items :D");
	}
	
	
	
	
}
