package data.rooms.pennave;

import objects.BackgroundObject;
import objects.BarrierObject;
import objects.ConcreteDrawableObject;
import objects.IBarrierObject;
import objects.IDrawableObject;
import objects.IGameObject;
import objects.backally.Boy1;
import objects.backally.Boy2;
import objects.backally.FireCracker;
import renderingpolicies.TransparencyPolicy;
import screensettings.ScreenSettings;
import scripts.ScreenLoadScript;
import scripts.oncomingtraffic.LoadBackAlleyScript;
import scripts.oncomingtraffic.LoadTrafficScreenScript;
import trigger.BottomRoomTrigger;
import trigger.ITrigger;
import data.ConcreteRoom;

public class BackAlly extends ConcreteRoom {
	public BackAlly(){
		setId(3);
		IBarrierObject NorthBarrier = new BarrierObject();
		IBarrierObject EastBarrier = new BarrierObject();
		IBarrierObject WestBarrier = new BarrierObject();
		IBarrierObject eastWallBarrier = new BarrierObject();
		
		IDrawableObject background = new BackgroundObject();
		IDrawableObject eastWall = new ConcreteDrawableObject();
		IDrawableObject fireCracker = new FireCracker();
		IDrawableObject boy1 = new Boy1();
		IDrawableObject boy2 = new Boy2();
		boy1.setInternalState(IGameObject.InternalObjectStates.DEFAULT_STATE);
		boy2.setInternalState(IGameObject.InternalObjectStates.DEFAULT_STATE);
		fireCracker.setInternalState(IGameObject.InternalObjectStates.DEFAULT_STATE);
		boy1.setSpriteFile(globalvariables.constants.IMAGE_LOCATION+"backally\\kidkneel1.bmp");
		boy2.setSpriteFile(globalvariables.constants.IMAGE_LOCATION+"backally\\kidright1.bmp");
		
		fireCracker.setSpriteFile(globalvariables.constants.IMAGE_LOCATION+"backally\\firecrackerunlimit.bmp");
		fireCracker.addImagePolicy(new TransparencyPolicy(0xFFFA45EC));
		boy1.addImagePolicy(new TransparencyPolicy(0xFFFA45EC));
		boy2.addImagePolicy(new TransparencyPolicy(0xFFFA45EC));
		fireCracker.setX(150);
		fireCracker.setY(200);
		boy1.setX(235);
		boy1.setY(220);
		boy2.setX(150);
		boy2.setY(225);
		
		
		eastWall.setSpriteFile(globalvariables.constants.IMAGE_LOCATION+"backally\\eastWall.bmp");
		eastWall.addImagePolicy(new TransparencyPolicy(0xFFFA45EC));
		eastWall.setX(ScreenSettings.getInstance().getResWide() - 107);
		eastWall.setY(ScreenSettings.getInstance().getResHeight() - 313);
		
		background.setSpriteFile(globalvariables.constants.IMAGE_LOCATION+"backally\\back_ally.bmp");
		
		NorthBarrier.setX(0);
		NorthBarrier.setY(160);
		NorthBarrier.setHeight(10);
		NorthBarrier.setWidth(ScreenSettings.getInstance().getResWide());
		
		EastBarrier.setX(ScreenSettings.getInstance().getResWide() - 10);
		EastBarrier.setY(0);
		EastBarrier.setWidth(10);
		EastBarrier.setHeight(ScreenSettings.getInstance().getResHeight());
		
		eastWallBarrier.setX(534);
		eastWallBarrier.setY(160);
		eastWallBarrier.setWidth(10);
		eastWallBarrier.setHeight(320);
		
		WestBarrier.setX(0);
		WestBarrier.setY(0);
		WestBarrier.setWidth(10);
		WestBarrier.setHeight(ScreenSettings.getInstance().getResHeight());
		
		addObject(NorthBarrier);
		addObject(WestBarrier);
		addObject(EastBarrier);
		addObject(eastWallBarrier);
		addObject(background);
		addObject(eastWall);
		addObject(fireCracker);
		addObject(boy1);
		addObject(boy2);
		
		ITrigger bottomTrigger = new BottomRoomTrigger(400, 110);
		bottomTrigger.setX(0);
		bottomTrigger.setY(ScreenSettings.getInstance().getResHeight() - 10);
		bottomTrigger.setWidth(ScreenSettings.getInstance().getResWide());
		bottomTrigger.setHeight(10);
		
		
		addObject(new ScreenLoadScript(new LoadBackAlleyScript()));
		addTrigger(bottomTrigger);
		
	}
}
