package objects.cityprison;

import java.awt.Graphics;
import java.awt.Image;

import objects.ConcreteDrawableObject;
import objects.ConcreteObject;
import objects.IDrawableObject;
import renderingpolicies.TransparencyPolicy;

public class CityPrison extends ConcreteDrawableObject {
	private IDrawableObject prisonDoor = new PrisonDoor();
	private IDrawableObject prisonWindow = new PrisonWindow();
	

	
	public CityPrison(){
		addContainedObject(prisonDoor);
		addContainedObject(prisonWindow);
		prisonDoor.setX(10);
		prisonDoor.setY(150);
		prisonWindow.setX(125);
		prisonWindow.setY(75);
		prisonDoor.addImagePolicy(new TransparencyPolicy(0xFFFA45EC));
		setSpriteFile(globalvariables.constants.IMAGE_LOCATION+"cityprison\\prisonExterior.bmp");

		
	}
	@Override
	public Image createImage() {
		Image image = super.createImage();
		Graphics g = image.getGraphics();
		int parentX = (int)getX();
		int parentY = (int)getY();
		for(int i = 0, n = getContainedObjectsCount(); i < n; i++){
			IDrawableObject containedObject = (IDrawableObject) getContainedObject(i);
			
			
			g.drawImage(containedObject.createImage(), (int)containedObject.getX(), (int)containedObject.getY(), null);
		}
		return image;
	}
}
