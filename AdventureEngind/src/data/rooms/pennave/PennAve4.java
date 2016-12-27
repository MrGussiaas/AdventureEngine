package data.rooms.pennave;

import java.io.File;

import objects.BackgroundObject;
import objects.BarrierObject;
import objects.IBarrierObject;
import objects.IDrawableObject;
import screensettings.ScreenSettings;
import trigger.ITrigger;
import trigger.LeftRoomTrigger;
import trigger.RightRoomTrigger;
import trigger.TopRoomTrigger;
import data.ConcreteRoom;

public class PennAve4 extends ConcreteRoom {
	public PennAve4(){
		setId(10);
		IDrawableObject background = new BackgroundObject();
		background.setSpriteFile(globalvariables.constants.IMAGE_LOCATION+"penn4"+File.separatorChar+"pennave4.bmp");
		addObject(background);
		
		IBarrierObject southBarrier = new BarrierObject();
		southBarrier.setX(0);
		southBarrier.setY(ScreenSettings.getInstance().getResHeight() - 10);
		southBarrier.setHeight(10);
		southBarrier.setWidth(ScreenSettings.getInstance().getResWide());
		
		ITrigger topTrigger = new TopRoomTrigger(ScreenSettings.getInstance().getResWide() / 2, ScreenSettings.getInstance().getResHeight() - 100);
		ITrigger leftTrigger = new LeftRoomTrigger(ScreenSettings.getInstance().getResWide() - 50, ScreenSettings.getInstance().getResHeight() / 2);
		ITrigger rightTrigger = new RightRoomTrigger(50, ScreenSettings.getInstance().getResHeight() / 2);
		
		topTrigger.setX(0);
		topTrigger.setY(100);
		topTrigger.setHeight(10);
		topTrigger.setWidth(ScreenSettings.getInstance().getResWide());
		
		leftTrigger.setX(0);
		leftTrigger.setY(0);
		leftTrigger.setHeight(ScreenSettings.getInstance().getResHeight());
		leftTrigger.setWidth(10);
		
		rightTrigger.setX(ScreenSettings.getInstance().getResWide() - 10);
		rightTrigger.setY(0);
		rightTrigger.setWidth(10);
		rightTrigger.setHeight(ScreenSettings.getInstance().getResHeight());
		
		addObject(southBarrier);
		addTrigger(topTrigger);
		addTrigger(leftTrigger);
		addTrigger(rightTrigger);
	}
}
