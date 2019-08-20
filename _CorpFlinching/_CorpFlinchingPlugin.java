package net.runelite.client.plugins._CorpFlinching;

import com.google.inject.Inject;
import com.google.inject.Provides;
import net.runelite.api.*;
import net.runelite.api.events.*;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

import java.util.*;

@PluginDescriptor(name = "__CorpFlinchPlugin")
public class _CorpFlinchingPlugin extends Plugin {
	public Actor corp;
	@Inject
	Client client;
	@Inject
	private _CorpFlinchingConfig corpFlinchConfig;
	@Inject
	private _CorpFlinchingOverlay corpFlinchingOverlay;
	@Inject
	private OverlayManager overlayManager;

	@Provides
	_CorpFlinchingConfig getConfig(ConfigManager configManager) {
		return configManager.getConfig(_CorpFlinchingConfig.class);
	}

	@Override
	protected void startUp() throws Exception {
		System.out.println("nemjef start");
		overlayManager.add(corpFlinchingOverlay);
	}

	@Override
	protected void shutDown() throws Exception {
		System.out.println("end");
		overlayManager.remove(corpFlinchingOverlay);
	}

	@Subscribe
	public void onGameTick(GameTick tick) {
		if (corpFlinchingOverlay.corphasstomped && corpFlinchingOverlay.stompcounter <= 5) {
			corpFlinchingOverlay.stompcounter++;
		} else {
			corpFlinchingOverlay.stompcounter = 0;
		}
		corpFlinchingOverlay.hitcounter++;

		if (corpFlinchingOverlay.hitcounter == 1 && corpFlinchingOverlay.stompcounter == 6) {
			corpFlinchingOverlay.hitcounter--;
		}
	}

	@Subscribe
	public void onAnimationChanged(AnimationChanged event) {
		if (event.getActor().getAnimation() == 1686) {
			corpFlinchingOverlay.corphasstomped = true;
			corpFlinchingOverlay.stompcounter = 0;
			System.out.println("corp stomped");
		}
	}

	@Subscribe
	public void onHitsplatApplied(HitsplatApplied hit) {
		System.out.println("actor: " + hit.getActor().getName());
		if (hit.getActor().getName().equals("Corporeal Beast")) {

			corpFlinchingOverlay.hitcounter = 0;
		}
		System.out.println(corpFlinchingOverlay.hitcounter + " " + corpFlinchingOverlay.stompcounter);
	}
}
