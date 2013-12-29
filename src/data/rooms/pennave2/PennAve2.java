package data.rooms.pennave2;

import objects.BackgroundObject;
import objects.BarrierObject;
import objects.IBarrierObject;
import objects.IDrawableObject;
import objects.IGameObject;
import objects.TestLines;
import renderingpolicies.TransparencyPolicy;
import screensettings.ScreenConverterUtils;
import screensettings.ScreenSettings;
import testgame.Apple;
import testgame.AvatarObject;
import testgame.SnackDesk;
import trigger.BottomRoomTrigger;
import trigger.ITrigger;
import trigger.LeftRoomTrigger;
import trigger.RightRoomTrigger;
import trigger.TopRoomTrigger;
import data.ConcreteRoom;

public class PennAve2 extends ConcreteRoom {
	public PennAve2(){
		setId(2);

		
		IDrawableObject backgroundObject = new BackgroundObject();
		backgroundObject.setSpriteFile(".\\images\\penn2\\penn_ave_2.bmp");
		IBarrierObject leftBarrier = new BarrierObject();
		IBarrierObject topBarrier = new BarrierObject();
		IBarrierObject bottomBarrier = new BarrierObject();
		IBarrierObject rightBarrier = new BarrierObject();
		
		leftBarrier.setX(0);
		leftBarrier.setY(0);
		leftBarrier.setWidth(10);
		leftBarrier.setHeight(162);
		
		topBarrier.setX(0);
		topBarrier.setY(0);
		topBarrier.setWidth(395);
		topBarrier.setHeight(10);
		
		bottomBarrier.setX(0);
		bottomBarrier.setHeight(10);
		bottomBarrier.setY(162);
		bottomBarrier.setWidth(405);
		
		rightBarrier.setX(394);
		rightBarrier.setY(0);
		rightBarrier.setHeight(162);
		rightBarrier.setWidth(10);
		
		
		
		
		
		addObject(backgroundObject);
		addObject(leftBarrier);
		addObject(topBarrier);
		addObject(rightBarrier);
		addObject(bottomBarrier);
		

		IDrawableObject launderyShop = new LaundaryShop();
		IDrawableObject cookieShop = new CookieShop();
		IDrawableObject parkingLot = new ParkingLot();
		parkingLot.addImagePolicy(new TransparencyPolicy(0xFFFA45EC));
		cookieShop.addImagePolicy(new TransparencyPolicy(0xFFFA45EC));
		
		parkingLot.setX(390);
		parkingLot.setY(20);
		
		launderyShop.setX(0);
		launderyShop.setY(0);
		addObject(launderyShop);
		addObject(cookieShop);
		addObject(parkingLot);
		cookieShop.setX(135);
		cookieShop.setY(0);

		
		//ITrigger topTrigger = new TopRoomTrigger(ScreenSettings.getInstance().getResWide() / 2, ScreenSettings.getInstance().getResHeight() - 50);
		ITrigger bottomTrigger = new BottomRoomTrigger(ScreenSettings.getInstance().getResHeight() / 2, 150);
		ITrigger rightTrigger = new RightRoomTrigger(50, ScreenSettings.getInstance().getResHeight() / 2);
		ITrigger leftTrigger = new LeftRoomTrigger(497, 200);

		
		
		addTrigger(bottomTrigger);
		bottomTrigger.setX(0);
		bottomTrigger.setY(ScreenSettings.getInstance().getResHeight() - 10);
		bottomTrigger.setWidth(ScreenSettings.getInstance().getResWide());
		bottomTrigger.setHeight(10);
		
		addTrigger(rightTrigger);
		rightTrigger.setX(ScreenSettings.getInstance().getResWide() - 10);
		rightTrigger.setY(0);
		rightTrigger.setWidth(10);
		rightTrigger.setHeight(ScreenSettings.getInstance().getResHeight());
		
		addTrigger(leftTrigger);
		leftTrigger.setX(0);
		leftTrigger.setY(0);
		leftTrigger.setWidth(10);
		leftTrigger.setHeight(ScreenSettings.getInstance().getResHeight());
		

		
	}
}
