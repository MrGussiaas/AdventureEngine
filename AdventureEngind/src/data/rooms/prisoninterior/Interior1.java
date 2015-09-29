package data.rooms.prisoninterior;

import java.awt.Point;

import objects.BackgroundObject;
import objects.BarrierObject;
import objects.IBarrierObject;
import objects.IDrawableObject;
import objects.prisoninterior.LeftTorch;
import objects.prisoninterior.PrisonDoorEntrance;
import objects.prisoninterior.RightTorch;
import objects.prisoninterior.TourDesk;
import objects.prisoninterior.TourGuide;
import objects.prisoninterior.TourSign;
import screensettings.ScreenSettings;
import trigger.BottomRoomTrigger;
import trigger.DungeonRoomTrigger;
import trigger.ITrigger;
import trigger.TopRoomTrigger;
import data.ConcreteRoom;

public class Interior1 extends ConcreteRoom {
	public Interior1(){
		setId(1);
		IDrawableObject background = new BackgroundObject();
		background.setSpriteFile(globalvariables.constants.IMAGE_LOCATION+"PrisonInterior\\PrisonInterior1.bmp");
		
		IDrawableObject tourDesk = new TourDesk();
		tourDesk.setX(543);
		tourDesk.setY(164);
		addObject(tourDesk);
		
		IDrawableObject tourSign = new TourSign();
		tourSign.setX(543);
		tourSign.setY(110);
		addObject(tourSign);
		
		IDrawableObject prisonEntrance = new PrisonDoorEntrance();
		prisonEntrance.setX(250);
		prisonEntrance.setY(40);
		addObject(prisonEntrance);
		
		IDrawableObject leftTorch = new LeftTorch();
		leftTorch.setX(375);
		leftTorch.setY(60);
		addObject(leftTorch);
		
		IDrawableObject rightTorch = new RightTorch();
		rightTorch.setX(220);
		rightTorch.setY(60);
		addObject(rightTorch);
		
		IDrawableObject tourGuide = new TourGuide();
		tourGuide.setX(563);
		tourGuide.setY(130);
		addObject(tourGuide);
		
		//IBarrierObject NorthBarrier = new BarrierObject();
		
		ITrigger topTrigger = new TopRoomTrigger(ScreenSettings.getInstance().getResWide() / 2, ScreenSettings.getInstance().getResHeight() - 100);
		topTrigger.setX(0);
		topTrigger.setY(100);
		topTrigger.setHeight(10);
		topTrigger.setWidth(ScreenSettings.getInstance().getResWide());
		
		IBarrierObject EastBarrier = new BarrierObject();
		IBarrierObject WestBarrier = new BarrierObject();
		
		
		EastBarrier.setX(ScreenSettings.getInstance().getResWide() - 10);
		EastBarrier.setY(0);
		EastBarrier.setWidth(10);
		EastBarrier.setHeight(ScreenSettings.getInstance().getResHeight());
		
		WestBarrier.setX(0);
		WestBarrier.setY(0);
		WestBarrier.setWidth(10);
		WestBarrier.setHeight(ScreenSettings.getInstance().getResHeight());
		

		

		
		
		ITrigger warpDungeon = new DungeonRoomTrigger(".\\rooms\\testdungeon.dgn", new Point(200, 150), 5);
		warpDungeon.setX(0);
		warpDungeon.setY(ScreenSettings.getInstance().getResHeight() - 10);
		warpDungeon.setWidth(ScreenSettings.getInstance().getResWide());
		warpDungeon.setHeight(10);
		addTrigger(warpDungeon);
		
		addObject(WestBarrier);
		addObject(EastBarrier);
		addObject(background);
		addTrigger(topTrigger);
	}
}
