package net.runelite.client.plugins._Temp;


import com.google.inject.Inject;
import com.sun.istack.internal.NotNull;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.Player;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.components.*;
import net.runelite.client.ui.overlay.components.ComponentOrientation;
import net.runelite.client.ui.overlay.components.TextComponent;

import java.awt.*;
import java.util.Random;

public class TempPluginOverlay extends Overlay {
	@Inject
	TempPluginConfig config;
	@Inject
	Client client;

	PanelComponent panelComponent = new PanelComponent();
	ProgressPieComponent progressPieComponent = new ProgressPieComponent();
	InfoBoxComponent infoBoxComponent = new InfoBoxComponent();
	ProgressBarComponent progressBarComponent = new ProgressBarComponent();

	@Override
	public Dimension render(Graphics2D graphics) {
		if (config.TempButton1()) {

		}
		if (!config.TempButton1()){


		}

		return null;
	}
}
