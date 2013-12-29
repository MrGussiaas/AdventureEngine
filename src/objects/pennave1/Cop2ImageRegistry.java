package objects.pennave1;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class Cop2ImageRegistry implements IImageRegistry{
	private static Cop2ImageRegistry instance;
	private List<Image> imageCycles = new ArrayList<Image>(10);
	
	public static Cop2ImageRegistry getInstance(){
		if(instance == null){
			instance = new Cop2ImageRegistry();
		}
		return instance;
	}
	
	private Cop2ImageRegistry(){
		try {
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop2a.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop2a.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop2a.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop2a.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop2a.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop2abo.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop2abo.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop2abo.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop2abo.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop2abc.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop2abc.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop2abo.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop2abo.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop2ao.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop2ao.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop2ac.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop2ac.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop2ao.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop2ao.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop2ac.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop2ac.bmp")));
			
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop2a.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop2a.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop2a.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop2a.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop2a.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop2a.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop2a.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop2a.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop2a.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop2a.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop2a.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop2a.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop2a.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop2a.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop2a.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop2a.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop2a.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop2a.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop2a.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop2a.bmp")));
			imageCycles.add(ImageIO.read(new File(".\\images\\penn1\\cop2a.bmp")));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Image getImage(int cycleCount){
		return imageCycles.get(cycleCount % imageCycles.size());
	}
}
