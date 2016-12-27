package objects.prisoninterior;

import java.io.File;

import objects.ConcreteDrawableObject;
import renderingpolicies.TransparencyPolicy;

public class TourSign extends ConcreteDrawableObject {
	public TourSign(){
		super.setSpriteFile(globalvariables.constants.IMAGE_LOCATION+"prisoninterior"+File.separatorChar+"toursign.bmp");
		super.addImagePolicy(new TransparencyPolicy(0xFFFA45EC));
		
	}

	@Override
	public double getZIndex() {
		return 100000;
	}
}
