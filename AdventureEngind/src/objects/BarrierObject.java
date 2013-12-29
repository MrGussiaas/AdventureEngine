package objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

public class BarrierObject extends ConcreteDrawableObject implements
		IDrawableObject, IBarrierObject {

	@Override
	public Image createImage() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		int height = (int) getHeight();
		int width = (int) getWidth();
		BufferedImage bufImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);;
		Graphics g = bufImage.getGraphics();
		g.setColor(Color.RED);
		g.fillRect((int)getX(), (int)getY(), width, height);
		g.setColor(Color.WHITE);
		return null;
	}

}
