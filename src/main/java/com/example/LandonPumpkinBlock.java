package com.example;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LandonPumpkinBlock extends Block {
	public LandonPumpkinBlock(Settings settings) {
		super(settings);
	}
	
	public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
		if(entity.getUuid().toString().equals("afcd831a-70a9-405c-8b5b-d42bdcd6b63f") && !world.isClient()) {
			if(entity.isLiving()) {
				LivingEntity entity2 = (LivingEntity) entity;
				entity2.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 1, 1));
			}
		}
	}
	
	
}
