package objects.optiondialogue;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.JOptionPane;

import objects.ConcreteDrawableObject;
import objects.IInterfaceableObject;
import objects.hoverbutton.HoverButton;
import objects.savegamedialoge.IListCel;
import objects.savegamedialoge.ISelectionListener;
import screensettings.ScreenConverterUtils;
import screensettings.ScreenSettings;

public class OptionDialogue extends ConcreteDrawableObject implements
		IInterfaceableObject, ISelectionListener {
	private static final int CHAR_WIDTH = 10;
	private static final int CHAR_HEIGHT = 10;
	public OptionDialogue(String[] options, String message) {
		super();
		String[] messageLines = message.split("\n");
		int greatestLines = 0;
		for(int i = 0, n = messageLines.length; i < n; i++){
			String line = messageLines[i];
			if(line.length() > greatestLines){
				greatestLines = line.length();
			}
			
		}
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		int height = (messageLines.length * CHAR_HEIGHT ) + (options.length * CHAR_HEIGHT + 50);
		setHeight(height);
		int width = greatestLines * CHAR_WIDTH + 50;
		setWidth(width);
		setHeight(height);
		Point center = ScreenConverterUtils.computeCenter(ScreenSettings.getInstance(), this);
		setX(center.getX());
		setY(center.getY());
		this.options = new HoverButton[options.length];
		for(int i = 0, n = this.options.length; i < n; i++){
			this.options[i]= new HoverButton(options[i], i);
			addContainedObject(this.options[i]);
			this.options[i].addSelectionListener(this);
		}
		this.message = message;
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
		g.setColor(Color.BLACK);
		int yStart = 25;
		String[] messageLines = message.split("\n");
		for(int i = 0, n = messageLines.length; i < n; i++){
			g.drawChars(messageLines[i].toCharArray(), 0, messageLines[i].length(), 25, yStart);
			yStart += CHAR_HEIGHT;
		}
		
		for(int i = 0, n = options.length; i < n; i++){
			Image image = options[i].createImage();
			options[i].setX(25);
			options[i].setY(yStart);
			options[i].setWidth(image.getWidth(null));
			options[i].setHeight(image.getHeight(null));
			g.drawImage(image, 25, yStart, null);
			yStart += image.getHeight(null) + 5;
		}
		
		return bufImage;
	}

	private HoverButton[] options;
	private String message;
	private Object value;
	
	
	
	
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
		return value;
	}

	@Override
	public void setValue(Object object) {
		this.value = object;

	}

	@Override
	public void mouseEntered() {
		
		
	}

	@Override
	public void mouseExited() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectionChanged(IListCel cel) {
		setValue(cel.getValue());
		
	}

}
