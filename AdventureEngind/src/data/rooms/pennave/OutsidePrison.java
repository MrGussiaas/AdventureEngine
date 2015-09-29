package data.rooms.pennave;

import objects.BackgroundObject;
import objects.BarrierObject;
import objects.IBarrierObject;
import objects.IDrawableObject;
import objects.cityprison.CityPrison;
import objects.cityprison.CopCar;
import objects.cityprison.LotFence;
import renderingpolicies.TransparencyPolicy;
import screensettings.ScreenSettings;
import trigger.BottomRoomTrigger;
import trigger.ITrigger;
import trigger.TopRoomTrigger;
import data.ConcreteRoom;

public class OutsidePrison extends ConcreteRoom {
	public OutsidePrison(){
		setId(5);
		
		IDrawableObject prison = new CityPrison();
		IDrawableObject copCar = new CopCar();
		
		copCar.addImagePolicy(new TransparencyPolicy(0xFFFA45EC));
		copCar.setX(0);
		copCar.setY(291);
		prison.setX(300);
		prison.setY(50);
		addObject(prison);
		addObject(copCar);
		
		IDrawableObject lotFence = new LotFence();
		lotFence.addImagePolicy(new TransparencyPolicy(0xFFFA45EC));
		prison.addImagePolicy(new TransparencyPolicy(0xFFFA45EC));
		
		
		lotFence.setX(0);
		lotFence.setY(0);
		addObject(lotFence);
		
		
		IBarrierObject prisonSouthBarrier = new BarrierObject();
		prisonSouthBarrier.setX(ScreenSettings.getInstance().getResWide() - 250);
		prisonSouthBarrier.setY(310);
		prisonSouthBarrier.setWidth(250);
		prisonSouthBarrier.setHeight(10);
		addObject(prisonSouthBarrier);
		
		IBarrierObject prisonWestBarrier = new BarrierObject();
		prisonWestBarrier.setX(ScreenSettings.getInstance().getResWide() - 260);
		prisonWestBarrier.setWidth(10);
		prisonWestBarrier.setY(200);
		prisonWestBarrier.setHeight(120);
		addObject(prisonWestBarrier);
		
		IBarrierObject prisonNorthBarrier = new BarrierObject();
		prisonNorthBarrier.setY(200);
		prisonNorthBarrier.setHeight(10);
		prisonNorthBarrier.setX(ScreenSettings.getInstance().getResWide() - 340);
		prisonNorthBarrier.setWidth(80);
		addObject(prisonNorthBarrier);
		
		IBarrierObject prisonEastBarrier = new BarrierObject();
		prisonEastBarrier.setX(ScreenSettings.getInstance().getResWide() - 340);
		prisonEastBarrier.setWidth(10);
		prisonEastBarrier.setHeight(200);
		prisonEastBarrier.setY(0);
		addObject(prisonEastBarrier);
		
		IBarrierObject SouthBarrier = new BarrierObject();
		IBarrierObject EastBarrier = new BarrierObject();
		IBarrierObject WestBarrier = new BarrierObject();
		IDrawableObject background = new BackgroundObject();
		background.setSpriteFile(globalvariables.constants.IMAGE_LOCATION+"prison\\city_prison.bmp");
		
		SouthBarrier.setX(0);
		SouthBarrier.setY(ScreenSettings.getInstance().getResHeight() - 10);
		SouthBarrier.setHeight(10);
		SouthBarrier.setWidth(ScreenSettings.getInstance().getResWide());
		
		EastBarrier.setX(ScreenSettings.getInstance().getResWide() - 10);
		EastBarrier.setY(0);
		EastBarrier.setWidth(10);
		EastBarrier.setHeight(ScreenSettings.getInstance().getResHeight());
		
		WestBarrier.setX(0);
		WestBarrier.setY(0);
		WestBarrier.setWidth(10);
		WestBarrier.setHeight(ScreenSettings.getInstance().getResHeight());
		
		addObject(SouthBarrier);
		addObject(WestBarrier);
		addObject(EastBarrier);
		addObject(background);
		
		ITrigger topTrigger = new TopRoomTrigger(ScreenSettings.getInstance().getResWide() / 2, ScreenSettings.getInstance().getResHeight() - 100);
		topTrigger.setX(0);
		topTrigger.setY(100);
		topTrigger.setWidth(ScreenSettings.getInstance().getResWide());
		topTrigger.setHeight(10);
		
		addTrigger(topTrigger);
	}
}
