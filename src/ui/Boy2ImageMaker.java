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

public class Boy2ImageMaker {
	private static Boy2ImageMaker instance;
	private Map<InternalObjectStates, IImageMaker> imageMakers = new HashMap<InternalObjectStates, IImageMaker>(10);
	public static Boy2ImageMaker getInstance(){
		if(instance == null){
			instance = new Boy2ImageMaker();
		}
		return instance;
		
	}
	
	private Boy2ImageMaker(){
		IImageMaker defaultImageMaker = new ImageMaker();
		IImageMaker walkImageMaker = new ImageMaker();
		IImagePolicy policy = new TransparencyPolicy(0xFFFA45EC);
		try {
			BufferedImage bufImage = (BufferedImage) policy.renderImage(ImageIO.read(new File(".\\images\\backally\\kidkneel1.bmp")));
			defaultImageMaker.addDxNegImage(bufImage);
			defaultImageMaker.addDxPosImage(bufImage);
			defaultImageMaker.addDyNegImage(bufImage);
			defaultImageMaker.addDyPosImage(bufImage);
			imageMakers.put(IGameObject.InternalObjectStates.DEFAULT_STATE, defaultImageMaker);
			
			bufImage = (BufferedImage) policy.renderImage(ImageIO.read(new File(".\\images\\backally\\kidleft1.bmp")));
			walkImageMaker.addDxNegImage(bufImage);
			bufImage = (BufferedImage) policy.renderImage(ImageIO.read(new File(".\\images\\backally\\kidleft2.bmp")));
			walkImageMaker.addDxNegImage(bufImage);
			bufImage = (BufferedImage) policy.renderImage(ImageIO.read(new File(".\\images\\backally\\kidleft1.bmp")));
			walkImageMaker.addDxNegImage(bufImage);
			bufImage = (BufferedImage) policy.renderImage(ImageIO.read(new File(".\\images\\backally\\kidleft3.bmp")));
			walkImageMaker.addDxNegImage(bufImage);
			
			bufImage = (BufferedImage) policy.renderImage(ImageIO.read(new File(".\\images\\backally\\kidright1.bmp")));
			walkImageMaker.addDxPosImage(bufImage);
			bufImage = (BufferedImage) policy.renderImage(ImageIO.read(new File(".\\images\\backally\\kidright2.bmp")));
			walkImageMaker.addDxPosImage(bufImage);
			bufImage = (BufferedImage) policy.renderImage(ImageIO.read(new File(".\\images\\backally\\kidright1.bmp")));
			walkImageMaker.addDxPosImage(bufImage);
			bufImage = (BufferedImage) policy.renderImage(ImageIO.read(new File(".\\images\\backally\\kidright3.bmp")));
			walkImageMaker.addDxPosImage(bufImage);
			
/////////////
			
			bufImage = (BufferedImage) policy.renderImage(ImageIO.read(new File(".\\images\\backally\\kidleft1.bmp")));
			walkImageMaker.addDyNegImage(bufImage);
			bufImage = (BufferedImage) policy.renderImage(ImageIO.read(new File(".\\images\\backally\\kidleft2.bmp")));
			walkImageMaker.addDyNegImage(bufImage);
			bufImage = (BufferedImage) policy.renderImage(ImageIO.read(new File(".\\images\\backally\\kidleft1.bmp")));
			walkImageMaker.addDyNegImage(bufImage);
			bufImage = (BufferedImage) policy.renderImage(ImageIO.read(new File(".\\images\\backally\\kidleft3.bmp")));
			walkImageMaker.addDyNegImage(bufImage);
			
			bufImage = (BufferedImage) policy.renderImage(ImageIO.read(new File(".\\images\\backally\\kidright1.bmp")));
			walkImageMaker.addDyPosImage(bufImage);
			bufImage = (BufferedImage) policy.renderImage(ImageIO.read(new File(".\\images\\backally\\kidright2.bmp")));
			walkImageMaker.addDyPosImage(bufImage);
			bufImage = (BufferedImage) policy.renderImage(ImageIO.read(new File(".\\images\\backally\\kidright1.bmp")));
			walkImageMaker.addDyPosImage(bufImage);
			bufImage = (BufferedImage) policy.renderImage(ImageIO.read(new File(".\\images\\backally\\kidright3.bmp")));
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
