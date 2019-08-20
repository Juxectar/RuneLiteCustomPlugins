package net.runelite.client.plugins._Morph;

import net.runelite.api.*;
import net.runelite.client.ui.overlay.Overlay;

import javax.inject.Inject;
import java.awt.*;
import java.util.Random;


public class MorphPluginOverlay extends Overlay {
	@Inject
	MorphPluginConfig config;
	@Inject
	private Client client;

	@Override
	public Dimension render(Graphics2D graphics) {
		if (config.morphMe()) {
			client.getLocalPlayer().getPlayerComposition().setTransformedNpcId(config.morphMeId());
		}
		if (!config.morphMe()) {
			client.getLocalPlayer().getPlayerComposition().setTransformedNpcId(-1);
		}
		if (config.morphOthers()) {
			for (Player p : client.getPlayers()) {
				if (p == client.getLocalPlayer()) {
				} else
					p.getPlayerComposition().setTransformedNpcId(config.morphOthersId());
			}
		}
		if (!config.morphOthers()) {
			for (Player p : client.getPlayers()) {
				if (p == client.getLocalPlayer()) {
				} else
				p.getPlayerComposition().setTransformedNpcId(-1);
			}
		}
		if(config.randomizer()>0){
			for (Player p : client.getPlayers()){
				p.getPlayerComposition().setTransformedNpcId(new Random().nextInt(9250));
			}
		}


		return null;
	}
}
