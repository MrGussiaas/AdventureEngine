package objects.prisoninterior;

import objects.ConcreteDrawableObject;
import renderingpolicies.TransparencyPolicy;

public class TourDesk extends ConcreteDrawableObject {
	public TourDesk(){
		super.setSpriteFile(".\\images\\prisoninterior\\tourdesk.bmp");
		super.addImagePolicy(new TransparencyPolicy(0xFFFA45EC));
	}
}
