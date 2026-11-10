package com.example;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.server.command.CommandManager;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.entities.LandonThrowEntity;
import com.mojang.brigadier.arguments.IntegerArgumentType;
public class ExampleMod implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("moltensmartians");
    public static final Identifier LANDON_SOUND_ID = new Identifier("moltensmartians:landon");
    public static SoundEvent LANDON_SOUND_EVENT = SoundEvent.of(LANDON_SOUND_ID);
    public static final Identifier EVIL_LANDON_SOUND_ID = new Identifier("moltensmartians:evil_landon");
    public static SoundEvent EVIL_LANDON_SOUND_EVENT = SoundEvent.of(EVIL_LANDON_SOUND_ID);
    public static final Identifier BLUE_LANDON_SOUND_ID = new Identifier("moltensmartians:blue_landon");
    public static SoundEvent BLUE_LANDON_SOUND_EVENT = SoundEvent.of(BLUE_LANDON_SOUND_ID);
    public static final Identifier YELLOW_LANDON_SOUND_ID = new Identifier("moltensmartians:yellow_landon");
    public static SoundEvent YELLOW_LANDON_SOUND_EVENT = SoundEvent.of(YELLOW_LANDON_SOUND_ID);
    public static final Identifier LIGHT_BLUE_LANDON_SOUND_ID = new Identifier("moltensmartians:light_blue_landon");
    public static SoundEvent LIGHT_BLUE_LANDON_SOUND_EVENT = SoundEvent.of(LIGHT_BLUE_LANDON_SOUND_ID);
    public static final Identifier RADIATION_LANDON_SOUND_ID = new Identifier("moltensmartians:radiation_landon");
    public static SoundEvent RADIATION_LANDON_SOUND_EVENT = SoundEvent.of(RADIATION_LANDON_SOUND_ID);
    public static final Identifier GRAY_LANDON_SOUND_ID = new Identifier("moltensmartians:gray_landon");
    public static SoundEvent GRAY_LANDON_SOUND_EVENT = SoundEvent.of(GRAY_LANDON_SOUND_ID);
    public static final Identifier PURPLE_LANDON_SOUND_ID = new Identifier("moltensmartians:purple_landon");
    public static SoundEvent PURPLE_LANDON_SOUND_EVENT = SoundEvent.of(PURPLE_LANDON_SOUND_ID);
    public static final Identifier STARWALKER_LANDON_SOUND_ID = new Identifier("moltensmartians:starwalker_landon");
    public static SoundEvent STARWALKER_LANDON_SOUND_EVENT = SoundEvent.of(STARWALKER_LANDON_SOUND_ID);
    public static final Identifier PHOTOSHOP_LANDON_SOUND_ID = new Identifier("moltensmartians:photoshop_landon");
    public static SoundEvent PHOTOSHOP_LANDON_SOUND_EVENT = SoundEvent.of(PHOTOSHOP_LANDON_SOUND_ID);
    public static final Identifier PHOTONEGATIVE_LANDON_SOUND_ID = new Identifier("moltensmartians:photonegative_landon");
    public static SoundEvent PHOTONEGATIVE_LANDON_SOUND_EVENT = SoundEvent.of(PHOTONEGATIVE_LANDON_SOUND_ID);
    
    public static Identifier id(String name) {
    	return Identifier.of("moltensmartians", name);
    }
    public static final EntityType<LandonThrowEntity> LandonEntityType = Registry.register(
			Registries.ENTITY_TYPE,
			id("landon_projectile"),
			FabricEntityTypeBuilder.<LandonThrowEntity>create(SpawnGroup.MISC, LandonThrowEntity::new)
					.dimensions(EntityDimensions.fixed(0.25F, 0.25F))
					.trackRangeBlocks(4).trackedUpdateRate(10)
					.build()
	);
    @Override
    public void onInitialize() {
    	Registry.register(Registries.SOUND_EVENT, LANDON_SOUND_ID, LANDON_SOUND_EVENT);
    	Registry.register(Registries.SOUND_EVENT, EVIL_LANDON_SOUND_ID, EVIL_LANDON_SOUND_EVENT);
    	Registry.register(Registries.SOUND_EVENT, BLUE_LANDON_SOUND_ID, BLUE_LANDON_SOUND_EVENT);
    	Registry.register(Registries.SOUND_EVENT, YELLOW_LANDON_SOUND_ID, YELLOW_LANDON_SOUND_EVENT);
    	Registry.register(Registries.SOUND_EVENT, LIGHT_BLUE_LANDON_SOUND_ID, LIGHT_BLUE_LANDON_SOUND_EVENT);
    	Registry.register(Registries.SOUND_EVENT, RADIATION_LANDON_SOUND_ID, RADIATION_LANDON_SOUND_EVENT);
    	Registry.register(Registries.SOUND_EVENT, GRAY_LANDON_SOUND_ID, GRAY_LANDON_SOUND_EVENT);
    	Registry.register(Registries.SOUND_EVENT, PURPLE_LANDON_SOUND_ID, PURPLE_LANDON_SOUND_EVENT);
    	Registry.register(Registries.SOUND_EVENT, STARWALKER_LANDON_SOUND_ID, STARWALKER_LANDON_SOUND_EVENT);
    	Registry.register(Registries.SOUND_EVENT, PHOTOSHOP_LANDON_SOUND_ID, PHOTOSHOP_LANDON_SOUND_EVENT);
    	Registry.register(Registries.SOUND_EVENT, PHOTONEGATIVE_LANDON_SOUND_ID, PHOTONEGATIVE_LANDON_SOUND_EVENT);
    	ItemGroups.registerItemGroups();
    	
    	AllItems.registerModItems();;
    	BlockRegistries.registerModBlock();
    	ModServerParticles.register();
    	
    	ServerLivingEntityEvents.AFTER_DEATH.register((entity, source) -> {
            if (entity instanceof PlayerEntity) {
                if(entity.getUuidAsString().equals("5692f14e-e4aa-4bb4-a2d1-e582811707b9")) {
                	entity.getWorld().spawnEntity(new ItemEntity(entity.getWorld(), entity.getX(), entity.getY(), entity.getZ(), new ItemStack(BlockRegistries.LANDON_PUMPKIN, 64)));
                }
            }
        });
    	
    	CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
    		dispatcher.register(CommandManager.literal("renderkyra").then(CommandManager.argument("value", IntegerArgumentType.integer()).executes(context -> {
    			int value = IntegerArgumentType.getInteger(context, "value");
    			
    			if(context.getSource().getPlayer().getUuidAsString().equals("a825e802-c625-411c-81aa-c090843f588e") || context.getSource().getPlayer().getUuidAsString().equals("887e835c-179e-4c0b-9777-dc4aa64128a6")) {
    				MyComponents.RENDER_KYRA.get((LivingEntity) context.getSource().getPlayer()).setVitality(value);
        			context.getSource().sendFeedback(() -> Text.literal("Set rendering to " + value), false);
    			} else {
    				context.getSource().sendFeedback(() -> Text.literal("You ain't got NO perms" + context.getSource().getPlayer().getUuidAsString()), false);
    			}
    			
    			
    			return 1;
    		})));
    		dispatcher.register(CommandManager.literal("renderlandon").then(CommandManager.argument("value", IntegerArgumentType.integer()).executes(context -> {
    			int value = IntegerArgumentType.getInteger(context, "value");
    			
    			if(context.getSource().getPlayer().getUuidAsString().equals("5692f14e-e4aa-4bb4-a2d1-e582811707b9")) {
    				MyComponents.RENDER_LANDON.get((LivingEntity) context.getSource().getPlayer()).setVitality(value);
        			context.getSource().sendFeedback(() -> Text.literal("Set rendering to " + value), false);
    			} else {
    				context.getSource().sendFeedback(() -> Text.literal("You ain't got NO perms"), false);
    			}
    			
    			
    			return 1;
    		})));
    		dispatcher.register(CommandManager.literal("rendershade").then(CommandManager.argument("value", IntegerArgumentType.integer()).executes(context -> {
    			int value = IntegerArgumentType.getInteger(context, "value");
    			
    			if(context.getSource().getPlayer().getUuidAsString().equals("67535684-38c1-4733-9b22-78a50e7e86a1")) {
    				MyComponents.RENDER_SHADE.get((LivingEntity) context.getSource().getPlayer()).setVitality(value);
        			context.getSource().sendFeedback(() -> Text.literal("Set rendering to " + value), false);
    			} else {
    				context.getSource().sendFeedback(() -> Text.literal("You ain't got NO perms"), false);
    			}
    			
    			
    			return 1;
    		})));
    		dispatcher.register(CommandManager.literal("renderace").then(CommandManager.argument("value", IntegerArgumentType.integer()).executes(context -> {
    			int value = IntegerArgumentType.getInteger(context, "value");
    			
    			if(context.getSource().getPlayer().getUuidAsString().equals("887e835c-179e-4c0b-9777-dc4aa64128a6")) {
    				MyComponents.RENDER_ACE.get((LivingEntity) context.getSource().getPlayer()).setVitality(value);
        			context.getSource().sendFeedback(() -> Text.literal("Set rendering to " + value), false);
    			} else {
    				context.getSource().sendFeedback(() -> Text.literal("You ain't got NO perms"), false);
    			}
    			
    			
    			return 1;
    		})));
    	});
    	
    	//CustomPortalBuilder.beginPortal().frameBlock(BlockRegistries.LANDON_PUMPKIN).lightWithItem(AllItems.LAND_N_STEEL_REGISTER).destDimID(new Identifier("moltensmartians:landondim")).tintColor(255, 118, 255).registerPortal();
    }
    
    
}

