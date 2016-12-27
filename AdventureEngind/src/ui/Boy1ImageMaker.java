package ui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import objects.IGameObject;
import objects.IGameObject.InternalObjectStates;
import renderingpolicies.IImagePolicy;
import renderingpolicies.TransparencyPolicy;

public class Boy1ImageMaker {
	private Map<InternalObjectStates, IImageMaker> imageMakers = new HashMap<InternalObjectStates, IImageMaker>(10);
	private static Boy1ImageMaker instance;
	
	public static Boy1ImageMaker getInstance(){
		if(instance == null){
			instance = new Boy1ImageMaker();
		}
		return instance;
		
	}
	
	private Boy1ImageMaker(){
		IImageMaker defaultImageMaker = new ImageMaker();
		IImageMaker walkImageMaker = new ImageMaker();
		IImagePolicy policy = new TransparencyPolicy(0xFFFA45EC);
		try {
			BufferedImage bufImage = (BufferedImage) policy.renderImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"backally"+File.separatorChar+"kidkneel1.bmp")));
			defaultImageMaker.addDxNegImage(bufImage);
			defaultImageMaker.addDxPosImage(bufImage);
			defaultImageMaker.addDyNegImage(bufImage);
			defaultImageMaker.addDyPosImage(bufImage);
			imageMakers.put(IGameObject.InternalObjectStates.DEFAULT_STATE, defaultImageMaker);
			
			bufImage = (BufferedImage) policy.renderImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"backally"+File.separatorChar+"kidleft1.bmp")));
			walkImageMaker.addDxNegImage(bufImage);
			bufImage = (BufferedImage) policy.renderImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"backally"+File.separatorChar+"kidleft2.bmp")));
			walkImageMaker.addDxNegImage(bufImage);
			bufImage = (BufferedImage) policy.renderImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"backally"+File.separatorChar+"kidleft1.bmp")));
			walkImageMaker.addDxNegImage(bufImage);
			bufImage = (BufferedImage) policy.renderImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"backally"+File.separatorChar+"kidleft3.bmp")));
			walkImageMaker.addDxNegImage(bufImage);
			
			bufImage = (BufferedImage) policy.renderImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"backally"+File.separatorChar+"kidrightgreen1.bmp")));
			walkImageMaker.addDxPosImage(bufImage);
			bufImage = (BufferedImage) policy.renderImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"backally"+File.separatorChar+"kidrightgreen2.bmp")));
			walkImageMaker.addDxPosImage(bufImage);
			bufImage = (BufferedImage) policy.renderImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"backally"+File.separatorChar+"kidrightgreen1.bmp")));
			walkImageMaker.addDxPosImage(bufImage);
			bufImage = (BufferedImage) policy.renderImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"backally"+File.separatorChar+"kidrightgreen3.bmp")));
			walkImageMaker.addDxPosImage(bufImage);
			
/////////////
			
			bufImage = (BufferedImage) policy.renderImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"backally"+File.separatorChar+"kidleft1.bmp")));
			walkImageMaker.addDyNegImage(bufImage);
			bufImage = (BufferedImage) policy.renderImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"backally"+File.separatorChar+"kidleft2.bmp")));
			walkImageMaker.addDyNegImage(bufImage);
			bufImage = (BufferedImage) policy.renderImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"backally"+File.separatorChar+"kidleft1.bmp")));
			walkImageMaker.addDyNegImage(bufImage);
			bufImage = (BufferedImage) policy.renderImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"backally"+File.separatorChar+"kidleft3.bmp")));
			walkImageMaker.addDyNegImage(bufImage);
			
			bufImage = (BufferedImage) policy.renderImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"backally"+File.separatorChar+"kidrightgreen1.bmp")));
			walkImageMaker.addDyPosImage(bufImage);
			bufImage = (BufferedImage) policy.renderImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"backally"+File.separatorChar+"kidrightgreen2.bmp")));
			walkImageMaker.addDyPosImage(bufImage);
			bufImage = (BufferedImage) policy.renderImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"backally"+File.separatorChar+"kidrightgreen1.bmp")));
			walkImageMaker.addDyPosImage(bufImage);
			bufImage = (BufferedImage) policy.renderImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"backally"+File.separatorChar+"kidrightgreen3.bmp")));
			walkImageMaker.addDyPosImage(bufImage);
			imageMakers.put(IGameObject.InternalObjectStates.WALKING_STATE, walkImageMaker);
			
			
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public IImageMaker getMaker(IGameObject.InternalObjectStates internalState){
		IImageMaker answer= imageMakers.get(internalState);
		return answer;
	}
}
