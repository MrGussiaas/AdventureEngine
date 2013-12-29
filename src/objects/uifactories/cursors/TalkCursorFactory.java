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

public class TalkCursorFactory implements ICursorFactory {

	private Cursor cursor;
	
	public TalkCursorFactory(){
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		BufferedImage answer;
		try {
			answer = ImageIO.read(new File(".\\images\\talkIcon.gif"));
			Graphics g = answer.getGraphics();
			g.setColor(Color.RED);
			g.drawLine(13, 14, 13, 14);
			cursor = toolkit.createCustomCursor(answer, new Point(13, 14), "test");
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
