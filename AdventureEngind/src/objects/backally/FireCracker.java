package objects.backally;

import java.awt.Image;

import objects.ConcreteDrawableObject;
import ui.FireCrackerImageMaker;

public class FireCracker extends ConcreteDrawableObject {

	private int cyclecount;
	@Override
	public Image createImage() {
		Image image = FireCrackerImageMaker.getInstance().getImage(getInternalState(), cyclecount);
		setHeight(image.getHeight(null));
		setWidth(image.getWidth(null));
		return image;
	}

	@Override
	public void update() {
		
		cyclecount++;
	}

}
