package com.example;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class LightBlueLandonItem extends Item {
	public LightBlueLandonItem(Settings settings) {
		super(settings);
	}
	
	@Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.playSound(ExampleMod.LIGHT_BLUE_LANDON_SOUND_EVENT, 1.0F, 1.0F);
        return TypedActionResult.success(new ItemStack(this, user.getMainHandStack().getCount()));
    }
}
