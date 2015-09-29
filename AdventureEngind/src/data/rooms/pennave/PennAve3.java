package data.rooms.pennave;

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

public class PennAve3 extends ConcreteRoom {
	public PennAve3(){
		setId(6);
		
		IDrawableObject background = new BackgroundObject();
		background.setSpriteFile(globalvariables.constants.IMAGE_LOCATION+"penn3\\penn_ave_3.bmp");
		IBarrierObject bottomBarrier = new BarrierObject();
		bottomBarrier.setX(0);
		bottomBarrier.setY(ScreenSettings.getInstance().getResHeight() - 10);
		bottomBarrier.setWidth(ScreenSettings.getInstance().getResWide());
		bottomBarrier.setHeight(10);
		addObject(bottomBarrier);
		addObject(background);
		
		ITrigger topTrigger = new TopRoomTrigger(ScreenSettings.getInstance().getResWide() / 2, ScreenSettings.getInstance().getResHeight() - 100);
		topTrigger.setX(0);
		topTrigger.setY(100);
		topTrigger.setHeight(10);
		topTrigger.setWidth(ScreenSettings.getInstance().getResWide());
		
		ITrigger leftTrigger = new LeftRoomTrigger(ScreenSettings.getInstance().getResHeight() - 100, ScreenSettings.getInstance().getResHeight() / 2);
		leftTrigger.setX(0);
		leftTrigger.setY(0);
		leftTrigger.setWidth(10);
		leftTrigger.setHeight(ScreenSettings.getInstance().getResHeight());
		
		ITrigger rightTrigger = new RightRoomTrigger(50, ScreenSettings.getInstance().getResHeight() / 2);
		rightTrigger.setX(ScreenSettings.getInstance().getResWide() - 10);
		rightTrigger.setWidth(10);
		rightTrigger.setHeight(ScreenSettings.getInstance().getResHeight());
		
		addTrigger(topTrigger);
		addTrigger(leftTrigger);
		addTrigger(rightTrigger);
		
		
	}
}
