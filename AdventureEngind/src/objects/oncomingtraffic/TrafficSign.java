package objects.oncomingtraffic;

import java.io.File;

import objects.ConcreteDrawableObject;

public class TrafficSign extends ConcreteDrawableObject {
	public TrafficSign(){
		super.setSpriteFile(globalvariables.constants.IMAGE_LOCATION+"traffic"+File.separatorChar+"roadSign.bmp");
	}
}
