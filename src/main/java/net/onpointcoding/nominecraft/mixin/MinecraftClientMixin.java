package net.onpointcoding.nominecraft.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.RunArgs;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.Window;
import net.onpointcoding.nominecraft.client.NoGameScreen;
import net.onpointcoding.nominecraft.client.NoMinecraftClient;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.io.InputStream;

@Mixin(MinecraftClient.class)
public abstract class MinecraftClientMixin {
    @Shadow
    @Final
    private Window window;

    @Shadow
    public abstract void openScreen(@Nullable Screen screen);

    @Inject(method = "<init>", at = @At("TAIL"))
    private void injectedConstructor(RunArgs args, CallbackInfo ci) {
        this.openScreen(new NoGameScreen(NoMinecraftClient.getGameTitle()));
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("assets/no-minecraft/icons/icon_16x16.png");
        InputStream inputStream2 = this.getClass().getClassLoader().getResourceAsStream("assets/no-minecraft/icons/icon_32x32.png");
        this.window.setIcon(inputStream, inputStream2);
    }

    @Inject(method = "getWindowTitle", at = @At("HEAD"), cancellable = true)
    private void injectedWindowTitle(CallbackInfoReturnable<String> cir) {
        cir.setReturnValue("No Minecraft");
        cir.cancel();
    }
}
