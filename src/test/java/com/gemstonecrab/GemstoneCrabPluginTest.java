package com.gemstonecrab;

import net.runelite.client.RuneLite;

public class GemstoneCrabPluginTest
{
	public static void main(String[] args) throws Exception
	{
		// Plugin is loaded from sideloaded-plugins folder, no need to load it here
		// This prevents duplicate plugin entries
		RuneLite.main(args);
	}
}
