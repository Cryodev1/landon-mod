package com.example.entities;

import com.example.AllDamageTypes;
import com.example.AllItems;
import com.example.ExampleMod;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

public class LandonThrowEntity extends ThrownItemEntity {
	public LandonThrowEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public LandonThrowEntity(LivingEntity livingEntity, World world) {
        super(ExampleMod.LandonEntityType, livingEntity, world);
    }

    @Override
    protected Item getDefaultItem() {
        return AllItems.THROWABLE_LANDON_REGISTER;
    }

    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }
    
    protected void onEntityHit(EntityHitResult result) {
    	result.getEntity().playSound(ExampleMod.LANDON_SOUND_EVENT, 1.0F, 1.0F);
    	if(result.getEntity().getUuid().toString().equals("afcd831a-70a9-405c-8b5b-d42bdcd6b63f")) {
    		result.getEntity().damage(AllDamageTypes.of(result.getEntity().getWorld(), AllDamageTypes.LANDON_KILL_DAMAGE_TYPE), 8.0f);
    	} else {
    		result.getEntity().damage(AllDamageTypes.of(result.getEntity().getWorld(), AllDamageTypes.LANDON_DAMAGE_TYPE), 1.0f);
    	}
    }
    
    protected void onBlockHit(BlockHitResult result) {
    	if(!this.getWorld().isClient()) {
    		this.getWorld().playSound(null, result.getBlockPos().getX(), result.getBlockPos().getY(), result.getBlockPos().getZ(), ExampleMod.LANDON_SOUND_EVENT, SoundCategory.NEUTRAL, 1.0F, 1.0F);
    	}
    	
    	this.discard();
    	super.onBlockHit(result);
    }
}
