package net.runelite.client.plugins._MyPlugin;


import com.google.common.eventbus.Subscribe;
import net.runelite.api.Client;
import net.runelite.api.events.GameTick;
import net.runelite.client.plugins.Plugin;

import javax.inject.Inject;

public class MyPlugin extends Plugin {
	@Inject
	private Client client;
	@Inject
	MyPluginConfig config;

	@Subscribe
	public void onGameTick(GameTick tick){
		System.out.println(client.getTickCount());
	}
}
