package data.rooms.pennave;

import objects.BackgroundObject;
import objects.BarrierObject;
import objects.Building1;
import objects.IBarrierObject;
import objects.IDrawableObject;
import objects.IGameObject;
import objects.TestLines;
import objects.backgrounds.BackgroundPenn1;
import objects.pennave1.Cop1;
import objects.pennave1.Cop2;
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

public class PennAve1 extends ConcreteRoom {
	public PennAve1(){
		setId(1);
		IDrawableObject bgObject = new BackgroundObject();
		bgObject.setSpriteFile(".\\images\\pennAve1.bmp");
		IGameObject blueBuilding = new Building1();
		blueBuilding.setX(10);
		blueBuilding.setY(0);

		
		IDrawableObject cop1 = new Cop1();
		IGameObject cop2 = new Cop2();
		cop1.setX(350);
		cop1.setY(200);
		cop2.setY(200);
		cop2.setX(375);
		
		
		addObject(cop1);
		addObject(cop2);

		IBarrierObject block = new BarrierObject();
		IBarrierObject block2 = new BarrierObject();
		IBarrierObject block3 = new BarrierObject();
		IBarrierObject block4 = new BarrierObject();
		
		block4.setX(0);
		block4.setY(ScreenSettings.getInstance().getResHeight() - 10);
		block4.setWidth(ScreenSettings.getInstance().getResWide());
		block4.setHeight(10);
		
		block3.setX(ScreenSettings.getInstance().getResWide() - 10);
		block3.setY(0);
		block3.setWidth(10);
		block3.setHeight(ScreenSettings.getInstance().getResHeight());
		
		block2.setX(0);
		block2.setY(0);
		block2.setHeight(10);
		block2.setWidth(ScreenSettings.getInstance().getResWide());
		
		
		
		
		block.setX(0);
		block.setY(0);
		block.setWidth(10);
		block.setHeight(ScreenSettings.getInstance().getResHeight());

		addObject(bgObject);
		addObject(block);
		addObject(block2);
		addObject(block3);
		addObject(block4);
		addObject(blueBuilding);
		
		
		ITrigger topTrigger = new TopRoomTrigger(ScreenSettings.getInstance().getResWide() / 2, ScreenSettings.getInstance().getResHeight() - 100);
		ITrigger bottomTrigger = new BottomRoomTrigger(0, 0);
		ITrigger rightTrigger = new RightRoomTrigger(50, ScreenSettings.getInstance().getResHeight() / 2);
		ITrigger leftTrigger = new LeftRoomTrigger(ScreenSettings.getInstance().getResWide() / 2, ScreenSettings.getInstance().getResHeight() - 100);
		addTrigger(topTrigger);
		topTrigger.setX(300);
		topTrigger.setY(100);
		topTrigger.setHeight(10);
		topTrigger.setWidth(300);
		
		
		addTrigger(bottomTrigger);
		bottomTrigger.setX(0);
		bottomTrigger.setY(490);
		bottomTrigger.setWidth(300);
		bottomTrigger.setHeight(10);
		
		addTrigger(rightTrigger);
		rightTrigger.setX(600);
		rightTrigger.setY(190);
		rightTrigger.setWidth(10);
		rightTrigger.setHeight(275);
		
		addTrigger(leftTrigger);
		leftTrigger.setX(41);
		leftTrigger.setY(180);
		leftTrigger.setWidth(10);
		leftTrigger.setHeight(250);
		
		IBarrierObject block5 = new BarrierObject();
		block5.setX(0);
		block5.setY(180);
		block5.setHeight(10);
		block5.setWidth(361);
		
		IBarrierObject block6 = new BarrierObject();
		block6.setX(350);
		block6.setHeight(191);
		block6.setY(0);
		block6.setWidth(10);
		
		IBarrierObject block7 = new BarrierObject();
		block7.setX(501);
		block7.setY(0);
		block7.setHeight(210);
		block7.setWidth(10);
		
		IBarrierObject block8 = new BarrierObject();
		block8.setX(500);
		block8.setY(190);
		block8.setWidth(140);
		block8.setHeight(10);
		
		addObject(block6);
		addObject(block5);
		addObject(block7);
		addObject(block8);
		

		
	}
}
