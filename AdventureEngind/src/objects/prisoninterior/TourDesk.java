package objects.prisoninterior;

import java.io.File;

import objects.ConcreteDrawableObject;
import renderingpolicies.TransparencyPolicy;

public class TourDesk extends ConcreteDrawableObject {
	public TourDesk(){
		super.setSpriteFile(globalvariables.constants.IMAGE_LOCATION+"prisoninterio"+File.separatorChar+"tourdesk.bmp");
		super.addImagePolicy(new TransparencyPolicy(0xFFFA45EC));
	}
}
