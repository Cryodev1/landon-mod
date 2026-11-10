package com.example;

import dev.onyxstudios.cca.api.v3.component.Component;
import dev.onyxstudios.cca.api.v3.component.CopyableComponent;
import net.minecraft.nbt.NbtCompound;

public class BaseComp implements Comp, Component, CopyableComponent<BaseComp> {
	protected int vitality;

    public BaseComp() {
        this(0);
    }

    public BaseComp(int vitality) {
        this.vitality = vitality;
    }

    @Override
    public int getVitality() {
        return this.vitality;
    }

    @Override
    public void setVitality(int value) {
        this.vitality = value;
    }

    @Override
    public void readFromNbt(NbtCompound tag) {
        this.vitality = tag.getInt("vitality");
    }

    @Override
    public void writeToNbt(NbtCompound tag) {
        tag.putInt("vitality", this.vitality);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comp)) return false;
        return this.vitality == ((Comp) o).getVitality();
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(this.vitality);
    }

    @Override
    public void copyFrom(BaseComp other) {
        this.vitality = other.getVitality();
    }
}
