package testgame;

import io.ConcreteIOHandler;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import data.ConcreteRoom;
import data.IRoom;
import data.IRoomSaverLoader;
import data.ModelConverter;
import data.RoomSaver;
import objects.BarrierObject;
import objects.CommandHandler;
import objects.IBarrierObject;
import objects.IGameObject;
import objects.TestLines;
import ui.ConcreteGameModel;
import ui.ConcreteUIController;
import ui.ConcreteView;
import ui.IGameModel;
import ui.IUIController;
import ui.TestFrame;

public class Start {
	
	
	
	public static void main(String[] args){
		IGameModel testModel = new ConcreteGameModel();
		SnackDesk keyobject = new SnackDesk();
		keyobject.setX(50);
		keyobject.setY(200);
		keyobject.setHeight(32);
		keyobject.setWidth(64);
		
		IGameObject avatar = new AvatarObject();
		IBarrierObject block = new BarrierObject();
		block.setX(keyobject.getX());
		block.setY(keyobject.getY() +keyobject.getHeight() - 3);
		block.setWidth(keyobject.getWidth());
		block.setHeight(10);
		IGameObject testDraw = new TestLines();
		testDraw.setHeight(100);
		testDraw.setWidth(1000);
		testDraw.setX(0);
		testDraw.setY(0);
		testModel.addObject(testDraw);
		testModel.addObject(block);
		testModel.addObject(keyobject);
		testModel.addObject(avatar);
		testModel.setAvatar(avatar);
		testModel.addBarrier(block);
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
		
		IRoom room = ModelConverter.getInstance().convertModelToRoom(testModel);
		IRoomSaverLoader saver = new RoomSaver();
		try {
			saver.saveRoom(room, "."+File.separatorChar+"rooms"+File.separatorChar+"room2.rom");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
