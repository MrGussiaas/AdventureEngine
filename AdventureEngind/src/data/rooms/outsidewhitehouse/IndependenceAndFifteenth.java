package data.rooms.outsidewhitehouse;

import java.io.File;

import objects.BackgroundObject;
import objects.BarrierObject;
import objects.IBarrierObject;
import objects.IDrawableObject;
import screensettings.ScreenSettings;
import trigger.ITrigger;
import trigger.LeftRoomTrigger;
import trigger.TopRoomTrigger;
import data.ConcreteRoom;

public class IndependenceAndFifteenth extends ConcreteRoom {
	public IndependenceAndFifteenth(){
		
		setId(17);
		
		IDrawableObject background = new BackgroundObject();
		background.setSpriteFile(globalvariables.constants.IMAGE_LOCATION+"whitehouse"+File.separatorChar+"fifteenthandindependence.bmp");
		addObject(background);
		
		IBarrierObject southBarrier = new BarrierObject();
		southBarrier.setX(0);
		southBarrier.setY(ScreenSettings.getInstance().getResHeight() - 10);
		southBarrier.setWidth(ScreenSettings.getInstance().getResWide());
		southBarrier.setHeight(10);
		addObject(southBarrier);
		
		IBarrierObject eastBarrier = new BarrierObject();
		eastBarrier.setX(ScreenSettings.getInstance().getResWide() - 10);
		eastBarrier.setHeight(ScreenSettings.getInstance().getResHeight());
		eastBarrier.setWidth(10);
		addObject(eastBarrier);
		
		ITrigger westWarp = new LeftRoomTrigger(ScreenSettings.getInstance().getResWide() - 50, ScreenSettings.getInstance().getResHeight() / 2);
		westWarp.setX(0);
		westWarp.setY(0);
		westWarp.setWidth(10);
		westWarp.setHeight(ScreenSettings.getInstance().getResHeight());
		addTrigger(westWarp);
		
		ITrigger northWarp = new TopRoomTrigger(ScreenSettings.getInstance().getResWide() / 2, ScreenSettings.getInstance().getResHeight() - 100);
		northWarp.setX(0);
		northWarp.setY(100);
		northWarp.setHeight(10);
		northWarp.setWidth(ScreenSettings.getInstance().getResWide());
		
		
		
		
	}
}
