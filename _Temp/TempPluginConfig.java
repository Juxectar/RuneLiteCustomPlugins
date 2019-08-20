package net.runelite.client.plugins._Temp;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("TempPlugin")
public interface TempPluginConfig extends Config {
	@ConfigItem(
			keyName = "TempPluginButton",
			name = "TempPluginButton ",
			description = "TempPluginButton",
			position = 1
	)
	default boolean TempButton1() {
		return false;
	}
}
