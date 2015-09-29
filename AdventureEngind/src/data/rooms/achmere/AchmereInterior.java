package data.rooms.achmere;

import java.awt.Point;

import objects.BackgroundObject;
import objects.BarrierObject;
import objects.IBarrierObject;
import objects.IDrawableObject;
import objects.IGameObject;
import renderingpolicies.TransparencyPolicy;
import screensettings.ScreenSettings;
import trigger.DungeonRoomTrigger;
import trigger.DungeonTrigger;
import trigger.ITrigger;
import data.ConcreteRoom;

public class AchmereInterior extends ConcreteRoom {
	public AchmereInterior(){
		IDrawableObject background = new BackgroundObject();
		IDrawableObject desk = new Counter();
		IDrawableObject aisle1 = new Shelf1();
		IDrawableObject aisle2 = new Shelf2();
		IDrawableObject achmere = new Achmere();
		
		IDrawableObject beerCooler = new BeerCooler();
		IDrawableObject wineCooler = new WineCooler();
		IDrawableObject dewCooler = new DewCooler();
		
		
		
		IBarrierObject aisle1North = new BarrierObject();
		IBarrierObject aisle1East = new BarrierObject();
		IBarrierObject aisle1South = new BarrierObject();
		IBarrierObject aisle1West = new BarrierObject();
		
		IBarrierObject aisle2North = new BarrierObject();
		IBarrierObject aisle2East = new BarrierObject();
		IBarrierObject aisle2South = new BarrierObject();
		IBarrierObject aisle2West = new BarrierObject();
		
		IBarrierObject counterNorth = new BarrierObject();
		
		beerCooler.setX(0);
		beerCooler.setY(0);
		
		wineCooler.setX(128);
		wineCooler.setY(0);
		
		dewCooler.setX(256);
		dewCooler.setY(0);
		
		counterNorth.setX(484);
		counterNorth.setY(126);
		counterNorth.setWidth(5);
		counterNorth.setHeight(380);
		
		aisle2North.setX(280);
		aisle2North.setY(135);
		aisle2North.setHeight(5);
		aisle2North.setWidth(57);
		
		aisle2East.setX(337);
		aisle2East.setY(135);
		aisle2East.setWidth(5);
		aisle2East.setHeight(240);
		
		aisle2South.setX(260);
		aisle2South.setWidth(102);
		aisle2South.setHeight(5);
		aisle2South.setY(375);
		
		aisle2West.setX(280);
		aisle2West.setY(135);
		aisle2West.setWidth(5);
		aisle2West.setHeight(240);
		
		aisle1North.setX(150);
		aisle1North.setY(135);
		aisle1North.setHeight(5);
		aisle1North.setWidth(57);
		
		aisle1East.setX(207);
		aisle1East.setY(135);
		aisle1East.setWidth(5);
		aisle1East.setHeight(240);
		
		aisle1South.setX(130);
		aisle1South.setWidth(102);
		aisle1South.setHeight(5);
		aisle1South.setY(375);
		
		aisle1West.setX(150);
		aisle1West.setY(135);
		aisle1West.setWidth(5);
		aisle1West.setHeight(240);
		
		
		
		desk.setSpriteFile(globalvariables.constants.IMAGE_LOCATION+"achmereinterior\\achmeresdesk.bmp");
		aisle1.setSpriteFile(globalvariables.constants.IMAGE_LOCATION+"achmereinterior\\aisle1.bmp");
		aisle2.setSpriteFile(globalvariables.constants.IMAGE_LOCATION+"achmereinterior\\aisle1.bmp");
		
		desk.setX(484);
		desk.setY(130);
		desk.addImagePolicy(new TransparencyPolicy(0xFFFA45EC));
		
		aisle1.setX(126);
		aisle1.setY(130);
		aisle1.addImagePolicy(new TransparencyPolicy(0xFFFA45EC));
		
		aisle2.setX(261);
		aisle2.setY(130);
		aisle2.addImagePolicy(new TransparencyPolicy(0xFFFA45EC));
		
		achmere.setX(584);
		achmere.setY(300);
		achmere.setInternalState(IGameObject.InternalObjectStates.DEFAULT_STATE);
		
		background.setSpriteFile(globalvariables.constants.IMAGE_LOCATION+"achmereinterior\\achmierinterior.bmp");
		
		
		IBarrierObject westBarrier = new BarrierObject();
		westBarrier.setX(ScreenSettings.getInstance().getResWide() - 10);
		westBarrier.setY(0);
		westBarrier.setWidth(10);
		westBarrier.setHeight(ScreenSettings.getInstance().getResHeight());
		
		IBarrierObject eastBarrier = new BarrierObject();
		eastBarrier.setX(0);
		eastBarrier.setY(0);
		eastBarrier.setWidth(10);
		eastBarrier.setHeight(ScreenSettings.getInstance().getResHeight());
		
		IBarrierObject northBarrier = new BarrierObject();
		northBarrier.setX(0);
		northBarrier.setY(126);
		northBarrier.setWidth(ScreenSettings.getInstance().getResWide());
		northBarrier.setHeight(10);
		
		ITrigger warpDungeon = new DungeonRoomTrigger(".\\rooms\\testdungeon.dgn", new Point(300, 100), 9);
		warpDungeon.setX(0);
		warpDungeon.setY(ScreenSettings.getInstance().getResHeight() - 10);
		warpDungeon.setWidth(ScreenSettings.getInstance().getResWide());
		warpDungeon.setHeight(10);
		addTrigger(warpDungeon);
		addObject(northBarrier);
		addObject(eastBarrier);
		addObject(westBarrier);
		
		addObject(aisle1North);
		addObject(aisle1East);
		addObject(aisle1South);
		addObject(aisle1West);
		
		addObject(aisle2North);
		addObject(aisle2East);
		addObject(aisle2South);
		addObject(aisle2West);
		
		addObject(counterNorth);
		
		addObject(background);
		addObject(desk);
		addObject(aisle1);
		addObject(aisle2);
		
		addObject(achmere);
		addObject(beerCooler);
		addObject(wineCooler);
		addObject(dewCooler);
		

	}
}
