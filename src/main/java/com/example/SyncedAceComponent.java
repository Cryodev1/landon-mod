package com.example;

import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import net.minecraft.entity.LivingEntity;

public class SyncedAceComponent extends BaseComp implements AutoSyncedComponent{
	private final LivingEntity owner;

    public SyncedAceComponent(LivingEntity owner) {
        this.owner = owner;
    }

    @Override
    public void setVitality(int r) {
        super.setVitality(r);
        MyComponents.RENDER_ACE.sync(this.owner);
    }
}
