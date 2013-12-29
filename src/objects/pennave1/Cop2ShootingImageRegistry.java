package objects.pennave1;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class Cop2ShootingImageRegistry implements IImageRegistry {

	private List<Image> images = new ArrayList<Image>(10);
	private static Cop2ShootingImageRegistry instance;
	
	public static Cop2ShootingImageRegistry getInstance(){
		if(instance == null){
			instance = new Cop2ShootingImageRegistry();
		}
		return instance;
	}
	
	private Cop2ShootingImageRegistry(){
		try {
			images.add(ImageIO.read(new File(".\\images\\penn1\\cop2abc_shooting.bmp")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public Image getImage(int cycleCount) {
		Image answer = images.get(cycleCount % images.size());
		return answer;
	}

}
