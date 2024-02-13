package com.wizard_assassin.toggle_sprint;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

public class CustomKeybind {
    public static KeyBinding sprintKey;
    public static KeyBinding sneakKey;
    public static boolean sprintKeyToggled;
    public static boolean sneakKeyToggled;

    public static void init() {
        Minecraft mc = Minecraft.getMinecraft();
        sprintKey = mc.gameSettings.keyBindSprint;
        sneakKey = mc.gameSettings.keyBindSneak;
    }

    @SubscribeEvent
    public static void onKeyInput(InputEvent.KeyInputEvent event) {
        if (CustomConfig.toggleSprint) {
            if (sprintKey.isPressed())
                sprintKeyToggled = !sprintKeyToggled;
        } else {
            if (sprintKey.isPressed())
                sprintKeyToggled = true;
            else
                sprintKeyToggled = false;
        }
        if (CustomConfig.toggleSneak) {
            if (sneakKey.isPressed())
                sneakKeyToggled = !sneakKeyToggled;
        } else {
            if (sneakKey.isPressed())
                sneakKeyToggled = true;
            else
                sneakKeyToggled = false;
        }
    }
}
