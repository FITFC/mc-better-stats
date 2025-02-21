package thecsdev.betterstats.client.gui.panel;

import java.awt.Color;

import net.minecraft.client.util.math.MatrixStack;
import thecsdev.tcdcommons.api.client.gui.panel.TPanelElement;
import thecsdev.tcdcommons.api.client.gui.util.GuiUtils;

public class BSPanel extends TPanelElement
{
	// ==================================================
	public static final int COLOR_OUTLINE = Color.black.getRGB();
	// ==================================================
	public BSPanel(int x, int y, int width, int height) { super(x, y, width, height); }
	// ==================================================
	@Override
	public void postRender(MatrixStack matrices, int mouseX, int mouseY, float deltaTime)
	{
		drawOutline(matrices, GuiUtils.applyAlpha(isFocused() ? COLOR_OUTLINE_FOCUSED : BSPanel.COLOR_OUTLINE, getAlpha()));
	}
	// ==================================================
}