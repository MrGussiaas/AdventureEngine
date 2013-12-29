package ui;

import io.DefaultImageMaker;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import objects.IGameObject;

public class AvatarImageMaker {
	private static AvatarImageMaker instance;
	private Map<IGameObject.InternalObjectStates, IImageMaker> imageCycles = new HashMap<IGameObject.InternalObjectStates, IImageMaker>(10);
	
	public static AvatarImageMaker getInstance(){
		if(instance == null){
			instance = new AvatarImageMaker();
		}
		return instance;
	}
	
	public IImageMaker getImageMaker(IGameObject.InternalObjectStates state){
		return imageCycles.get(state);
		


		
	}
	
	private AvatarImageMaker(){
		try {
			IImageMaker imageMaker = new ImageMaker();
			IImageMaker hitByTruckMaker = new ImageMaker();
			IImageMaker deadFromTruckMaker = new ImageMaker();
			IImageMaker shotByGunMaker = new ImageMaker();
			IImageMaker deadFromGunMaker = new ImageMaker();
			
			
			BufferedImage bufImage = ImageIO.read(new File(".\\images\\avatardown1.bmp"));
			imageMaker.addDyPosImage(bufImage);
			IImageMaker defaultMaker = new DefaultImageMaker(bufImage);
			bufImage = ImageIO.read(new File(".\\images\\avatardown2.bmp"));
			imageMaker.addDyPosImage(bufImage);
			bufImage = ImageIO.read(new File(".\\images\\avatardown1.bmp"));
			imageMaker.addDyPosImage(bufImage);
			bufImage = ImageIO.read(new File(".\\images\\avatardown3.bmp"));
			imageMaker.addDyPosImage(bufImage);
			
			bufImage = ImageIO.read(new File(".\\images\\avatarright1.bmp"));
			imageMaker.addDxPosImage(bufImage);
			bufImage = ImageIO.read(new File(".\\images\\avatarright2.bmp"));
			imageMaker.addDxPosImage(bufImage);
			bufImage = ImageIO.read(new File(".\\images\\avatarright1.bmp"));
			imageMaker.addDxPosImage(bufImage);
			bufImage = ImageIO.read(new File(".\\images\\avatarright3.bmp"));
			imageMaker.addDxPosImage(bufImage);
			
			bufImage = ImageIO.read(new File(".\\images\\avatarup1.bmp"));
			imageMaker.addDyNegImage(bufImage);
			bufImage = ImageIO.read(new File(".\\images\\avatarup2.bmp"));
			imageMaker.addDyNegImage(bufImage);
			bufImage = ImageIO.read(new File(".\\images\\avatarup1.bmp"));
			imageMaker.addDyNegImage(bufImage);
			bufImage = ImageIO.read(new File(".\\images\\avatarup3.bmp"));
			imageMaker.addDyNegImage(bufImage);
			
			bufImage = ImageIO.read(new File(".\\images\\avatarleft1.bmp"));
			imageMaker.addDxNegImage(bufImage);
			bufImage = ImageIO.read(new File(".\\images\\avatarleft2.bmp"));
			imageMaker.addDxNegImage(bufImage);
			bufImage = ImageIO.read(new File(".\\images\\avatarleft1.bmp"));
			imageMaker.addDxNegImage(bufImage);
			bufImage = ImageIO.read(new File(".\\images\\avatarleft3.bmp"));
			imageMaker.addDxNegImage(bufImage);
			
			
			//////////////////////hit by truck
			
			bufImage = ImageIO.read(new File(".\\images\\severedheads\\severed1.bmp"));
			hitByTruckMaker.addDyPosImage(bufImage);
			bufImage = ImageIO.read(new File(".\\images\\severedheads\\severed2.bmp"));
			hitByTruckMaker.addDyPosImage(bufImage);
			bufImage = ImageIO.read(new File(".\\images\\severedheads\\severed3.bmp"));
			hitByTruckMaker.addDyPosImage(bufImage);
			bufImage = ImageIO.read(new File(".\\images\\severedheads\\severed4.bmp"));
			hitByTruckMaker.addDyPosImage(bufImage);
			
			bufImage = ImageIO.read(new File(".\\images\\severedheads\\severed1.bmp"));
			hitByTruckMaker.addDxPosImage(bufImage);
			bufImage = ImageIO.read(new File(".\\images\\severedheads\\severed2.bmp"));
			hitByTruckMaker.addDxPosImage(bufImage);
			bufImage = ImageIO.read(new File(".\\images\\severedheads\\severed3.bmp"));
			hitByTruckMaker.addDxPosImage(bufImage);
			bufImage = ImageIO.read(new File(".\\images\\severedheads\\severed4.bmp"));
			hitByTruckMaker.addDxPosImage(bufImage);
			
			bufImage = ImageIO.read(new File(".\\images\\severedheads\\severed1.bmp"));
			hitByTruckMaker.addDyNegImage(bufImage);
			bufImage = ImageIO.read(new File(".\\images\\severedheads\\severed2.bmp"));
			hitByTruckMaker.addDyNegImage(bufImage);
			bufImage = ImageIO.read(new File(".\\images\\severedheads\\severed3.bmp"));
			hitByTruckMaker.addDyNegImage(bufImage);
			bufImage = ImageIO.read(new File(".\\images\\severedheads\\severed4.bmp"));
			hitByTruckMaker.addDyNegImage(bufImage);
			
			bufImage = ImageIO.read(new File(".\\images\\severedheads\\severed1.bmp"));
			hitByTruckMaker.addDxNegImage(bufImage);
			bufImage = ImageIO.read(new File(".\\images\\severedheads\\severed2.bmp"));
			hitByTruckMaker.addDxNegImage(bufImage);
			bufImage = ImageIO.read(new File(".\\images\\severedheads\\severed3.bmp"));
			hitByTruckMaker.addDxNegImage(bufImage);
			bufImage = ImageIO.read(new File(".\\images\\severedheads\\severed4.bmp"));
			hitByTruckMaker.addDxNegImage(bufImage);
			
			///// dead by truck
			
			bufImage = ImageIO.read(new File(".\\images\\severedheads\\severed1.bmp"));
			deadFromTruckMaker.addDxNegImage(bufImage);
			deadFromTruckMaker.addDxPosImage(bufImage);
			deadFromTruckMaker.addDyNegImage(bufImage);
			deadFromTruckMaker.addDyPosImage(bufImage);
			
			// shot by gun
			shotByGunMaker.addDxNegImage(ImageIO.read(new File(".\\images\\avatarbrains\\avatarbrains1.bmp")));
			shotByGunMaker.addDxNegImage(ImageIO.read(new File(".\\images\\avatarbrains\\avatarbrains2.bmp")));
			shotByGunMaker.addDxNegImage(ImageIO.read(new File(".\\images\\avatarbrains\\avatarbrains3.bmp")));
			shotByGunMaker.addDxNegImage(ImageIO.read(new File(".\\images\\avatarbrains\\avatarbrains4.bmp")));
			shotByGunMaker.addDxNegImage(ImageIO.read(new File(".\\images\\avatarbrains\\avatarbrains5.bmp")));
			shotByGunMaker.addDxNegImage(ImageIO.read(new File(".\\images\\avatarbrains\\avatarbrains6.bmp")));
			shotByGunMaker.addDxNegImage(ImageIO.read(new File(".\\images\\avatarbrains\\avatarbrains7.bmp")));
			shotByGunMaker.addDxNegImage(ImageIO.read(new File(".\\images\\avatarbrains\\avatarbrains8.bmp")));
			
			shotByGunMaker.addDxPosImage(ImageIO.read(new File(".\\images\\avatarbrains\\avatarbrains1.bmp")));
			shotByGunMaker.addDxPosImage(ImageIO.read(new File(".\\images\\avatarbrains\\avatarbrains2.bmp")));
			shotByGunMaker.addDxPosImage(ImageIO.read(new File(".\\images\\avatarbrains\\avatarbrains3.bmp")));
			shotByGunMaker.addDxPosImage(ImageIO.read(new File(".\\images\\avatarbrains\\avatarbrains4.bmp")));
			shotByGunMaker.addDxPosImage(ImageIO.read(new File(".\\images\\avatarbrains\\avatarbrains5.bmp")));
			shotByGunMaker.addDxPosImage(ImageIO.read(new File(".\\images\\avatarbrains\\avatarbrains6.bmp")));
			shotByGunMaker.addDxPosImage(ImageIO.read(new File(".\\images\\avatarbrains\\avatarbrains7.bmp")));
			shotByGunMaker.addDxPosImage(ImageIO.read(new File(".\\images\\avatarbrains\\avatarbrains8.bmp")));
			
			shotByGunMaker.addDyNegImage(ImageIO.read(new File(".\\images\\avatarbrains\\avatarbrains1.bmp")));
			shotByGunMaker.addDyNegImage(ImageIO.read(new File(".\\images\\avatarbrains\\avatarbrains2.bmp")));
			shotByGunMaker.addDyNegImage(ImageIO.read(new File(".\\images\\avatarbrains\\avatarbrains3.bmp")));
			shotByGunMaker.addDyNegImage(ImageIO.read(new File(".\\images\\avatarbrains\\avatarbrains4.bmp")));
			shotByGunMaker.addDyNegImage(ImageIO.read(new File(".\\images\\avatarbrains\\avatarbrains5.bmp")));
			shotByGunMaker.addDyNegImage(ImageIO.read(new File(".\\images\\avatarbrains\\avatarbrains6.bmp")));
			shotByGunMaker.addDyNegImage(ImageIO.read(new File(".\\images\\avatarbrains\\avatarbrains7.bmp")));
			shotByGunMaker.addDyNegImage(ImageIO.read(new File(".\\images\\avatarbrains\\avatarbrains8.bmp")));
			
			shotByGunMaker.addDxNegImage(ImageIO.read(new File(".\\images\\avatarbrains\\avatarbrains1.bmp")));
			shotByGunMaker.addDxNegImage(ImageIO.read(new File(".\\images\\avatarbrains\\avatarbrains2.bmp")));
			shotByGunMaker.addDxNegImage(ImageIO.read(new File(".\\images\\avatarbrains\\avatarbrains3.bmp")));
			shotByGunMaker.addDxNegImage(ImageIO.read(new File(".\\images\\avatarbrains\\avatarbrains4.bmp")));
			shotByGunMaker.addDxNegImage(ImageIO.read(new File(".\\images\\avatarbrains\\avatarbrains5.bmp")));
			shotByGunMaker.addDxNegImage(ImageIO.read(new File(".\\images\\avatarbrains\\avatarbrains6.bmp")));
			shotByGunMaker.addDxNegImage(ImageIO.read(new File(".\\images\\avatarbrains\\avatarbrains7.bmp")));
			shotByGunMaker.addDxNegImage(ImageIO.read(new File(".\\images\\avatarbrains\\avatarbrains8.bmp")));
			
			///// dead by gun
			
			bufImage = ImageIO.read(new File(".\\images\\avatarbrains\\poolofblood.bmp"));
			deadFromGunMaker.addDxNegImage(bufImage);
			deadFromGunMaker.addDxPosImage(bufImage);
			deadFromGunMaker.addDyNegImage(bufImage);
			deadFromGunMaker.addDyPosImage(bufImage);
			
			imageCycles.put(IGameObject.InternalObjectStates.WALKING_STATE, imageMaker);
			imageCycles.put(IGameObject.InternalObjectStates.DEFAULT_STATE, defaultMaker);
			imageCycles.put(IGameObject.InternalObjectStates.HIT_BY_A_TRUCK_STATE, hitByTruckMaker);
			imageCycles.put(IGameObject.InternalObjectStates.DEAD_FROM_TRUCK_STATE, deadFromTruckMaker);
			imageCycles.put(IGameObject.InternalObjectStates.SHOT_BY_GUN, shotByGunMaker);
			imageCycles.put(IGameObject.InternalObjectStates.DEAD_FROM_GUN, deadFromGunMaker);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
