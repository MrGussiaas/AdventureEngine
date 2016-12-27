package data.rooms.pennave;

import java.io.File;

import objects.BackgroundObject;
import objects.BarrierObject;
import objects.IBarrierObject;
import objects.IDrawableObject;
import objects.oncomingtraffic.TrafficSign;
import renderingpolicies.TransparencyPolicy;
import screensettings.ScreenSettings;
import scripts.ScreenLoadScript;
import scripts.oncomingtraffic.LoadTrafficScreenScript;
import trigger.BottomRoomTrigger;
import trigger.ITrigger;
import data.ConcreteRoom;

public class OnComingTraffic extends ConcreteRoom {
	public OnComingTraffic(){
		IDrawableObject background = new BackgroundObject();
		IDrawableObject roadSign = new TrafficSign();
		roadSign.setX(500);
		roadSign.setY(110);
		roadSign.addImagePolicy(new TransparencyPolicy(0xFFFA45EC));
		addObject(roadSign);
		
		background.setSpriteFile(globalvariables.constants.IMAGE_LOCATION+"traffic"+File.separatorChar+"on_coming_traffic.bmp");
		addObject(background);
		
		setId(4);
		IBarrierObject NorthBarrier = new BarrierObject();
		IBarrierObject EastBarrier = new BarrierObject();
		IBarrierObject WestBarrier = new BarrierObject();
		
		NorthBarrier.setX(0);
		NorthBarrier.setY(0);
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
		addObject(new ScreenLoadScript(new LoadTrafficScreenScript()));
		
		ITrigger bottomTrigger = new BottomRoomTrigger(50, 185);
		bottomTrigger.setX(0);
		bottomTrigger.setY(ScreenSettings.getInstance().getResHeight() - 10);
		bottomTrigger.setWidth(ScreenSettings.getInstance().getResWide());
		bottomTrigger.setHeight(10);
		
		addTrigger(bottomTrigger);
	}
}
