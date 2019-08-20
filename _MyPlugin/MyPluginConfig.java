package net.runelite.client.plugins._MyPlugin;


import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
@ConfigGroup("Myplugin")
public interface MyPluginConfig extends Config{
	@ConfigItem(
			keyName = "myPlugin",
			name = "myPlugin",
			description = "myPlugin",
			position = 0
	)
	default boolean myPluginButton()
	{
		return false;
	}

}
