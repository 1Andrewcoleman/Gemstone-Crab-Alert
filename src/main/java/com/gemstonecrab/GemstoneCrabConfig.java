package com.gemstonecrab;

import java.awt.Color;
import net.runelite.client.config.Alpha;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Range;

@ConfigGroup("gemstonecrabalert")
public interface GemstoneCrabConfig extends Config
{
	@Alpha
	@ConfigItem(
		keyName = "flashColor",
		name = "Flash Color",
		description = "Color of the screen flash",
		position = 1
	)
	default Color flashColor()
	{
		return new Color(255, 0, 0, 100);
	}

	@Range(min = 1, max = 99)
	@ConfigItem(
		keyName = "healthThreshold",
		name = "Health Threshold %",
		description = "Alert triggers when health is at or below this percentage",
		position = 2
	)
	default int healthThreshold()
	{
		return 5;
	}

	@Range(min = 1, max = 30)
	@ConfigItem(
		keyName = "flashDuration",
		name = "Flash Duration (seconds)",
		description = "Total duration of the flash alert",
		position = 3
	)
	default int flashDuration()
	{
		return 5;
	}

	@Range(min = 100, max = 1000)
	@ConfigItem(
		keyName = "flashInterval",
		name = "Flash Interval (ms)",
		description = "On/off cycle speed in milliseconds (lower = faster)",
		position = 4
	)
	default int flashInterval()
	{
		return 250;
	}
}
