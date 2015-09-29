package objects.pennave1;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class Cop1LoveImageRegistry implements IImageRegistry{
	
	private static Cop1LoveImageRegistry instance;
	
	private List<Image> images = new ArrayList<Image>(10);
	
	public static Cop1LoveImageRegistry getInstance(){
		if(instance == null){
			instance = new Cop1LoveImageRegistry();
		}
		return instance;
	}
	
	private Cop1LoveImageRegistry(){
		try {
			images.add(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"penn1\\cop1a_lover.bmp")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Image getImage(int cycleCount) {
		return images.get(cycleCount % images.size());
	}
}
