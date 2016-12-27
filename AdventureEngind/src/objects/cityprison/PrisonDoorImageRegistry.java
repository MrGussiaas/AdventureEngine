package objects.cityprison;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import objects.IGameObject;
import objects.outsideachmeres.AchmeresDoorImageRegistry;
import renderingpolicies.IImagePolicy;
import renderingpolicies.TransparencyPolicy;

public class PrisonDoorImageRegistry {
	private static  PrisonDoorImageRegistry instance;
	private Map<IGameObject.InternalObjectStates, Image> imageMap = new HashMap<IGameObject.InternalObjectStates, Image>(10);
	
	public static PrisonDoorImageRegistry getInstance(){
		if(instance == null){
			instance = new PrisonDoorImageRegistry();
		}
		return instance;
	}
	
	public Image getImage(IGameObject.InternalObjectStates state){
		return imageMap.get(state);
	}
	
	private PrisonDoorImageRegistry(){
		try {
			IImagePolicy transparency = new TransparencyPolicy(0xFFFA45EC);
			BufferedImage closed = (BufferedImage) transparency.renderImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"cityprison"+File.separatorChar+"prisondoorClosed.bmp")));
			imageMap.put(IGameObject.InternalObjectStates.CLOSED, closed);
			BufferedImage open = (BufferedImage) transparency.renderImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"cityprison"+File.separatorChar+"prisondoorOpen.bmp")));
			imageMap.put(IGameObject.InternalObjectStates.OPEN, open);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
