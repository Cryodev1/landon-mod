package com.example;

import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentInitializer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;

public final class MyComponents implements EntityComponentInitializer {
	public static final ComponentKey<SyncedKyraComponent> RENDER_KYRA = ComponentRegistry.getOrCreate(new Identifier("moltensmartians", "render_kyra"), SyncedKyraComponent.class);
	public static final ComponentKey<SyncedLandonComponent> RENDER_LANDON = ComponentRegistry.getOrCreate(new Identifier("moltensmartians", "render_landon"), SyncedLandonComponent.class);
	public static final ComponentKey<SyncedShadeComponent> RENDER_SHADE = ComponentRegistry.getOrCreate(new Identifier("moltensmartians", "render_shade"), SyncedShadeComponent.class);
	public static final ComponentKey<SyncedAceComponent> RENDER_ACE = ComponentRegistry.getOrCreate(new Identifier("moltensmartians", "render_ace"), SyncedAceComponent.class);
	
	public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
		registry.registerFor(LivingEntity.class, RENDER_KYRA, SyncedKyraComponent::new);
		registry.registerFor(LivingEntity.class, RENDER_LANDON, SyncedLandonComponent::new);
		registry.registerFor(LivingEntity.class, RENDER_SHADE, SyncedShadeComponent::new);
		registry.registerFor(LivingEntity.class, RENDER_ACE, SyncedAceComponent::new);
    }
}