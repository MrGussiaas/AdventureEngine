package objects.uifactories.cursors;

import io.IIOHandler.InternalStates;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import objects.IDrawableObject;
import objects.IGameObject;
import objects.uifactories.ICursorFactory;
import ui.IGameModel;

public class ObjectUseCursorFactory implements ICursorFactory {

	private Cursor cursor;

	
	public ObjectUseCursorFactory(){
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image arrowCursorImage = toolkit.getImage(globalvariables.constants.IMAGE_LOCATION+"arrowIcon.gif");
		cursor = toolkit.createCustomCursor(arrowCursorImage, new Point(0, 0), "test");
	}
	
	public Cursor makeCursor(IGameModel model, 
			IGameObject objectClicked) {
		IGameObject object = model.getActiveInventoryItem();
		if(object == null){
			return cursor;
		}
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		IDrawableObject casted = (IDrawableObject) object;
		Image answer = casted.createImage();
		BufferedImage bufImage = new BufferedImage(32, 32, BufferedImage.TYPE_3BYTE_BGR);;
		Graphics g = bufImage.getGraphics();
		g.drawImage(answer, 0, 0, null);
		g.drawImage(answer, 0, 0, 32, 32, 0, 0, answer.getWidth(null), answer.getHeight(null), null);
		g.setColor(Color.RED);
		Point hotSpot = new Point(31, 31);
		g.fillRect((int)hotSpot.getX(), (int)hotSpot.getY(), (int)hotSpot.getX(), (int)hotSpot.getY());
		
		System.out.println(hotSpot);
		Cursor newCursor = toolkit.createCustomCursor(bufImage, hotSpot, "test");
		return newCursor;
	}

}
