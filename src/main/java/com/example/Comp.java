package com.example;

import dev.onyxstudios.cca.api.v3.component.ComponentV3;

public interface Comp extends ComponentV3 {

    int getVitality();
    void setVitality(int value);
    default void transferTo(Comp dest, int amount) {
        int sourceVitality = this.getVitality();
        int actualAmount = Math.min(sourceVitality, amount);
        this.setVitality(sourceVitality - actualAmount);
        dest.setVitality(dest.getVitality() + actualAmount);
    }
}
