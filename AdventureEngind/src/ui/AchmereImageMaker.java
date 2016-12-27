package ui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import objects.IGameObject;
import renderingpolicies.IImagePolicy;
import renderingpolicies.TransparencyPolicy;

public class AchmereImageMaker {
	private static AchmereImageMaker instance;
	private Map<IGameObject.InternalObjectStates, IImageMaker> imageMakers = new HashMap<IGameObject.InternalObjectStates, IImageMaker>(10);
	
	public static AchmereImageMaker getInstance(){
		if(instance == null){
			instance = new AchmereImageMaker();
		}
		return instance;
	}
	
	private AchmereImageMaker(){
		IImageMaker defaultImageMaker = new ImageMaker();
		IImagePolicy policy = new TransparencyPolicy(0xFFFA45EC);
		
		BufferedImage image1;
		try {
			image1 = (BufferedImage) policy.renderImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"achmereinterior"+File.separatorChar+"achmereNormal.bmp")));
			BufferedImage whistle1 = (BufferedImage) policy.renderImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"achmereinterior"+File.separatorChar+"achmereWhistle1.bmp")));
			BufferedImage whistle2 = (BufferedImage) policy.renderImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"achmereinterior"+File.separatorChar+"achmereWhistle2.bmp")));
			BufferedImage whistle3 = (BufferedImage) policy.renderImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"achmereinterior"+File.separatorChar+"achmereWhistle3.bmp")));
			
			defaultImageMaker.addDxNegImage(image1);
			defaultImageMaker.addDxNegImage(image1);
			defaultImageMaker.addDxNegImage(image1);
			defaultImageMaker.addDxNegImage(image1);
			defaultImageMaker.addDxNegImage(image1);
			defaultImageMaker.addDxNegImage(image1);
			defaultImageMaker.addDxNegImage(image1);
			defaultImageMaker.addDxNegImage(image1);
			defaultImageMaker.addDxNegImage(image1);
			defaultImageMaker.addDxNegImage(image1);
			defaultImageMaker.addDxNegImage(image1);
			defaultImageMaker.addDxNegImage(image1);
			defaultImageMaker.addDxNegImage(image1);
			defaultImageMaker.addDxNegImage(image1);
			defaultImageMaker.addDxNegImage(image1);
			defaultImageMaker.addDxNegImage(image1);
			defaultImageMaker.addDxNegImage(whistle1);
			defaultImageMaker.addDxNegImage(whistle2);
			defaultImageMaker.addDxNegImage(whistle3);
			defaultImageMaker.addDxNegImage(whistle1);
			defaultImageMaker.addDxNegImage(whistle2);
			defaultImageMaker.addDxNegImage(whistle3);
			
			defaultImageMaker.addDxPosImage(image1);
			defaultImageMaker.addDxPosImage(image1);
			defaultImageMaker.addDxPosImage(image1);
			defaultImageMaker.addDxPosImage(image1);
			defaultImageMaker.addDxPosImage(image1);
			defaultImageMaker.addDxPosImage(image1);
			defaultImageMaker.addDxPosImage(image1);
			defaultImageMaker.addDxPosImage(image1);
			defaultImageMaker.addDxPosImage(image1);
			defaultImageMaker.addDxPosImage(image1);
			defaultImageMaker.addDxPosImage(image1);
			defaultImageMaker.addDxPosImage(image1);
			defaultImageMaker.addDxPosImage(image1);
			defaultImageMaker.addDxPosImage(image1);
			defaultImageMaker.addDxPosImage(image1);
			defaultImageMaker.addDxPosImage(image1);
			defaultImageMaker.addDxPosImage(whistle1);
			defaultImageMaker.addDxPosImage(whistle2);
			defaultImageMaker.addDxPosImage(whistle3);
			defaultImageMaker.addDxPosImage(whistle1);
			defaultImageMaker.addDxPosImage(whistle2);
			defaultImageMaker.addDxPosImage(whistle3);
			
			defaultImageMaker.addDyPosImage(image1);
			defaultImageMaker.addDyPosImage(image1);
			defaultImageMaker.addDyPosImage(image1);
			defaultImageMaker.addDyPosImage(image1);
			defaultImageMaker.addDyPosImage(image1);
			defaultImageMaker.addDyPosImage(image1);
			defaultImageMaker.addDyPosImage(image1);
			defaultImageMaker.addDyPosImage(image1);
			defaultImageMaker.addDyPosImage(image1);
			defaultImageMaker.addDyPosImage(image1);
			defaultImageMaker.addDyPosImage(image1);
			defaultImageMaker.addDyPosImage(image1);
			defaultImageMaker.addDyPosImage(image1);
			defaultImageMaker.addDyPosImage(image1);
			defaultImageMaker.addDyPosImage(image1);
			defaultImageMaker.addDyPosImage(image1);
			defaultImageMaker.addDyPosImage(whistle1);
			defaultImageMaker.addDyPosImage(whistle2);
			defaultImageMaker.addDyPosImage(whistle3);
			defaultImageMaker.addDyPosImage(whistle1);
			defaultImageMaker.addDyPosImage(whistle2);
			defaultImageMaker.addDyPosImage(whistle3);
			
			defaultImageMaker.addDyNegImage(image1);
			defaultImageMaker.addDyNegImage(image1);
			defaultImageMaker.addDyNegImage(image1);
			defaultImageMaker.addDyNegImage(image1);
			defaultImageMaker.addDyNegImage(image1);
			defaultImageMaker.addDyNegImage(image1);
			defaultImageMaker.addDyNegImage(image1);
			defaultImageMaker.addDyNegImage(image1);
			defaultImageMaker.addDyNegImage(image1);
			defaultImageMaker.addDyNegImage(image1);
			defaultImageMaker.addDyNegImage(image1);
			defaultImageMaker.addDyNegImage(image1);
			defaultImageMaker.addDyNegImage(image1);
			defaultImageMaker.addDyNegImage(image1);
			defaultImageMaker.addDyNegImage(image1);
			defaultImageMaker.addDyNegImage(image1);
			defaultImageMaker.addDyNegImage(whistle1);
			defaultImageMaker.addDyNegImage(whistle2);
			defaultImageMaker.addDyNegImage(whistle3);
			defaultImageMaker.addDyNegImage(whistle1);
			defaultImageMaker.addDyNegImage(whistle2);
			defaultImageMaker.addDyNegImage(whistle3);
			
			imageMakers.put(IGameObject.InternalObjectStates.DEFAULT_STATE, defaultImageMaker);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public IImageMaker getMaker(IGameObject.InternalObjectStates gameState){
		IImageMaker answer= imageMakers.get(gameState);
		return answer;
	}
}
