package com.wizard_assassin.toggle_sprint.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.wizard_assassin.toggle_sprint.CustomKeybind;
import com.wizard_assassin.toggle_sprint.ToggleSprint;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;

@Mixin(KeyBinding.class)
public class KeyBindingMixin {

    @Inject(method = "isKeyDown", at = @At("TAIL"), cancellable = true)
    public void isKeyDown(CallbackInfoReturnable<Boolean> info) {
        KeyBinding theClass = (KeyBinding) (Object) this;
        KeyBinding theBinding = Minecraft.getMinecraft().gameSettings.keyBindSprint;
        KeyBinding theBinding2 = Minecraft.getMinecraft().gameSettings.keyBindSneak;
        if (CustomKeybind.sprintKeyToggled && theClass == theBinding) {
            // ToggleSprint.LOGGER.info(info.getReturnValue());
            info.setReturnValue(true);
        }
        if (CustomKeybind.sneakKeyToggled && theClass == theBinding2) {
            // ToggleSprint.LOGGER.info(info.getReturnValue());
            info.setReturnValue(true);
        }
    }
}
