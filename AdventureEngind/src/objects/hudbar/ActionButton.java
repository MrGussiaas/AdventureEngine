package objects.hudbar;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import objects.ConcreteDrawableObject;
import objects.IInterfaceableObject;

public class ActionButton extends ConcreteDrawableObject implements IInterfaceableObject {
	private BufferedImage upStateImage; 
	private BufferedImage downStateImage;
	private BufferedImage currentImage;
	private boolean isPressed;
	
	public ActionButton(){
		try {
			upStateImage = ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"actionIcon.bmp"));
			downStateImage = ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"actionIconUp.bmp"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		currentImage = upStateImage;
		
	}
	
	public Image createImage() {
		return currentImage;
	}

	@Override
	public void mouseLeft() {
		currentImage = downStateImage;
		
	}
	
	public double getZIndex() {
		return 99;
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
