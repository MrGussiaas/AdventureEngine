package data.rooms.outsidewhitehouse;

import java.io.File;

import objects.BackgroundObject;
import objects.BarrierObject;
import objects.IBarrierObject;
import objects.IDrawableObject;
import screensettings.ScreenSettings;
import trigger.BottomRoomTrigger;
import trigger.ITrigger;
import data.ConcreteRoom;

public class WhiteHouseAlly extends ConcreteRoom {
	public WhiteHouseAlly(){
		
		setId(11);
		
		IDrawableObject background = new BackgroundObject();
		background.setSpriteFile(globalvariables.constants.IMAGE_LOCATION+"whitehouse"+File.separatorChar+"whitehouseally.bmp");
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
		addObject(eastBarrier);

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
		addTrigger(southWarp);
	}
}
