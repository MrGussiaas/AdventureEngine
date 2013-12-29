package data.rooms.pennave;

import objects.BackgroundObject;
import objects.BarrierObject;
import objects.IBarrierObject;
import objects.IDrawableObject;
import objects.outsideachmeres.AchmeresBuilding;
import screensettings.ScreenSettings;
import trigger.BottomRoomTrigger;
import trigger.DungeonTrigger;
import trigger.ITrigger;
import data.ConcreteRoom;

public class OutsideAchmeres extends ConcreteRoom {
	public OutsideAchmeres(){
		setId(9);
		IDrawableObject background = new BackgroundObject();
		IDrawableObject achmeresBuilding = new AchmeresBuilding();;
		
		background.setSpriteFile(".\\images\\nineteenth2\\nineteenth2.bmp");
		addObject(background);
		
		IBarrierObject eastBarrier = new BarrierObject();
		eastBarrier.setX(0);
		eastBarrier.setY(0);
		eastBarrier.setWidth(10);
		eastBarrier.setHeight(ScreenSettings.getInstance().getResHeight());
		
		IBarrierObject westBarrier = new BarrierObject();
		westBarrier.setX(ScreenSettings.getInstance().getResWide() - 10);
		westBarrier.setY(0);
		westBarrier.setWidth(10);
		westBarrier.setHeight(ScreenSettings.getInstance().getResHeight());
		
		IBarrierObject topBarrier = new BarrierObject();
		topBarrier.setX(0);
		topBarrier.setY(100);
		topBarrier.setWidth(ScreenSettings.getInstance().getResWide());
		topBarrier.setHeight(10);
		
		ITrigger bottomTrigger = new BottomRoomTrigger(ScreenSettings.getInstance().getResWide() / 2, 100);
		bottomTrigger.setX(0);
		bottomTrigger.setY(ScreenSettings.getInstance().getResHeight() - 10);
		bottomTrigger.setWidth(ScreenSettings.getInstance().getResWide());
		bottomTrigger.setHeight(10);
		addObject(eastBarrier);
		addObject(westBarrier);
		addObject(topBarrier);
		addTrigger(bottomTrigger);
		addObject(achmeresBuilding);
		
		
	}
}
