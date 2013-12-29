package objects.backally;

import objects.ConcreteDrawableObject;
import renderingpolicies.TransparencyPolicy;

public class AllyCop extends ConcreteDrawableObject {
	public AllyCop(){
		super.addImagePolicy(new TransparencyPolicy(0xFFFA45EC));
		super.setSpriteFile(".\\images\\backally\\cop.bmp");
	}
}
