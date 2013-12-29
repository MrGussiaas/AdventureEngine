package objects;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import screensettings.ScreenConverterUtils;

public class MessageBoxObject extends ConcreteDrawableObject{
	private static final int CHAR_WIDTH = 10;
	private static final int CHAR_HEIGHT = 10;
	private String message = "";
	//private BufferedImage bufImage = new BufferedImage(0, 0, BufferedImage.TYPE_3BYTE_BGR);;
	private BufferedImage bufImage = null;
	public MessageBoxObject(String message){
		this.message = message;
	}
	
	public Image createImage() {
		String[] messageLines = message.split("\n");
		int greatestLines = 0;
		for(int i = 0, n = messageLines.length; i < n; i++){
			String line = messageLines[i];
			if(line.length() > greatestLines){
				greatestLines = line.length();
			}
			
		}
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		int height = messageLines.length * CHAR_HEIGHT + 50;
		setHeight(height);
		int width = greatestLines * CHAR_WIDTH + 50;
		setWidth(width);
		if(bufImage == null){
			bufImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);;
		}
		Graphics g = bufImage.getGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, width, height);
		g.setColor(Color.WHITE);
		int yStart = 25;
		for(int i = 0, n = messageLines.length; i < n; i++){
			g.drawChars(messageLines[i].toCharArray(), 0, messageLines[i].length(), 25, yStart);
			yStart += CHAR_HEIGHT;
		}
		return bufImage;

	}
	
	/*public Image createImage() {
		String[] messageLines = message.split("\n");
		Font font = new Font(null, Font.PLAIN, 12);
		FontMetrics metrics = new FontMetrics(font);
		
		int height = 1;
		int width = 1;
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
		Rectangle subRowRect = new Rectangle();
		

		return bufImage;

	}*/

	@Override
	public void setSpriteFile(String fileName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getSpriteFile() {
		// TODO Auto-generated method stub
		return null;
	}

}
