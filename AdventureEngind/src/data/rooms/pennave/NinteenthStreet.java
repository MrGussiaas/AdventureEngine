package data.rooms.pennave;

import objects.BackgroundObject;
import objects.BarrierObject;
import objects.IBarrierObject;
import objects.IDrawableObject;
import screensettings.ScreenSettings;
import trigger.BottomRoomTrigger;
import trigger.ITrigger;
import trigger.TopRoomTrigger;
import data.ConcreteRoom;

public class NinteenthStreet extends ConcreteRoom {
	public NinteenthStreet(){
		setId(7);
		IDrawableObject background = new BackgroundObject();
		background.setSpriteFile(globalvariables.constants.IMAGE_LOCATION+"nineteenth1\\nineteenth1.bmp");
		IBarrierObject eastBarrier = new BarrierObject();
		eastBarrier.setX(0);
		eastBarrier.setY(0);
		eastBarrier.setWidth(10);
		eastBarrier.setHeight(ScreenSettings.getInstance().getResHeight());
		
		IBarrierObject westBarrier = new BarrierObject();
		westBarrier.setX(ScreenSettings.getInstance().getResWide() - 10);
		westBarrier.setWidth(10);
		westBarrier.setHeight(ScreenSettings.getInstance().getResHeight());
		
		ITrigger topTrigger = new TopRoomTrigger(ScreenSettings.getInstance().getResWide() / 2, ScreenSettings.getInstance().getResHeight() - 100);
		topTrigger.setX(0);
		topTrigger.setY(100);
		topTrigger.setHeight(10);
		topTrigger.setWidth(ScreenSettings.getInstance().getResWide());
		
		ITrigger bottomTrigger = new BottomRoomTrigger(ScreenSettings.getInstance().getResWide() / 2, 100);
		bottomTrigger.setX(0);
		bottomTrigger.setY(ScreenSettings.getInstance().getResHeight() - 10);
		bottomTrigger.setHeight(10);
		bottomTrigger.setWidth(ScreenSettings.getInstance().getResWide());
		
		addObject(background);
		addTrigger(topTrigger);
		addTrigger(bottomTrigger);
		addObject(westBarrier);
		addObject(eastBarrier);
	}
}
