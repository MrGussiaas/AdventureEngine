package data.rooms.outsidewhitehouse;

import objects.BackgroundObject;
import objects.BarrierObject;
import objects.IBarrierObject;
import objects.IDrawableObject;
import screensettings.ScreenSettings;
import trigger.ITrigger;
import trigger.RightRoomTrigger;
import trigger.TopRoomTrigger;
import data.ConcreteRoom;

public class SeventeenthAndIndependence extends ConcreteRoom {
	public SeventeenthAndIndependence(){
		setId(6);
		
		IDrawableObject background = new BackgroundObject();
		background.setSpriteFile(globalvariables.constants.IMAGE_LOCATION+"whitehouse\\seventeenthandindependence.bmp");
		addObject(background);
		
		IBarrierObject westBarrier = new BarrierObject();
		westBarrier.setX(0);
		westBarrier.setY(0);
		westBarrier.setWidth(10);
		westBarrier.setHeight(ScreenSettings.getInstance().getResHeight());
		addObject(westBarrier);
		
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
		
		IBarrierObject southBarrier = new BarrierObject();
		southBarrier.setX(0);
		southBarrier.setY(ScreenSettings.getInstance().getResHeight() - 10);
		southBarrier.setWidth(ScreenSettings.getInstance().getResWide());
		southBarrier.setHeight(10);
		addObject(southBarrier);
		
		
	}
}
