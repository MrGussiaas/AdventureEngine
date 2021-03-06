package objects.prisoninterior;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import objects.pennave1.IImageRegistry;
import renderingpolicies.IImagePolicy;
import renderingpolicies.TransparencyPolicy;

public class RightTorchImageRegistry implements IImageRegistry {

	private static IImageRegistry instance;
	private List<Image> imageCycles = new ArrayList<Image>(10);
	private Image image1;
	private Image image2;
	public static IImageRegistry getInstance(){
		if(instance == null){
			
			instance = new RightTorchImageRegistry();
		}
		return instance;
	}
	
	private RightTorchImageRegistry(){
		IImagePolicy transparency = new TransparencyPolicy(0xFFFA45EC);
		try {
			image1 = transparency.renderImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"PrisonInterior"+File.separatorChar+"torchright1.bmp")));
			image2 = transparency.renderImage(ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"PrisonInterior"+File.separatorChar+"torchright2.bmp")));
			imageCycles.add(image1);
			imageCycles.add(image1);
			imageCycles.add(image1);
			imageCycles.add(image2);
			imageCycles.add(image2);
			imageCycles.add(image2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Image getImage(int cycleCount) {
		return imageCycles.get(cycleCount % imageCycles.size());
	}

}
