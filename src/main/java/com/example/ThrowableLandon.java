package com.example;

import com.example.entities.LandonThrowEntity;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ThrowableLandon extends Item {
	public ThrowableLandon(Settings settings) {
		super(settings);
	}
	
	@Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        
        if(!world.isClient()) {
        	LandonThrowEntity landonEntity = new LandonThrowEntity(user, world);
        	landonEntity.setItem(itemStack);
        	landonEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0f, 1.5f, 1.0f);
        	world.spawnEntity(landonEntity);
        }
        
        user.increaseStat(Stats.USED.getOrCreateStat(this), 1);
        if (!user.getAbilities().creativeMode) {
        	itemStack.decrement(1);
        }
        
        
        return TypedActionResult.success(new ItemStack(this, user.getMainHandStack().getCount()));
    }
}
