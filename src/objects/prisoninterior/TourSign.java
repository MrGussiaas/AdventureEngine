package objects.prisoninterior;

import objects.ConcreteDrawableObject;
import renderingpolicies.TransparencyPolicy;

public class TourSign extends ConcreteDrawableObject {
	public TourSign(){
		super.setSpriteFile(".\\images\\prisoninterior\\toursign.bmp");
		super.addImagePolicy(new TransparencyPolicy(0xFFFA45EC));
		
	}

	@Override
	public double getZIndex() {
		return 100000;
	}
}
