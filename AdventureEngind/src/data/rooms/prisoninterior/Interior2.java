package data.rooms.prisoninterior;

import java.awt.Point;

import objects.BackgroundObject;
import objects.BarrierObject;
import objects.IBarrierObject;
import objects.IDrawableObject;
import screensettings.ScreenSettings;
import trigger.BottomRoomTrigger;
import trigger.DungeonRoomTrigger;
import trigger.ITrigger;
import data.ConcreteRoom;

public class Interior2 extends ConcreteRoom {
	public Interior2(){
		setId(2);
		IDrawableObject background = new BackgroundObject();
		
		background.setSpriteFile(globalvariables.constants.IMAGE_LOCATION+"PrisonInterior\\PrisonInterior2.bmp");
		
		IBarrierObject NorthBarrier = new BarrierObject();
		IBarrierObject EastBarrier = new BarrierObject();
		IBarrierObject WestBarrier = new BarrierObject();
		
		ITrigger bottomTrigger = new BottomRoomTrigger(ScreenSettings.getInstance().getResWide() / 2, 100);
		bottomTrigger.setX(0);
		bottomTrigger.setY(ScreenSettings.getInstance().getResHeight() - 10);
		bottomTrigger.setHeight(10);
		bottomTrigger.setWidth(ScreenSettings.getInstance().getResWide());
		
		NorthBarrier.setX(0);
		NorthBarrier.setY(160);
		NorthBarrier.setHeight(10);
		NorthBarrier.setWidth(ScreenSettings.getInstance().getResWide());
		
		EastBarrier.setX(ScreenSettings.getInstance().getResWide() - 10);
		EastBarrier.setY(0);
		EastBarrier.setWidth(10);
		EastBarrier.setHeight(ScreenSettings.getInstance().getResHeight());
		
		WestBarrier.setX(0);
		WestBarrier.setY(0);
		WestBarrier.setWidth(10);
		WestBarrier.setHeight(ScreenSettings.getInstance().getResHeight());
		
		addObject(NorthBarrier);
		addObject(WestBarrier);
		addObject(EastBarrier);
		addObject(background);
		addTrigger(bottomTrigger);
		
	}
}
