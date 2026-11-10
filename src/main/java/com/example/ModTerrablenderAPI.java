package com.example;

import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class ModTerrablenderAPI implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
        //Regions.register(new ModOverworldRegion(ExampleMod.id("overworld"), 4));

        //SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, "moltensmartians", ModMaterialRules.makeRules());
    }
}
