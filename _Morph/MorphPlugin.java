package net.runelite.client.plugins._Morph;


import com.google.inject.Inject;
import com.google.inject.Provides;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import net.runelite.api.Player;
import net.runelite.api.events.GameTick;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(name = "_MorphPlugin")
public class MorphPlugin extends Plugin {

	@Inject
	Client client;
	@Inject
	OverlayManager overlayManager;
	@Inject
	MorphPluginOverlay morphPluginOverlay;


	@Provides
	MorphPluginConfig getConfig(ConfigManager configManager) {
		return configManager.getConfig(MorphPluginConfig.class);
	}

	@Override
	protected void startUp() throws Exception {
		overlayManager.add(morphPluginOverlay);
	}

	@Override
	protected void shutDown() throws Exception {
		for (Player p : client.getPlayers()){
			p.getPlayerComposition().setTransformedNpcId(-1);
		}
		overlayManager.remove(morphPluginOverlay);
	}

	@Subscribe
	public void onGameTick(GameTick tick) {

	}
}
