package data.rooms.pennave;

import java.awt.Point;
import java.io.File;

import objects.BackgroundObject;
import objects.BarrierObject;
import objects.IBarrierObject;
import objects.IDrawableObject;
import screensettings.ScreenSettings;
import trigger.DungeonRoomTrigger;
import trigger.ITrigger;
import trigger.LeftRoomTrigger;
import data.ConcreteRoom;

public class PennAve5 extends ConcreteRoom {
	public PennAve5(){
		setId(12);
		IDrawableObject background = new BackgroundObject();
		background.setSpriteFile(globalvariables.constants.IMAGE_LOCATION+"penn5"+File.separatorChar+"penn5.bmp");
		
		IBarrierObject northBarrier = new BarrierObject();
		IBarrierObject southBarrier = new BarrierObject();

		
		northBarrier.setX(0);
		northBarrier.setY(100);
		northBarrier.setHeight(10);
		northBarrier.setWidth(ScreenSettings.getInstance().getResWide());
		
		ITrigger eastWarp = new DungeonRoomTrigger("."+File.separatorChar+"rooms"+File.separatorChar+"whiteHouseExterior.dgn", new Point(300, 100), 1);
		eastWarp.setX(ScreenSettings.getInstance().getResWide() - 10);
		eastWarp.setY(0);
		eastWarp.setWidth(10);
		eastWarp.setHeight(ScreenSettings.getInstance().getResHeight());
		addTrigger(eastWarp);
		
		southBarrier.setX(0);
		southBarrier.setWidth(ScreenSettings.getInstance().getResWide());
		southBarrier.setY(ScreenSettings.getInstance().getResHeight() - 10);
		southBarrier.setHeight(10);
		
		ITrigger leftTrigger = new LeftRoomTrigger(ScreenSettings.getInstance().getResWide() - 50, ScreenSettings.getInstance().getResHeight() / 2);
		leftTrigger.setX(0);
		leftTrigger.setY(0);
		leftTrigger.setHeight(ScreenSettings.getInstance().getResHeight());
		leftTrigger.setWidth(10);
		
		addObject(northBarrier);
		addObject(southBarrier);
		addTrigger(leftTrigger);
		addObject(background);
	}
}
