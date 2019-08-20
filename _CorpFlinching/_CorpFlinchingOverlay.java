package net.runelite.client.plugins._CorpFlinching;

import javafx.animation.Animation;
import net.runelite.api.*;
import net.runelite.api.Point;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ItemSpawned;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.*;
import net.runelite.client.ui.overlay.components.ProgressPieComponent;

import javax.inject.Inject;
import java.awt.*;

public class _CorpFlinchingOverlay extends Overlay {

	boolean corphasstomped = false;
	int stompcounter = 0;
	int hitcounter;
	ProgressPieComponent progressPieComponent = new ProgressPieComponent();
	ProgressPieComponent progressPieComponent2 = new ProgressPieComponent();
	private _CorpFlinchingConfig config;
	@Inject
	private Client client;
	@Inject
	private ItemManager itemManager;

	@Inject
	public _CorpFlinchingOverlay(_CorpFlinchingConfig config) {
		this.config = config;
		setLayer(OverlayLayer.ABOVE_SCENE);
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.MED);
	}

	@Override
	public Dimension render(Graphics2D graphics) {

		if (config.stompCounter()) {
			if (corphasstomped) {
				if (stompcounter == 0)
					OverlayUtil.renderTextLocation(graphics, new Point(250, 40), "Corp cycle: " + "1 STOMP", Color.ORANGE);
				else
					OverlayUtil.renderTextLocation(graphics, new Point(250, 40), "Corp cycle: " + (stompcounter + 1), Color.ORANGE);
			}
		}

		if (config.flinchCounter()) {

			if (hitcounter == 8)
				OverlayUtil.renderTextLocation(graphics, new Point(250, 60), "Retaliate delay: " + (hitcounter + "CLICK"), Color.ORANGE);

			OverlayUtil.renderTextLocation(graphics, new Point(250, 60), "Retaliate delay: " + (hitcounter), Color.ORANGE);
		}
		if (config.Pietingbutton()) {

			for (NPC npc : client.getNpcs()) {
				if (npc.getName().equals("Corporeal Beast")) {
					progressPieComponent.setPosition(new Point(Perspective.localToCanvas(client, npc.getLocalLocation(), client.getPlane(), config.StomppieX()).getX(),
							Perspective.localToCanvas(client, npc.getLocalLocation(), client.getPlane(), config.pieTingY()).getY()));
				}
				if (hitcounter <= 8) {
					progressPieComponent.setBorderColor(Color.BLACK);
					if (hitcounter == 7) progressPieComponent.setFill(Color.blue);
					else if (hitcounter == 8) progressPieComponent.setFill(Color.green);
					else progressPieComponent.setFill(Color.ORANGE);
					progressPieComponent.setProgress((double) hitcounter / 8);
					progressPieComponent.render(graphics);
				}
			}
		}
		if (config.Stomppie()) {
			for (NPC npc : client.getNpcs()) {
				if (npc.getName().equals("Corporeal Beast")) {
					progressPieComponent2.setPosition(new Point(Perspective.localToCanvas(client, npc.getLocalLocation(), client.getPlane(), config.StomppieX()).getX(),
							Perspective.localToCanvas(client, npc.getLocalLocation(), client.getPlane(), config.StomppieY()).getY()));

					switch (stompcounter) {
						case 0:
							progressPieComponent2.setProgress(1);
							break;
						case 1:
							progressPieComponent2.setProgress(0.142);
							break;
						case 2:
							progressPieComponent2.setProgress(0.285);
							break;
						case 3:
							progressPieComponent2.setProgress(0.428);
							break;
						case 4:
							progressPieComponent2.setProgress(0.574);
							break;
						case 5:
							progressPieComponent2.setProgress(0.714);
							break;
						case 6:
							progressPieComponent2.setProgress(0.857);
							break;
					}
					progressPieComponent2.setBorderColor(Color.BLACK);
					progressPieComponent2.setFill(Color.ORANGE);
					if (stompcounter == 0) progressPieComponent2.setFill(Color.red);
					else if (stompcounter == 6) progressPieComponent2.setFill(Color.BLACK);
					else if (stompcounter == 5) progressPieComponent2.setFill(Color.CYAN);
					progressPieComponent2.render(graphics);
				}
			}
		}
		return null;
	}
}
