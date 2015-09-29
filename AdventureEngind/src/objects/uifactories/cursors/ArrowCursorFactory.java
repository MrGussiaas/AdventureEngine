package objects.uifactories.cursors;

import io.IIOHandler.InternalStates;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import objects.IGameObject;
import objects.uifactories.ICursorFactory;
import ui.IGameModel;

public class ArrowCursorFactory implements ICursorFactory {

	private Cursor cursor;
	
	public ArrowCursorFactory(){
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image arrowCursorImage = toolkit.getImage(globalvariables.constants.IMAGE_LOCATION+"arrowIcon.gif");
		cursor = toolkit.createCustomCursor(arrowCursorImage, new Point(0, 0), "test");
	}
	
	public Cursor makeCursor(IGameModel model, 
			IGameObject objectClicked) {
		// TODO Auto-generated method stub
		return cursor;
	}

}
