package objects.inventorywindow;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import objects.IDrawableObject;
import objects.savegamedialoge.ListCel;

public class ImageCel extends ListCel {

	
	public Image createImage() {
		Object value = super.getValue();
		BufferedImage buff = new BufferedImage((int)getWidth(), (int)getHeight(), BufferedImage.TYPE_3BYTE_BGR);
		int width = (int) getWidth();
		int height = (int) getHeight();
		Graphics g = buff.getGraphics();
		IDrawableObject castedObject = (IDrawableObject) value;
		Image img = castedObject.createImage();
		g.drawImage(img, 0, 0, width, height, 0, 0, img.getWidth(null), img.getHeight(null), null);
		if(isSelected()){
			g.setColor(Color.blue);
			g.drawRect(0, 0, width, height);
		}
		return buff;
	}
	
}
