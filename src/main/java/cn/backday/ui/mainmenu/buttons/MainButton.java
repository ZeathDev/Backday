package cn.backday.ui.mainmenu.buttons;

import cn.backday.ui.mainmenu.font.FontUtil;
import cn.backday.ui.mainmenu.utils.ClientGuiUtils;
import net.minecraft.client.renderer.GlStateManager;

import java.awt.*;

public class MainButton {
    protected String text;
    protected int x, y;
    protected int width, height;

    protected int hoverFade = 0;

    public Runnable clickAction;

    public MainButton(String text, int x, int y) {
        this.text = text;
        this.x = x;
        this.y = y;

        this.width = 132;
        this.height = 11;
    }

    public void drawButton(int mouseX, int mouseY) {
        boolean hovered = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
        if (hovered) {
            if (hoverFade < 40) hoverFade += 10;
        } else {
            if (hoverFade > 0) hoverFade -= 10;
        }

        GlStateManager.color(1.0F, 1.0F, 1.0F);
        ClientGuiUtils.drawRoundedRect(this.x - 1, this.y - 1, this.width + 2, this.height + 2, 2, new Color(30, 30, 30, 60));
        ClientGuiUtils.drawRoundedRect(this.x, this.y, this.width, this.height, 2, new Color(255, 255, 255, 38 + hoverFade));

        ClientGuiUtils.drawRoundedOutline(this.x, this.y, this.x + this.width, this.y + this.height, 2, 3, new Color(255, 255, 255, 30).getRGB());

        FontUtil.TEXT_BOLD.getFont().drawCenteredString(this.text, this.x + (float) this.width / 2 + 0.5F, this.y + (float) (this.height - 4) / 2 + 0.5F, new Color(30, 30, 30, 50).getRGB());
        FontUtil.TEXT_BOLD.getFont().drawCenteredString(this.text, this.x + (float) this.width / 2, this.y + (float) (this.height - 4) / 2, new Color(190, 195, 189).getRGB());
    }
}
