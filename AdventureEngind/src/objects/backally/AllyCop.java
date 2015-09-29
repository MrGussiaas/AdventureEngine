package objects.backally;

import objects.ConcreteDrawableObject;
import renderingpolicies.TransparencyPolicy;

public class AllyCop extends ConcreteDrawableObject {
	public AllyCop(){
		super.addImagePolicy(new TransparencyPolicy(0xFFFA45EC));
		super.setSpriteFile(globalvariables.constants.IMAGE_LOCATION+"backally\\cop.bmp");
	}
}
