package com.example;

import net.minecraft.block.Block;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public class ModMaterialRules {
	private static final MaterialRules.MaterialRule LANDON_BLOCK = makeStateRule(BlockRegistries.LANDON_PUMPKIN);

    public static MaterialRules.MaterialRule makeRules() {
        MaterialRules.MaterialCondition isAtOrAboveWaterLevel = MaterialRules.water(-1, 0);

        MaterialRules.MaterialRule grassSurface = MaterialRules.sequence(MaterialRules.condition(isAtOrAboveWaterLevel, LANDON_BLOCK), LANDON_BLOCK);

        return MaterialRules.sequence(
                MaterialRules.sequence(MaterialRules.condition(MaterialRules.biome(ModBiomes.LANDON_BIOME),
                                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, LANDON_BLOCK)),
                        MaterialRules.condition(MaterialRules.STONE_DEPTH_CEILING, LANDON_BLOCK)),

                // Default to a grass and dirt surface
                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, grassSurface)
        );
    }

    private static MaterialRules.MaterialRule makeStateRule(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }
}
