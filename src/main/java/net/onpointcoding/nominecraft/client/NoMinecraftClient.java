package net.onpointcoding.nominecraft.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

@Environment(EnvType.CLIENT)
public class NoMinecraftClient implements ClientModInitializer {
    @SuppressWarnings("")
    public static Text getGameTitle() {
        return new TranslatableText("no-minecraft.title");
    }

    @Override
    public void onInitializeClient() {
    }
}
