package com.wizard_assassin.toggle_sprint;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ToggleSprint.MOD_ID)
public class ToggleSprint {
    public static final String MOD_ID = "toggle-sprint";

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent event) {
        System.out.println("Hello world!");
    }
}
