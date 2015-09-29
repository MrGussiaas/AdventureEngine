package objects.outsideachmeres;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import objects.ConcreteDrawableObject;

public class AchmereSign extends ConcreteDrawableObject {


	@Override
	public void update() {
		cyclecount++;
	}

	private int cyclecount;
	
	public AchmereSign(){
		setSpriteFile(globalvariables.constants.IMAGE_LOCATION+"nineteenth2\\achmeresSign1.bmp");
	}

	@Override
	public Image createImage() {

			Image img = AchmereSignSequence.getInstance().getImage(cyclecount);
			setWidth(img.getWidth(null));
			setHeight(img.getHeight(null));
			
		
		return img;
	}
	
	
	
}
