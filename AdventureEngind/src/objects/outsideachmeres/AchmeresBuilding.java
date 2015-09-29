package objects.outsideachmeres;

import java.awt.Graphics;
import java.awt.Image;

import objects.ConcreteDrawableObject;
import objects.IDrawableObject;
import objects.IGameObject;

public class AchmeresBuilding extends ConcreteDrawableObject {
	@Override
	public void update() {
		sign.update();
	}
	private IDrawableObject door = new AchmeresDoor();
	private IDrawableObject sign = new AchmereSign();
	public AchmeresBuilding(){
		setSpriteFile(globalvariables.constants.IMAGE_LOCATION+"nineteenth2\\achmeresBuilding.bmp");
		sign.setX(225);
		sign.setY(22);
		door.setX(245);
		door.setY(145);
		addContainedObject(door);
		addContainedObject(sign);
	}
	@Override
	public Image createImage() {
		// TODO Auto-generated method stub
		Image image = super.createImage();
		Graphics g = image.getGraphics();
		for(int i = 0, n = getContainedObjectsCount(); i < n; i++){
			IDrawableObject containedObject = (IDrawableObject) getContainedObject(i);
			g.drawImage(containedObject.createImage(), (int)containedObject.getX(), (int)containedObject.getY(), null);
		}
		return image;
	}
}
