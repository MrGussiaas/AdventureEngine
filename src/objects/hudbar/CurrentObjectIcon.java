package objects.hudbar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import objects.ConcreteDrawableObject;
import objects.IDrawableObject;
import objects.IGameObject;
import objects.IInterfaceableObject;

public class CurrentObjectIcon extends ConcreteDrawableObject implements IInterfaceableObject {

	private IDrawableObject inventoryItem;
	public Image createImage() {
		if(inventoryItem == null){
			BufferedImage bufImage = new BufferedImage((int)getWidth(), (int)getHeight(), BufferedImage.TYPE_3BYTE_BGR);;
			Graphics g = bufImage.getGraphics();
			g.setColor(Color.black);
			return bufImage;
		}
		else
			return inventoryItem.createImage();
		
	}
	
	public double getZIndex() {
		return 99;
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
		return inventoryItem;
	}

	@Override
	public void setValue(Object object) {
		this.inventoryItem = (IDrawableObject) object;
		
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
