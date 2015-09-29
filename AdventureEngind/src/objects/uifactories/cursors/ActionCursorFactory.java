package objects.uifactories.cursors;

import io.IIOHandler.InternalStates;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import objects.IGameObject;
import objects.uifactories.ICursorFactory;
import ui.IGameModel;

public class ActionCursorFactory implements ICursorFactory {

	private Cursor cursor;
	
	public ActionCursorFactory(){
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		BufferedImage answer;
		try {
			answer = ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"actionIcon.gif"));
			Graphics g = answer.getGraphics();
			g.setColor(Color.RED);
			g.drawLine(4, 2, 4, 2);
			cursor = toolkit.createCustomCursor(answer, new Point(4, 2), "test");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		
	}
	
	
	public Cursor makeCursor(IGameModel model, 
			IGameObject objectClicked) {
		// TODO Auto-generated method stub
		return cursor;
	}

}
