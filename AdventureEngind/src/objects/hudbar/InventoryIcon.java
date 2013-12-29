package objects.hudbar;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import objects.ConcreteDrawableObject;
import objects.IGameObject;
import objects.IInterfaceableObject;

public class InventoryIcon extends ConcreteDrawableObject implements IInterfaceableObject{
	private BufferedImage bufImage;
	private BufferedImage upStateImage; 
	private BufferedImage downStateImage;
	private BufferedImage currentImage;
	private boolean isPressed;
	
	public InventoryIcon(){
		try {
			upStateImage = ImageIO.read(new File(".\\images\\inventoryIcon.bmp"));
			downStateImage = ImageIO.read(new File(".\\images\\inventoryIconUp.bmp"));
			currentImage = upStateImage;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public double getZIndex() {
		return 99;
	}
	
	public Image createImage() {
		return currentImage;
	}

	@Override
	public void mouseLeft() {
		currentImage = downStateImage;
		
	}

	@Override
	public void mouseUp() {
		currentImage = upStateImage;
		
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
