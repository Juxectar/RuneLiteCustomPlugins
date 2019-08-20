package net.runelite.client.plugins._CorpFlinching;


import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("__testplugin")

public interface _CorpFlinchingConfig extends Config {

	@ConfigItem(
			keyName = "Stomp counter",
			name = "Stomp Counter",
			description = "Keeps track of the 7 tick stomp cycle",
			position = 1
	)
	default boolean stompCounter() {
		return false;
	}

	@ConfigItem(
			keyName = "Flinch Counter",
			name = "Flinch Counter",
			description = "Keeps track of the flinch cycle",
			position = 2
	)
	default boolean flinchCounter() {
		return false;
	}

	@ConfigItem(
			keyName = "Pie ting",
			name = "Pie ting",
			description = "Pie ting",
			position = 3
	)
	default boolean Pietingbutton() {
		return false;
	}

	@ConfigItem(
			keyName = "Stomp pie",
			name = "Stomp pie",
			description = "Stomp pie",
			position = 4
	)
	default boolean Stomppie() {
		return false;
	}


	@ConfigItem(
			keyName = "Stomp pie X",
			name = "Stomp pie X",
			description = "Stomp pie X",
			position = 5
	)
	default int StomppieX() {
		return 0;
	}

	@ConfigItem(
			keyName = "Stomp pie Y",
			name = "Stomp pie Y",
			description = "Stomp pie Y",
			position = 6
	)
	default int StomppieY() {
		return 650;
	}

	@ConfigItem(
			keyName = "pie Ting X",
			name = "pie Ting X",
			description = "pie Ting X",
			position = 7
	)
	default int pieTingX() {
		return 0;
	}

	@ConfigItem(
			keyName = "pie Ting Y",
			name = "pie Ting Y",
			description = "pie Ting Y",
			position = 8
	)
	default int pieTingY() {
		return 0;
	}


}
