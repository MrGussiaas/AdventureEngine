package data.rooms.outsidewhitehouse;

import objects.BackgroundObject;
import objects.BarrierObject;
import objects.IBarrierObject;
import objects.IDrawableObject;
import screensettings.ScreenSettings;
import trigger.BottomRoomTrigger;
import trigger.ITrigger;
import trigger.LeftRoomTrigger;
import data.ConcreteRoom;

public class FifteenthAndEastStreet extends ConcreteRoom {
	public FifteenthAndEastStreet(){
		
		setId(21);
		
		IDrawableObject background = new BackgroundObject();
		background.setSpriteFile(".\\images\\whitehouse\\fifteenthandeast.bmp");
		addObject(background);
		
		IBarrierObject northBarrier = new BarrierObject();
		northBarrier.setX(0);
		northBarrier.setY(0);
		northBarrier.setHeight(10);
		northBarrier.setWidth(ScreenSettings.getInstance().getResWide());
		addObject(northBarrier);
		
		IBarrierObject eastBarrier = new BarrierObject();
		eastBarrier.setX(ScreenSettings.getInstance().getResWide() - 10);
		eastBarrier.setHeight(ScreenSettings.getInstance().getResHeight());
		eastBarrier.setWidth(10);
		addObject(northBarrier);
		
		ITrigger southWarp = new BottomRoomTrigger(ScreenSettings.getInstance().getResWide() / 2, 100);
		southWarp.setX(0);
		southWarp.setY(ScreenSettings.getInstance().getResHeight() - 10);
		southWarp.setWidth(ScreenSettings.getInstance().getResWide());
		southWarp.setHeight(10);
		addTrigger(southWarp);
		
		ITrigger westWarp = new LeftRoomTrigger(ScreenSettings.getInstance().getResWide() - 50, ScreenSettings.getInstance().getResHeight() / 2);
		westWarp.setX(0);
		westWarp.setY(0);
		westWarp.setWidth(10);
		westWarp.setHeight(ScreenSettings.getInstance().getResHeight());
		addTrigger(westWarp);
		
		
		
		
	}
}
