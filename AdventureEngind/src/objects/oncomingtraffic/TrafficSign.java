package objects.oncomingtraffic;

import objects.ConcreteDrawableObject;

public class TrafficSign extends ConcreteDrawableObject {
	public TrafficSign(){
		super.setSpriteFile(globalvariables.constants.IMAGE_LOCATION+"traffic\\roadSign.bmp");
	}
}
