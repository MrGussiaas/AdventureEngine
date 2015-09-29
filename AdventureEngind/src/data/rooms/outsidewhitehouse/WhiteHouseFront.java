package data.rooms.outsidewhitehouse;

import objects.BackgroundObject;
import objects.BarrierObject;
import objects.IBarrierObject;
import objects.IDrawableObject;
import screensettings.ScreenSettings;
import trigger.BottomRoomTrigger;
import trigger.ITrigger;
import trigger.LeftRoomTrigger;
import trigger.RightRoomTrigger;
import data.ConcreteRoom;

public class WhiteHouseFront extends ConcreteRoom {
	public WhiteHouseFront(){
		setId(12);
		
		IDrawableObject background = new BackgroundObject();
		background.setSpriteFile(globalvariables.constants.IMAGE_LOCATION+"whitehouse\\whitehousefront.bmp");
		addObject(background);
		
		IBarrierObject northBarrier = new BarrierObject();
		northBarrier.setX(0);
		northBarrier.setY(0);
		northBarrier.setHeight(10);
		northBarrier.setWidth(ScreenSettings.getInstance().getResWide());
		addObject(northBarrier);
		
		ITrigger southWarp = new BottomRoomTrigger(ScreenSettings.getInstance().getResWide() / 2, 100);
		southWarp.setX(0);
		southWarp.setY(ScreenSettings.getInstance().getResHeight() - 10);
		southWarp.setWidth(ScreenSettings.getInstance().getResWide());
		southWarp.setHeight(10);
		addTrigger(southWarp);
		
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
