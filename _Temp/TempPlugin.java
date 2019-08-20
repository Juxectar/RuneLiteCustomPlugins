package net.runelite.client.plugins._Temp;

import com.google.inject.Inject;
import com.google.inject.Provides;
import net.runelite.api.Client;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins._Morph.MorphPluginOverlay;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(name = "_TempPlugin")
public class TempPlugin extends Plugin{
	@Inject
	Client client;
	@Inject
	OverlayManager overlayManager;
	@Inject
	TempPluginOverlay tempPluginOverlay;
	@Provides TempPluginConfig getConfig (ConfigManager configManager){ return configManager.getConfig(TempPluginConfig.class);}

	@Override
	protected void startUp() throws Exception {
		System.out.println("Start");
		overlayManager.add(tempPluginOverlay);
	}

	@Override
	protected void shutDown() throws Exception {
		System.out.println("End");
		overlayManager.remove(tempPluginOverlay);
	}
}

