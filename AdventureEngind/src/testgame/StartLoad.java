package testgame;

import io.ConcreteIOHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;

import objects.CommandHandler;
import ui.ConcreteUIController;
import ui.IGameModel;
import ui.IUIController;
import ui.TestFrame;
import data.IRoom;
import data.IRoomSaverLoader;
import data.ModelConverter;
import data.RoomSaver;

public class StartLoad {
	public static void main(String[] args){
		IRoomSaverLoader saver = new RoomSaver();
		IGameModel testModel = null;
		
		try {
			IRoom room = saver.loadRoom("."+File.separatorChar+"rooms"+File.separatorChar+"room2.rom");
			testModel = ModelConverter.getInstance().convertRoomToModel(room);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		TestFrame frame = new TestFrame();
		IUIController controller = new ConcreteUIController(frame);
		controller.setModel(testModel);
		//frame.removeAll();
		frame.setVisible(true);
		frame.setTitle("test game");
		ConcreteIOHandler handler = new ConcreteIOHandler();
		CommandHandler nextHandler = new CommandHandler();
		nextHandler.setController(controller);
		handler.addForwardHandler(nextHandler);
		handler.setController(controller);
		frame.addIIOHandler(handler);;
		
		controller.refreshView();
		frame.setBounds(0,0,300, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.refresh(controller.getView());

	}
}	
