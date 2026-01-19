package com.gemstonecrab;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

public class GemstoneCrabOverlay extends Overlay
{
	private final GemstoneCrabPlugin plugin;
	private final GemstoneCrabConfig config;

	@Inject
	private GemstoneCrabOverlay(GemstoneCrabPlugin plugin, GemstoneCrabConfig config)
	{
		this.plugin = plugin;
		this.config = config;
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (plugin.isShouldFlash())
		{
			long elapsedTime = System.currentTimeMillis() - plugin.getFlashStartTime();
			int flashInterval = config.flashInterval();
			int cyclePosition = (int) (elapsedTime % (flashInterval * 2));
			boolean flashOn = cyclePosition < flashInterval;
			
			if (flashOn)
			{
				Color flashColor = config.flashColor();
				graphics.setColor(flashColor);
				graphics.fillRect(0, 0, graphics.getClipBounds().width, graphics.getClipBounds().height);
			}
		}

		return null;
	}
}
