package data.rooms.outsidewhitehouse;

import objects.BackgroundObject;
import objects.BarrierObject;
import objects.IBarrierObject;
import objects.IDrawableObject;
import screensettings.ScreenSettings;
import trigger.BottomRoomTrigger;
import trigger.ITrigger;
import trigger.RightRoomTrigger;
import trigger.TopRoomTrigger;
import data.ConcreteRoom;

public class SeventeenthAndConstitution extends ConcreteRoom {
	public SeventeenthAndConstitution(){
		setId(4);
		
		
		IDrawableObject background = new BackgroundObject();
		background.setSpriteFile(".\\images\\whitehouse\\seventeenthandconstitution.bmp");
		addObject(background);
		
		IBarrierObject westBarrier = new BarrierObject();
		westBarrier.setX(0);
		westBarrier.setY(0);
		westBarrier.setWidth(10);
		westBarrier.setHeight(ScreenSettings.getInstance().getResHeight());
		addObject(westBarrier);
		
		ITrigger southWarp = new BottomRoomTrigger(ScreenSettings.getInstance().getResWide() / 2, 100);
		southWarp.setX(0);
		southWarp.setY(ScreenSettings.getInstance().getResHeight() - 10);
		southWarp.setWidth(ScreenSettings.getInstance().getResWide());
		southWarp.setHeight(10);

		ITrigger northWarp = new TopRoomTrigger(ScreenSettings.getInstance().getResWide() / 2, ScreenSettings.getInstance().getResHeight() - 100);
		northWarp.setX(0);
		northWarp.setY(100);
		northWarp.setHeight(10);
		northWarp.setWidth(ScreenSettings.getInstance().getResWide());

		ITrigger eastWarp = new RightRoomTrigger(50, ScreenSettings.getInstance().getResHeight() / 2);
		eastWarp.setX(ScreenSettings.getInstance().getResWide() - 10);
		eastWarp.setY(0);
		eastWarp.setWidth(10);
		eastWarp.setHeight(ScreenSettings.getInstance().getResHeight());
		addTrigger(eastWarp);
		
		
		
		
	}
}
