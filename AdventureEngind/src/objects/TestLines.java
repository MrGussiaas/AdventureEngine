package objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

public class TestLines extends ConcreteDrawableObject {

	@Override
	public Image createImage() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		int height = 15;
		int width = 15;
		BufferedImage bufImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);;
		Graphics g = bufImage.getGraphics();
		g.setColor(Color.black);
		
		g.fillRect((int)getX(), (int)getY(), width, height);

		g.setColor(Color.GREEN);
		g.drawRect(2, 2, 2, 2);
		g.setColor(Color.RED);
		g.drawLine(8, 5, 3, 2);
		g.setColor(Color.WHITE);
		return bufImage;
	}

	@Override
	public double getHeight() {
		// TODO Auto-generated method stub
		return 100;
	}

	@Override
	public double getWidth() {
		// TODO Auto-generated method stub
		return 100;
	}

}
