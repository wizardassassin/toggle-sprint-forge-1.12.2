package com.wizard_assassin.toggle_sprint;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = ToggleSprint.MOD_ID)
public class CustomConfig {
    public static boolean toggleSprint = true;
    public static boolean toggleSneak = false;
    public static boolean defaultSprint = false;

    @SubscribeEvent
    public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(ToggleSprint.MOD_ID)) {
            ConfigManager.sync(ToggleSprint.MOD_ID, Config.Type.INSTANCE);
            if (!toggleSprint)
                CustomKeybind.sprintKeyToggled = false;
            if (!toggleSneak)
                CustomKeybind.sneakKeyToggled = false;
            if (!defaultSprint)
                CustomKeybind.sprintKeyToggled = false;
            if (defaultSprint)
                CustomKeybind.sprintKeyToggled = true;
        }
    }
}