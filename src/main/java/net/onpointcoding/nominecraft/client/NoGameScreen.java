package net.onpointcoding.nominecraft.client;

import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

public class NoGameScreen extends Screen {
    public NoGameScreen(Text title) {
        super(title);
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        DrawableHelper.fill(matrices, 0, 0, this.width, this.height, 0xff14181c);
        int w = this.textRenderer.getWidth(title);
        int h = this.textRenderer.getWrappedLinesHeight(title.asString(), w);
        this.textRenderer.draw(matrices, title, (this.width - w) / 2f, (this.height - h) / 2f, 0xffffff);

        super.render(matrices, mouseX, mouseY, delta);
    }
}
