package objects.hudbar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import org.w3c.dom.css.Rect;

import objects.ConcreteDrawableObject;
import objects.IDrawableObject;
import objects.IGameObject;
import objects.IInterfaceableObject;
import screensettings.ScreenConverterUtils;
import screensettings.ScreenSettings;

public class HudBar extends ConcreteDrawableObject implements IInterfaceableObject{
	@Override
	public double getZIndex() {
		return 5000;
	}

	private IGameObject walkIcon = new WalkButton();
	private IGameObject lookIcon = new LookIcon();
	private IGameObject talkIcon = new TalkIcon();
	private IGameObject currentObject = new CurrentObjectIcon();
	private IGameObject inventoryObject = new InventoryIcon();
	private IGameObject statusIcon = new StatusIcon();
	private IGameObject actionIcon = new ActionButton();
	private IGameObject selectedObject;
	
	private static IGameObject instance;
	
	public static IGameObject getInstance(){
		if(instance == null){
			instance = new HudBar();
		}
		return instance;
	}
	
	public void setInventoryObject(IGameObject object){
		IInterfaceableObject casted = (IInterfaceableObject) currentObject;
		casted.setValue(object);
	}
	
	private HudBar(){
		setWidth(ScreenSettings.getInstance().getResWide());
		setHeight(50);
		int iconWidth = ScreenSettings.getInstance().getResWide() / 7;
		int iconHeight = 50;
		int offSet = 0;
		walkIcon.setWidth(iconWidth);
		walkIcon.setHeight(iconHeight);
		walkIcon.setX(offSet);
		offSet+=iconWidth;
		
		lookIcon.setWidth(iconWidth);
		lookIcon.setHeight(iconHeight);
		lookIcon.setX(offSet);
		offSet+=iconWidth;
		
		talkIcon.setWidth(iconWidth);
		talkIcon.setHeight(iconHeight);
		talkIcon.setX(offSet);
		offSet+=iconWidth;
		
		actionIcon.setWidth(iconWidth);
		actionIcon.setHeight(iconHeight);
		actionIcon.setX(offSet);
		offSet+=iconWidth;
		
		currentObject.setWidth(iconWidth);
		currentObject.setHeight(iconHeight);
		currentObject.setX(offSet);
		offSet+=iconWidth;
		
		inventoryObject.setWidth(iconWidth);
		inventoryObject.setHeight(iconHeight);
		inventoryObject.setX(offSet);
		offSet+=iconWidth;
		
		statusIcon.setWidth(iconWidth);
		statusIcon.setHeight(iconHeight);
		statusIcon.setX(offSet);
		offSet+=iconWidth;
		
		addContainedObject(walkIcon);
		addContainedObject(lookIcon);
		addContainedObject(talkIcon);
		addContainedObject(actionIcon);
		addContainedObject(currentObject);
		addContainedObject(inventoryObject);
		addContainedObject(statusIcon);
		
	}
	@Override
	public Image createImage() {
		BufferedImage bufImage = new BufferedImage((int)getWidth(), (int)getHeight(), BufferedImage.TYPE_3BYTE_BGR);;
		

		Graphics graphics = bufImage.getGraphics();
		for(int i = 0, n = getContainedObjectsCount(); i < n; i++){
			IDrawableObject object = (IDrawableObject) getContainedObject(i);
			int iconWidth = (int) object.getWidth();
			Image objectImage = object.createImage();
			Rectangle rect = ScreenConverterUtils.getScaledDimension(object, ScreenSettings.getInstance());
			graphics.drawImage(objectImage, (int)object.getX(), 0, (int)object.getX() + (int)object.getWidth(), (int)object.getHeight(), 0, 0, (int)(objectImage.getWidth(null)), (int)(objectImage.getHeight(null)), null);

		}
		return bufImage;
	}

	@Override
	public void mouseLeft() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setValue(Object object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited() {
		// TODO Auto-generated method stub
		
	}
}
