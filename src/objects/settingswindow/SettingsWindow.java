package objects.settingswindow;

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
import screensettings.ScreenSettings;

public class SettingsWindow extends ConcreteDrawableObject implements IInterfaceableObject{
	
	@Override
	public double getZIndex() {
		return Double.MAX_VALUE;
	}
	private static IGameObject instance;
	private BufferedImage backgroundImage;
	private IGameObject saveBtn = new SaveButton("Save");
	private IGameObject restoreBtn = new RestoreButton("Restore");
	private IGameObject cancelBtn = new CancelButton("Cancel");
	private IGameObject quitBtn = new QuitButton("Quit");
	public static IGameObject getinstance(){
		if(instance == null){
			instance = new SettingsWindow();
			
		}
		return instance;
	}
	
	private SettingsWindow(){


		try {
			backgroundImage = ImageIO.read(new File(".\\images\\StatusWindowBackground.bmp"));
			int yOffset = 10;
			
			saveBtn.setX(10);
			saveBtn.setY(yOffset);
			yOffset += saveBtn.getHeight() + 2;
			
			
			restoreBtn.setX(10);
			restoreBtn.setY(yOffset);
			yOffset += restoreBtn.getHeight() + 2;
			
			cancelBtn.setX(10);
			cancelBtn.setY(yOffset);
			yOffset += cancelBtn.getHeight() + 2;
			
			quitBtn.setX(10);
			quitBtn.setY(yOffset);
			
			addContainedObject(saveBtn);
			addContainedObject(restoreBtn);
			addContainedObject(cancelBtn);
			addContainedObject(quitBtn);
		} catch (IOException e) {
			e.printStackTrace();
		}
		super.setWidth(backgroundImage.getWidth());
		super.setHeight(backgroundImage.getHeight());
		super.setX(50);
		super.setY(50);
		int screenWidth = ScreenSettings.getInstance().getResWide();
		int screenHeight = ScreenSettings.getInstance().getResHeight();
		
		int midX = (int) ((screenWidth / 2) - (getWidth() / 2));
		int midY = (int) ((screenHeight / 2) - (getHeight() / 2));
		setX(midX);
		setY(midY);
	}
	public Image createImage() {
		BufferedImage bufImage = new BufferedImage((int)getWidth(), (int)getHeight(), BufferedImage.TYPE_3BYTE_BGR);;
		Graphics graphics = bufImage.getGraphics();
		graphics.drawImage(backgroundImage, 0, 0, null);
		for(int i = 0, n = super.getContainedObjectsCount(); i < n; i++){
			IDrawableObject object = (IDrawableObject) super.getContainedObject(i);
			graphics.drawImage(object.createImage(), (int)object.getX(), (int)object.getY(), null);
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
