package objects.outsideachmeres;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import objects.IGameObject;

public class AchmeresDoorImageRegistry {
	private static  AchmeresDoorImageRegistry instance;
	private Map<IGameObject.InternalObjectStates, Image> imageMap = new HashMap<IGameObject.InternalObjectStates, Image>(10);
	
	public static AchmeresDoorImageRegistry getInstance(){
		if(instance == null){
			instance = new AchmeresDoorImageRegistry();
		}
		return instance;
	}
	
	public Image getImage(IGameObject.InternalObjectStates state){
		return imageMap.get(state);
	}
	
	private AchmeresDoorImageRegistry(){
		try {
			imageMap.put(IGameObject.InternalObjectStates.CLOSED, ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"nineteenth2\\achmeresdoorClosed.bmp")));
			imageMap.put(IGameObject.InternalObjectStates.OPEN, ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"nineteenth2\\achmeresdoorOpen.bmp")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
