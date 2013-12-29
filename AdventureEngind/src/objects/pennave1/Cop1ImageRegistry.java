package objects.pennave1;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

public class Cop1ImageRegistry implements IImageRegistry{
	public static Cop1ImageRegistry instance;
	private List<Image> imageCycles = new ArrayList<Image>(10);
	
	public static Cop1ImageRegistry getInstance(){
		if(instance == null){
			instance = new Cop1ImageRegistry();
		}
		return instance;
	}
	
	private Cop1ImageRegistry(){
		try {
			
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop1a.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop1a.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop1a.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop1a.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop1a.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop1a.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop1a.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop1a.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop1a.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop1a.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop1a.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop1a.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop1a.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop1a.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop1a.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop1a.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop1a.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop1a.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop1a.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop1a.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop1a.bmp")));
			
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop1a.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop1a.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop1a.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop1a.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop1a.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop1abo.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop1abo.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop1abo.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop1abo.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop1abc.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop1abc.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop1abo.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop1abo.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop1ao.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop1ao.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop1ac.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop1ac.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop1ao.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop1ao.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop1ac.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop1ac.bmp")));
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Image getImage(int cycle){
		return imageCycles.get(cycle % imageCycles.size());
	}
	
}
