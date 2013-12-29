package objects.gameoverdialog;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import objects.ConcreteDrawableObject;
import objects.IDrawableObject;
import objects.IInterfaceableObject;
import objects.MessageBoxObject;
import objects.settingswindow.QuitButton;
import objects.settingswindow.RestartButton;
import objects.settingswindow.RestoreButton;
import screensettings.ScreenConverterUtils;
import screensettings.ScreenSettings;

public class GameOverDialogue extends ConcreteDrawableObject implements
		IInterfaceableObject {

	private static String[] INSULT_MESSAGE = new String[]{"Thanks for playing [Enter Title Here]","as usual Maverick T Owens is not impressed"};
	private Rectangle vRect = new Rectangle();
	private Rectangle hRect = new Rectangle();
	@Override
	public double getZIndex() {
		return Double.MAX_VALUE;
	}

	private IDrawableObject restore = new RestoreButton("Restore");
	private IDrawableObject quit = new QuitButton("Quit");
	private IDrawableObject restart = new RestartButton("Restart");
	
	public GameOverDialogue(){
		setWidth(350);
		setHeight(110);
		Point center = ScreenConverterUtils.computeCenter(ScreenSettings.getInstance(), this);
		setX(center.getX());
		setY(center.getY());
		addContainedObject(restore);
		addContainedObject(restart);
		addContainedObject(quit);
		int height = (int)getHeight();
		int width = (int)getWidth();
		int rowCount = 2;
		hRect.setBounds(0, 0, width / 3, height / rowCount);
		vRect.setBounds(0, 0, width, height / rowCount);
		Point restoreCenter = ScreenConverterUtils.computeCenter(hRect, restore);
		Point restartCenter = ScreenConverterUtils.computeCenter(hRect, restart);
		Point quitCenter = ScreenConverterUtils.computeCenter(hRect, quit);
		restore.setX(restoreCenter.getX());
		restore.setY(restoreCenter.getY() + vRect.getHeight());
		restart.setX(restartCenter.getX() + (1 * hRect.getWidth() ));
		restart.setY(restartCenter.getY() + vRect.getHeight());
		quit.setX(quitCenter.getX() +( 2 * hRect.getWidth()));
		quit.setY(quitCenter.getY() + vRect.getHeight());
	}
	
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
	public Image createImage() {


		
		
		int height = (int)getHeight();
		int width = (int)getWidth();
		BufferedImage bufImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
		Graphics g = bufImage.getGraphics();

		FontMetrics metrics = g.getFontMetrics();
		
		
		
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, width, height);
		g.setColor(new Color(100, 100, 100));
		
		g.drawLine(0, 0, 0, height);
		g.drawLine(1, 0, 1, height - 1);
		g.drawLine(2, 0, 2, height - 2);
		g.drawLine(0, 0, width, 0);
		g.drawLine(0, 1, width - 1, 1);
		g.drawLine(0, 2, width - 2, 2);
		
		g.setColor(new Color(200, 200, 200));
		
		g.drawLine(width, height, width, 1);
		g.drawLine(width - 1, height, width - 1, 2);
		g.drawLine(width - 2, height, width - 2, 3);
		g.drawLine(width, height, 1, height);
		g.drawLine(width, height - 1, 1, height - 1);
		g.drawLine(width, height - 2, 2, height - 2);
		g.drawImage(restore.createImage(), (int)restore.getX(), (int)restore.getY(), null);
		g.drawImage(quit.createImage(), (int)quit.getX(), (int)quit.getY(), null);
		g.drawImage(restart.createImage(), (int)restart.getX(), (int)restart.getY(), null);
		g.setColor(Color.BLACK);
		Rectangle subRowRect = new Rectangle();
		subRowRect.setBounds(0, 0, (int)vRect.getWidth(), (int) (vRect.getHeight() / INSULT_MESSAGE.length));
		
		for(int i = 0, n = INSULT_MESSAGE.length; i < n; i++){
			String currentMessage = INSULT_MESSAGE[i];
			int charLen = metrics.charsWidth(currentMessage.toCharArray(), 0, currentMessage.length());
			int charHeight = metrics.getHeight();
			Rectangle messageRect = new Rectangle();
			
			messageRect.setBounds(0, 0, charLen, charHeight);
			Point messageCenter = ScreenConverterUtils.computeCenter(subRowRect, messageRect);
			g.drawChars(currentMessage.toCharArray(), 0, currentMessage.length(), (int)messageCenter.getX(), (int)(messageCenter.getY() + (i * subRowRect.getHeight()) + 10));
		}
		return bufImage;
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
