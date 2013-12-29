package objects.hudbar;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import objects.ConcreteDrawableObject;
import objects.IInterfaceableObject;

public class StatusIcon extends ConcreteDrawableObject implements IInterfaceableObject{
	private BufferedImage bufImage;
	private BufferedImage upStateImage;
	private BufferedImage downStateImage;
	public StatusIcon(){
		try {
			upStateImage = ImageIO.read(new File(".\\images\\statusIcon.bmp"));
			downStateImage = ImageIO.read(new File(".\\images\\statusIconUp.bmp"));
			bufImage = upStateImage;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Image createImage() {

		return bufImage;
	}
	
	public double getZIndex() {
		return 99;
	}

	@Override
	public void mouseLeft() {
		bufImage = downStateImage;
		
	}

	@Override
	public void mouseUp() {
		bufImage = upStateImage;
		
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
