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
			
			
			BufferedImage bufImage = ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"avatardown1.bmp"));
			imageMaker.addDyPosImage(bufImage);
			IImageMaker defaultMaker = new DefaultImageMaker(bufImage);
			bufImage = ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"avatardown2.bmp"));
			imageMaker.addDyPosImage(bufImage);
			bufImage = ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"avatardown1.bmp"));
			imageMaker.addDyPosImage(bufImage);
			bufImage = ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"avatardown3.bmp"));
			imageMaker.addDyPosImage(bufImage);
			
			bufImage = ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"avatarright1.bmp"));
			imageMaker.addDxPosImage(bufImage);
			bufImage = ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"avatarright2.bmp"));
			imageMaker.addDxPosImage(bufImage);
			bufImage = ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"avatarright1.bmp"));
			imageMaker.addDxPosImage(bufImage);
			bufImage = ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"avatarright3.bmp"));
			imageMaker.addDxPosImage(bufImage);
			
			bufImage = ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"avatarup1.bmp"));
			imageMaker.addDyNegImage(bufImage);
			bufImage = ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"avatarup2.bmp"));
			imageMaker.addDyNegImage(bufImage);
			bufImage = ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"avatarup1.bmp"));
			imageMaker.addDyNegImage(bufImage);
			bufImage = ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"avatarup3.bmp"));
			imageMaker.addDyNegImage(bufImage);
			
			bufImage = ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"avatarleft1.bmp"));
			imageMaker.addDxNegImage(bufImage);
			bufImage = ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"avatarleft2.bmp"));
			imageMaker.addDxNegImage(bufImage);
			bufImage = ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"avatarleft1.bmp"));
			imageMaker.addDxNegImage(bufImage);
			bufImage = ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"avatarleft3.bmp"));
			imageMaker.addDxNegImage(bufImage);
			
			
			//////////////////////hit by truck
			
			bufImage = ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"severedheads"+File.separatorChar+"severed1.bmp"));
			hitByTruckMaker.addDyPosImage(bufImage);
			bufImage = ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"severedheads"+File.separatorChar+"severed2.bmp"));
			hitByTruckMaker.addDyPosImage(bufImage);
			bufImage = ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"severedheads"+File.separatorChar+"severed3.bmp"));
			hitByTruckMaker.addDyPosImage(bufImage);
			bufImage = ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"severedheads"+File.separatorChar+"severed4.bmp"));
			hitByTruckMaker.addDyPosImage(bufImage);
			
			bufImage = ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"severedheads"+File.separatorChar+"severed1.bmp"));
			hitByTruckMaker.addDxPosImage(bufImage);
			bufImage = ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"severedheads"+File.separatorChar+"severed2.bmp"));
			hitByTruckMaker.addDxPosImage(bufImage);
			bufImage = ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"severedheads"+File.separatorChar+"severed3.bmp"));
			hitByTruckMaker.addDxPosImage(bufImage);
			bufImage = ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"severedheads"+File.separatorChar+"severed4.bmp"));
			hitByTruckMaker.addDxPosImage(bufImage);
			
			bufImage = ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"severedheads"+File.separatorChar+"severed1.bmp"));
			hitByTruckMaker.addDyNegImage(bufImage);
			bufImage = ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"severedheads"+File.separatorChar+"severed2.bmp"));
			hitByTruckMaker.addDyNegImage(bufImage);
			bufImage = ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"severedheads"+File.separatorChar+"severed3.bmp"));
			hitByTruckMaker.addDyNegImage(bufImage);
			bufImage = ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"severedheads"+File.separatorChar+"severed4.bmp"));
			hitByTruckMaker.addDyNegImage(bufImage);
			
			bufImage = ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"severedheads"+File.separatorChar+"severed1.bmp"));
			hitByTruckMaker.addDxNegImage(bufImage);
			bufImage = ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"severedheads"+File.separatorChar+"severed2.bmp"));
			hitByTruckMaker.addDxNegImage(bufImage);
			bufImage = ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"severedheads"+File.separatorChar+"severed3.bmp"));
			hitByTruckMaker.addDxNegImage(bufImage);
			bufImage = ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"severedheads"+File.separatorChar+"severed4.bmp"));
			hitByTruckMaker.addDxNegImage(bufImage);
			
			///// dead by truck
			
			bufImage = ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"severedheads"+File.separatorChar+"severed1.bmp"));
			deadFromTruckMaker.addDxNegImage(bufImage);
			deadFromTruckMaker.addDxPosImage(bufImage);
			deadFromTruckMaker.addDyNegImage(bufImage);
			deadFromTruckMaker.addDyPosImage(bufImage);
			
			// shot by gun
			shotByGunMaker.addDxNegImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"avatarbrains"+File.separatorChar+"avatarbrains1.bmp")));
			shotByGunMaker.addDxNegImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"avatarbrains"+File.separatorChar+"avatarbrains2.bmp")));
			shotByGunMaker.addDxNegImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"avatarbrains"+File.separatorChar+"avatarbrains3.bmp")));
			shotByGunMaker.addDxNegImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"avatarbrains"+File.separatorChar+"avatarbrains4.bmp")));
			shotByGunMaker.addDxNegImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"avatarbrains"+File.separatorChar+"avatarbrains5.bmp")));
			shotByGunMaker.addDxNegImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"avatarbrains"+File.separatorChar+"avatarbrains6.bmp")));
			shotByGunMaker.addDxNegImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"avatarbrains"+File.separatorChar+"avatarbrains7.bmp")));
			shotByGunMaker.addDxNegImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"avatarbrains"+File.separatorChar+"avatarbrains8.bmp")));
			
			shotByGunMaker.addDxPosImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"avatarbrains"+File.separatorChar+"avatarbrains1.bmp")));
			shotByGunMaker.addDxPosImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"avatarbrains"+File.separatorChar+"avatarbrains2.bmp")));
			shotByGunMaker.addDxPosImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"avatarbrains"+File.separatorChar+"avatarbrains3.bmp")));
			shotByGunMaker.addDxPosImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"avatarbrains"+File.separatorChar+"avatarbrains4.bmp")));
			shotByGunMaker.addDxPosImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"avatarbrains"+File.separatorChar+"avatarbrains5.bmp")));
			shotByGunMaker.addDxPosImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"avatarbrains"+File.separatorChar+"avatarbrains6.bmp")));
			shotByGunMaker.addDxPosImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"avatarbrains"+File.separatorChar+"avatarbrains7.bmp")));
			shotByGunMaker.addDxPosImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"avatarbrains"+File.separatorChar+"avatarbrains8.bmp")));
			
			shotByGunMaker.addDyNegImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"avatarbrains"+File.separatorChar+"avatarbrains1.bmp")));
			shotByGunMaker.addDyNegImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"avatarbrains"+File.separatorChar+"avatarbrains2.bmp")));
			shotByGunMaker.addDyNegImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"avatarbrains"+File.separatorChar+"avatarbrains3.bmp")));
			shotByGunMaker.addDyNegImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"avatarbrains"+File.separatorChar+"avatarbrains4.bmp")));
			shotByGunMaker.addDyNegImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"avatarbrains"+File.separatorChar+"avatarbrains5.bmp")));
			shotByGunMaker.addDyNegImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"avatarbrains"+File.separatorChar+"avatarbrains6.bmp")));
			shotByGunMaker.addDyNegImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"avatarbrains"+File.separatorChar+"avatarbrains7.bmp")));
			shotByGunMaker.addDyNegImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"avatarbrains"+File.separatorChar+"avatarbrains8.bmp")));
			
			shotByGunMaker.addDxNegImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"avatarbrains"+File.separatorChar+"avatarbrains1.bmp")));
			shotByGunMaker.addDxNegImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"avatarbrains"+File.separatorChar+"avatarbrains2.bmp")));
			shotByGunMaker.addDxNegImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"avatarbrains"+File.separatorChar+"avatarbrains3.bmp")));
			shotByGunMaker.addDxNegImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"avatarbrains"+File.separatorChar+"avatarbrains4.bmp")));
			shotByGunMaker.addDxNegImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"avatarbrains"+File.separatorChar+"avatarbrains5.bmp")));
			shotByGunMaker.addDxNegImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"avatarbrains"+File.separatorChar+"avatarbrains6.bmp")));
			shotByGunMaker.addDxNegImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"avatarbrains"+File.separatorChar+"avatarbrains7.bmp")));
			shotByGunMaker.addDxNegImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"avatarbrains"+File.separatorChar+"avatarbrains8.bmp")));
			
			///// dead by gun
			
			bufImage = ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"avatarbrains"+File.separatorChar+"poolofblood.bmp"));
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
