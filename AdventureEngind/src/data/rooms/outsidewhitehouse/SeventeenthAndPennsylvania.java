package data.rooms.outsidewhitehouse;

import java.awt.Point;
import java.io.File;

import objects.BackgroundObject;
import objects.BarrierObject;
import objects.IBarrierObject;
import objects.IDrawableObject;
import screensettings.ScreenSettings;
import trigger.BottomRoomTrigger;
import trigger.DungeonRoomTrigger;
import trigger.ITrigger;
import data.ConcreteRoom;

public class SeventeenthAndPennsylvania extends ConcreteRoom {
	public SeventeenthAndPennsylvania(){
		
		setId(1);
		
		IDrawableObject background = new BackgroundObject();
		background.setSpriteFile(globalvariables.constants.IMAGE_LOCATION+"whitehouse"+File.separatorChar+"seventeenthandpenn.bmp");
		addObject(background);
		
		ITrigger southWarp = new BottomRoomTrigger(ScreenSettings.getInstance().getResWide() / 2, 100);
		southWarp.setX(0);
		southWarp.setY(ScreenSettings.getInstance().getResHeight() - 10);
		southWarp.setWidth(ScreenSettings.getInstance().getResWide());
		southWarp.setHeight(10);
		
		ITrigger westWarp = new DungeonRoomTrigger("."+File.separatorChar+"rooms"+File.separatorChar+"testdungeon.dgn", new Point(300, 100), 12);
		westWarp.setX(0);
		westWarp.setY(0);
		westWarp.setWidth(10);
		westWarp.setHeight(ScreenSettings.getInstance().getResHeight());
		
		addTrigger(southWarp);
		addTrigger(westWarp);
		
		IBarrierObject northBarrier = new BarrierObject();
		northBarrier.setX(0);
		northBarrier.setY(0);
		northBarrier.setHeight(10);
		northBarrier.setWidth(ScreenSettings.getInstance().getResWide());
		
		IBarrierObject eastBarrier = new BarrierObject();
		eastBarrier.setX(ScreenSettings.getInstance().getResWide() - 10);
		eastBarrier.setHeight(ScreenSettings.getInstance().getResHeight());
		eastBarrier.setWidth(10);
		
		addObject(northBarrier);
		addObject(eastBarrier);
		
		
		
	}
}
