package ui;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import objects.IGameObject;
import renderingpolicies.IImagePolicy;
import renderingpolicies.TransparencyPolicy;

public class FireCrackerImageMaker {
	
	private Map<IGameObject.InternalObjectStates, List<Image>> imageMakers = new HashMap<IGameObject.InternalObjectStates, List<Image>>(10); 
	private static FireCrackerImageMaker instance;
	
	public static FireCrackerImageMaker getInstance(){
		if(instance == null){
			instance = new FireCrackerImageMaker();
		}
		return instance;
	}
	
	private FireCrackerImageMaker(){
		List<Image> defaultImages = new ArrayList<Image>(10);
		List<Image> litImages = new ArrayList<Image>(10);
		List<Image> explodeImages = new ArrayList<Image>(10);
		IImagePolicy policy = new TransparencyPolicy(0xFFFA45EC);
		try {
			BufferedImage bufImage = (BufferedImage) policy.renderImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"backally"+File.separatorChar+"firecrackerunlimit.bmp")));
			defaultImages.add(bufImage);
			imageMakers.put(IGameObject.InternalObjectStates.DEFAULT_STATE, defaultImages);
			
			bufImage = (BufferedImage) policy.renderImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"backally"+File.separatorChar+"firecrackerlimit1.bmp")));
			litImages.add(bufImage);
			bufImage = (BufferedImage) policy.renderImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"backally"+File.separatorChar+"firecrackerlimit2.bmp")));
			litImages.add(bufImage);
			
			imageMakers.put(IGameObject.InternalObjectStates.LIT, litImages);
			
			bufImage = (BufferedImage) policy.renderImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"backally"+File.separatorChar+"firecrackerexplode1.bmp")));
			explodeImages.add(bufImage);
			bufImage = (BufferedImage) policy.renderImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"backally"+File.separatorChar+"firecrackerexplode2.bmp")));
			explodeImages.add(bufImage);
			
			imageMakers.put(IGameObject.InternalObjectStates.EXPLODE, explodeImages);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Image getImage(IGameObject.InternalObjectStates state, int cycle){
		List<Image> answer = imageMakers.get(state);
		return answer.get(cycle % answer.size());
	}
}
