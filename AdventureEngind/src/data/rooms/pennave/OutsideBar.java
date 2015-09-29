package data.rooms.pennave;

import objects.BackgroundObject;
import objects.BarrierObject;
import objects.IBarrierObject;
import objects.IDrawableObject;
import screensettings.ScreenSettings;
import trigger.BottomRoomTrigger;
import trigger.ITrigger;
import data.ConcreteRoom;

public class OutsideBar extends ConcreteRoom {
	public OutsideBar(){
		setId(11);
		IDrawableObject background = new BackgroundObject();
		background.setSpriteFile(globalvariables.constants.IMAGE_LOCATION+"eighteenth\\eighteenth.bmp");
		
		IBarrierObject northBarrier = new BarrierObject();
		IBarrierObject eastBarrier = new BarrierObject();
		IBarrierObject westBarrier = new BarrierObject();
		
		northBarrier.setX(0);
		northBarrier.setY(100);
		northBarrier.setWidth(ScreenSettings.getInstance().getResWide());
		northBarrier.setHeight(10);
		
		westBarrier.setX(0);
		westBarrier.setY(0);
		westBarrier.setWidth(10);
		westBarrier.setHeight(ScreenSettings.getInstance().getResHeight());
		
		eastBarrier.setX(ScreenSettings.getInstance().getResWide() - 10);
		eastBarrier.setY(0);
		eastBarrier.setWidth(10);
		eastBarrier.setHeight(ScreenSettings.getInstance().getResHeight());
		
		ITrigger bottomTrigger = new BottomRoomTrigger(ScreenSettings.getInstance().getResWide() / 2, 100);
		bottomTrigger.setX(0);
		bottomTrigger.setY(ScreenSettings.getInstance().getResHeight() - 10);
		bottomTrigger.setHeight(10);
		bottomTrigger.setWidth(ScreenSettings.getInstance().getResWide());
		
		addObject(background);
		addObject(northBarrier);
		addObject(eastBarrier);
		addObject(westBarrier);
		
		addTrigger(bottomTrigger);
		
		
			
		
	}
}
