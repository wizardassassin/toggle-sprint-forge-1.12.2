package com.wizard_assassin.toggle_sprint;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ToggleSprint.MOD_ID)
public class ToggleSprint {
    public static final String MOD_ID = "toggle-sprint";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent event) {
        CustomKeybind.init();
        MinecraftForge.EVENT_BUS.register(CustomConfig.class);
        MinecraftForge.EVENT_BUS.register(CustomKeybind.class);
        if (CustomConfig.defaultSprint)
            CustomKeybind.sprintKeyToggled = true;
    }

    @Mod.EventHandler
    public void onInit(FMLInitializationEvent event) {

    }
}
