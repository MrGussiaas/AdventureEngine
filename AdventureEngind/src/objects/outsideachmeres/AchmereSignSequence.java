package objects.outsideachmeres;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class AchmereSignSequence {
	private transient BufferedImage signOn = null;
	private transient BufferedImage signOff = null;
	private List<Image> images = new ArrayList<Image>(10);
	
	private static AchmereSignSequence instance;

	public static AchmereSignSequence getInstance(){
		if(instance == null){
			instance = new AchmereSignSequence();
		}
		return instance;
	}
	
	private AchmereSignSequence(){

		try {
			signOn = ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"nineteenth2"+File.separatorChar+"achmeresSign1.bmp"));
			signOff = ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"nineteenth2"+File.separatorChar+"achmeresSign2.bmp"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		images.add(signOn);
		images.add(signOn);
		images.add(signOn);
		images.add(signOn);
		images.add(signOn);
		images.add(signOn);
		images.add(signOn);
		images.add(signOn);
		images.add(signOff);
		images.add(signOff);
		images.add(signOn);
		images.add(signOff);
		images.add(signOn);
		images.add(signOff);
	}
	
	public Image getImage(int cycleCount){
		return images.get(cycleCount % images.size());
	}
}
