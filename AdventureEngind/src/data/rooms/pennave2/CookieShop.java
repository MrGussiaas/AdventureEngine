package data.rooms.pennave2;

import java.awt.Graphics;
import java.awt.Image;

import objects.ConcreteDrawableObject;
import objects.IDrawableObject;
import objects.IGameObject;
import renderingpolicies.TransparencyPolicy;
import scripts.IScriptRunner;
import scripts.IScriptableObject;

public class CookieShop extends ConcreteDrawableObject implements
		IScriptableObject {

	private IDrawableObject sign = new CookieSign();
	private IDrawableObject door = new ShopDoor();
	private IDrawableObject window1 = new ShopWindow();
	private IDrawableObject window2 = new ShopWindow();
	
	public CookieShop(){
		setSpriteFile(globalvariables.constants.IMAGE_LOCATION+"penn2\\cookieshop.bmp");
		addContainedObject(sign);
		addContainedObject(door);
		addContainedObject(window1);
		addContainedObject(window2);
		sign.addImagePolicy(new TransparencyPolicy(0xFFFA45EC));
		sign.setX(0);
		sign.setY(0);
		
		door.setX(100);
		door.setY(100);
		sign.setX(0);
		sign.setY(0);
		
		window1.setX(30);
		window1.setY(45);
		
		window2.setX(170);
		window2.setY(45);
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
