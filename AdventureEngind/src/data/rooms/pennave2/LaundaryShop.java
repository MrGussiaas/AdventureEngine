package data.rooms.pennave2;

import java.awt.Graphics;
import java.awt.Image;

import objects.ConcreteDrawableObject;
import objects.IDrawableObject;
import objects.IGameObject;
import renderingpolicies.TransparencyPolicy;
import scripts.IScriptRunner;
import scripts.IScriptableObject;

public class LaundaryShop extends ConcreteDrawableObject implements
		IScriptableObject {
	private IDrawableObject door = new ShopDoor();
	private IDrawableObject window1 = new ShopWindow();
	private IDrawableObject window2 = new ShopWindow();
	private IDrawableObject sign = new LaunderySign();
	public LaundaryShop(){
		super.setSpriteFile(globalvariables.constants.IMAGE_LOCATION+"penn2\\laundaryBuilding.bmp");
		addContainedObject(door);
		addContainedObject(window1);
		addContainedObject(window2);
		addContainedObject(sign);
		
		sign.addImagePolicy(new TransparencyPolicy(0xFFFA45EC));
		
		door.setX(51);
		door.setY(101);
		sign.setX(0);
		sign.setY(0);
		
		window1.setX(10);
		window1.setY(30);
		
		window2.setX(91);
		window2.setY(30);
	}
	public IScriptRunner getActionScript() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IScriptRunner getLookScript() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IScriptRunner getTalkScript(IGameObject object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IScriptRunner getItmScript(IGameObject object) {
		// TODO Auto-generated method stub
		return null;
	}
	
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
