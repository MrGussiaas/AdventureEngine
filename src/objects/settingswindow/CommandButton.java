package objects.settingswindow;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import objects.ConcreteDrawableObject;
import objects.IInterfaceableObject;

public class CommandButton extends ConcreteDrawableObject implements IInterfaceableObject {
	private transient BufferedImage upBackground;
	private transient BufferedImage downImage;
	private boolean isClicked = false;
	private String buttonText;
	
	public CommandButton(){
		buttonText = "";
	}
	
	public CommandButton(String text){
		this.buttonText = text;
		try {
			upBackground = ImageIO.read(new File(".\\images\\commandButtonUp.bmp"));
			downImage = ImageIO.read(new File(".\\images\\commandButtonDown.bmp"));
			setWidth(upBackground.getWidth());
			setHeight(upBackground.getHeight());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public Image createImage() {
		BufferedImage bufImage = new BufferedImage((int)getWidth(), (int)getHeight(), BufferedImage.TYPE_3BYTE_BGR);;
		BufferedImage imageToUse = isClicked ? downImage : upBackground;
		Graphics g = bufImage.getGraphics();
		FontMetrics metrics = g.getFontMetrics();
		int imageLen = metrics.charsWidth(buttonText.toCharArray(), 0, buttonText.length());
		int imageHeight = metrics.getHeight();
		g.drawImage(imageToUse, 0, 0, null);
		int centerX = (int) ((getWidth() / 2) - (imageLen / 2));
		int centerY = (int) ((getHeight() / 2) + (imageHeight / 2));
		g.setColor(Color.BLACK);
		g.drawChars(buttonText.toCharArray(), 0, buttonText.length(), centerX, centerY);
		return bufImage;
	}

	public void mouseLeft() {
		isClicked = true;

	}

	@Override
	public void mouseUp() {
		isClicked = false;

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
