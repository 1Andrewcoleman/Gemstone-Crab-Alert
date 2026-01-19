package com.gemstonecrab;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.events.GameTick;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@Slf4j
@PluginDescriptor(
	name = "Gemstone Crab Alert",
	description = "Flashes the screen when Gemstone Crab health is at or below threshold",
	tags = {"crab", "gemstone", "alert", "flash", "pvm"}
)
public class GemstoneCrabPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private GemstoneCrabOverlay overlay;

	@Inject
	private GemstoneCrabConfig config;

	@Getter
	private boolean shouldFlash = false;
	
	@Getter
	private long flashStartTime = 0;
	
	private boolean isFlashing = false;

	@Override
	protected void startUp() throws Exception
	{
		log.info("Gemstone Crab Alert started!");
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		log.info("Gemstone Crab Alert stopped!");
		overlayManager.remove(overlay);
		shouldFlash = false;
		isFlashing = false;
		flashStartTime = 0;
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		shouldFlash = false;
		boolean foundCrabBelowThreshold = false;

		for (NPC npc : client.getNpcs())
		{
			if (npc == null || npc.getName() == null)
			{
				continue;
			}

			if (npc.getName().equals("Gemstone Crab"))
			{
				int healthRatio = npc.getHealthRatio();
				int healthScale = npc.getHealthScale();

				if (healthScale > 0)
				{
					double healthPercent = (double) healthRatio / healthScale * 100.0;
					log.debug("Gemstone Crab health: {}%", String.format("%.2f", healthPercent));
					
					int threshold = config.healthThreshold();
					if (healthPercent <= threshold && healthPercent > 0)
					{
						foundCrabBelowThreshold = true;
						
						if (!isFlashing)
						{
							isFlashing = true;
							flashStartTime = System.currentTimeMillis();
							int duration = config.flashDuration();
							log.info("ALERT: Gemstone Crab health at or below {}%! Starting {}-second flash.", threshold, duration);
						}
						
						long flashDurationMs = config.flashDuration() * 1000L;
						long elapsedTime = System.currentTimeMillis() - flashStartTime;
						if (elapsedTime < flashDurationMs)
						{
							shouldFlash = true;
						}
						else
						{
							log.debug("Flash duration completed ({} seconds).", config.flashDuration());
						}
						
						break;
					}
				}
			}
		}
		
		if (!foundCrabBelowThreshold)
		{
			if (isFlashing)
			{
				log.debug("Crab health recovered above {}%. Resetting flash state.", config.healthThreshold());
			}
			isFlashing = false;
			flashStartTime = 0;
		}
	}

	@Provides
	GemstoneCrabConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(GemstoneCrabConfig.class);
	}
}
