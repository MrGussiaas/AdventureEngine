package data.rooms.outsidewhitehouse;

import objects.BackgroundObject;
import objects.BarrierObject;
import objects.IBarrierObject;
import objects.IDrawableObject;
import screensettings.ScreenSettings;
import trigger.ITrigger;
import trigger.LeftRoomTrigger;
import trigger.RightRoomTrigger;
import trigger.TopRoomTrigger;
import data.ConcreteRoom;

public class IndependenceAndWashingtonMonument extends ConcreteRoom {
	public IndependenceAndWashingtonMonument(){
		
		setId(7);
		
		IDrawableObject background = new BackgroundObject();
		background.setSpriteFile(globalvariables.constants.IMAGE_LOCATION+"whitehouse\\independenceandwashingtonmonument.bmp");
		addObject(background);
		
		IBarrierObject southBarrier = new BarrierObject();
		southBarrier.setX(0);
		southBarrier.setY(ScreenSettings.getInstance().getResHeight() - 10);
		southBarrier.setWidth(ScreenSettings.getInstance().getResWide());
		southBarrier.setHeight(10);
		addObject(southBarrier);
		
		ITrigger northWarp = new TopRoomTrigger(ScreenSettings.getInstance().getResWide() / 2, ScreenSettings.getInstance().getResHeight() - 100);
		northWarp.setX(0);
		northWarp.setY(100);
		northWarp.setHeight(10);
		northWarp.setWidth(ScreenSettings.getInstance().getResWide());
		addTrigger(northWarp);
		
		ITrigger eastWarp = new RightRoomTrigger(50, ScreenSettings.getInstance().getResHeight() / 2);
		eastWarp.setX(ScreenSettings.getInstance().getResWide() - 10);
		eastWarp.setY(0);
		eastWarp.setWidth(10);
		eastWarp.setHeight(ScreenSettings.getInstance().getResHeight());
		addTrigger(eastWarp);
		
		ITrigger westWarp = new LeftRoomTrigger(ScreenSettings.getInstance().getResWide() - 50, ScreenSettings.getInstance().getResHeight() / 2);
		westWarp.setX(0);
		westWarp.setY(0);
		westWarp.setWidth(10);
		westWarp.setHeight(ScreenSettings.getInstance().getResHeight());
		addTrigger(westWarp);
			
		
	}
}
