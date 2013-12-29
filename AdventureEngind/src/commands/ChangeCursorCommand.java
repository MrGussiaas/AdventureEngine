package commands;

import io.IInputEvent;
import io.RightClickEvent;

import java.awt.Cursor;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ui.IUIController;
import ui.TestFrame;

public class ChangeCursorCommand implements IOCommand {

	private int cycle = 0;
	private List<Cursor> cursors = new ArrayList<Cursor>(10);
	
	public ChangeCursorCommand(){
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image walkCursorImage = toolkit.getImage(".\\images\\walkIcon.gif");
		Image lookCursorImage = toolkit.getImage(".\\images\\lookIcon.gif");
		Image talkCursorImage = toolkit.getImage(".\\images\\talkIcon.gif");
		Image actionCursorImage = toolkit.getImage(".\\images\\actionIcon.gif");
		
		
		Cursor walkCursor = toolkit.createCustomCursor(walkCursorImage, new Point(0, 0), "test");
		Cursor lookCursor = toolkit.createCustomCursor(lookCursorImage, new Point(0, 0), "test");
		Cursor talkCursor = toolkit.createCustomCursor(talkCursorImage, new Point(0, 0), "test");
		Cursor actionCursor = toolkit.createCustomCursor(actionCursorImage, new Point(0, 0), "test");
		
		cursors.add(walkCursor);
		cursors.add(lookCursor);
		cursors.add(talkCursor);
		cursors.add(actionCursor);
	}
	
	public void runCommand(IUIController controller, IInputEvent event) {
		RightClickEvent castedEvent = (RightClickEvent) event;
		cycle ++;
		TestFrame frame = castedEvent.getFrame();
		frame.setCursor(cursors.get(new Integer(cycle % cursors.size())));

	}

}
