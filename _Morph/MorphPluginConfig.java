package net.runelite.client.plugins._Morph;


import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("MorphConfig")
public interface MorphPluginConfig extends Config {
	@ConfigItem(
			keyName = "Morph me",
			name = "Morphs Me",
			description = "Morphs LocalPlayer",
			position = 1
	)
	default boolean morphMe() {
		return false;
	}

	@ConfigItem(
			keyName = "Morph Others",
			name = "Morph Others",
			description = "Morphs all other Players",
			position = 2
	)
	default boolean morphOthers() {
		return false;
	}

	@ConfigItem(
			keyName = "Morph LocalPlayerId",
			name = "Morph Me Id",
			description = "Morph LocalPlayerId",
			position = 3
	)
	default int morphMeId() {
		return 0;
	}

	@ConfigItem(
			keyName = "Morph PlayersId",
			name = "Morph Others Id",
			description = "Morph PlayersId",
			position = 4
	)
	default int morphOthersId() {
		return 0;
	}
@ConfigItem(
			keyName = "Randomize",
			name = ">0 to randomize",
			description = "Randomizes",
			position = 5
	)
	default int randomizer() {
		return 0;
	}


}
