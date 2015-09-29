package objects.prisoninterior;

import objects.ConcreteDrawableObject;
import renderingpolicies.TransparencyPolicy;

public class TourDesk extends ConcreteDrawableObject {
	public TourDesk(){
		super.setSpriteFile(globalvariables.constants.IMAGE_LOCATION+"prisoninterior\\tourdesk.bmp");
		super.addImagePolicy(new TransparencyPolicy(0xFFFA45EC));
	}
}
