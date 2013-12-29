package testgame;

import io.ConcreteIOHandler;
import io.IIOHandler;
import io.ScriptCommandBridgeIO;
import io.ScriptHandler;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import objects.CommandHandler;
import objects.IDrawableObject;
import objects.IGameObject;
import objects.hudbar.HudBar;
import objects.restoregamedialog.RestoreGameDialog;
import screensettings.ScreenConverterUtils;
import screensettings.ScreenSettings;
import trigger.ITrigger;
import trigger.ITriggerHandler;
import trigger.RestoreGameTrigger;
import trigger.dungeonloaders.DungeonLoaderRegistry;
import trigger.dungeonloaders.IDungeonLoaderProcessor;
import triggerhandlers.IDungeonTriggerManager;
import ui.ConcreteUIController;
import ui.IGameModel;
import ui.IUIController;
import ui.TestFrame;
import data.IDungeon;
import data.IRoom;
import data.IRoomSaverLoader;
import data.ModelConverter;
import data.RoomSaver;

public class MainController  implements ITriggerHandler{
	private IDungeon dungeon = null;
	private IUIController controller = null;
	private ConcreteIOHandler handler = new ConcreteIOHandler();
	private CommandHandler nextHandler = new CommandHandler();
	private ScriptHandler scriptHandler2 = new ScriptHandler();
	private IDungeonTriggerManager dungeonHandler;
	public static void main(String[] args){
		MainController main = new MainController();
		main.start();
	}
	
	public void start(){
		
		
		try {
			
			ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(".\\rooms\\testdungeon.dgn"));
			dungeon = (IDungeon) inputStream.readObject();
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
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		IRoom currentRoom = dungeon.getInitialRoom();
		IGameModel testModel = ModelConverter.getInstance().convertRoomToModel(currentRoom);
		dungeon.setCurrentRoom(currentRoom);
		IDrawableObject avatarObject = new AvatarObject();
		avatarObject.setX(50);
		avatarObject.setY(180);
		avatarObject.setHeight(avatarObject.createImage().getHeight(null));
		avatarObject.setWidth(avatarObject.createImage().getWidth(null));
		int pixelWidth = ScreenConverterUtils.getPixelWidth(ScreenSettings.getInstance());
		int pixelHeight = ScreenConverterUtils.getPixelHeight(ScreenSettings.getInstance());
		testModel.addObject(avatarObject);
		testModel.setAvatar(avatarObject);
		TestFrame frame = new TestFrame();
		controller = new ConcreteUIController(frame);
		controller.setModel(testModel);
		//frame.removeAll();
		frame.setUndecorated(true);
		frame.setVisible(true);
		frame.setTitle("test game");
		
		ConcreteIOHandler handler = new ConcreteIOHandler();
		CommandHandler nextHandler = new CommandHandler();
		ScriptHandler scriptHandler2 = new ScriptHandler();
		scriptHandler2.setController(controller);
		
		IIOHandler scriptHandler = new ScriptCommandBridgeIO(nextHandler, scriptHandler2);
		scriptHandler.setController(controller);
		nextHandler.setController(controller);
		//scriptHandler.setController(controller);
		handler.addForwardHandler(scriptHandler);
		handler.setController(controller);
		frame.addIIOHandler(handler);;
		
		dungeonHandler = new IDungeonTriggerManager(controller, dungeon);
		
		controller.refreshView();
		controller.addITriggerHandler(dungeonHandler);
		controller.addITriggerHandler(this);
		//frame.setBounds(0,0,ScreenSettings.getInstance().getResWide(), ScreenSettings.getInstance().getResHeight());
		frame.setBounds(0,0,(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight());
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.refresh(controller.getView());
	}

	@Override
	public void handleTrigger(ITrigger descriptor) {
		IDungeonLoaderProcessor processor = DungeonLoaderRegistry.getInstance().getProcessor(descriptor.getClass());
		if(processor != null){
			IDungeon currentDungeon = dungeonHandler.getDungeon();
			IDungeon newDungeon = processor.loadNewDungeon(currentDungeon, descriptor);
			IRoom currentRoom = newDungeon.getCurrentRoom();
			IGameModel newModel = ModelConverter.getInstance().convertRoomToModel(currentRoom);
			controller.setModel(newModel);
			dungeonHandler.setDungeon(newDungeon);
		}
	}
}
