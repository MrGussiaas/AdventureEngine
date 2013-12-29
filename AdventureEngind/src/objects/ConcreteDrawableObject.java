package objects;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import renderingpolicies.IImagePolicy;



public class ConcreteDrawableObject extends ConcreteObject implements
		IDrawableObject {

	private String fileName;
	private transient BufferedImage bufImage = null;
	private List<IImagePolicy> imagePolicies = new ArrayList<IImagePolicy>(10);
	public void setSpriteFile(String fileName) {
		this.fileName = fileName;

	}

	public String getSpriteFile() {
		return fileName;
	}
	


	public Image createImage() {
		if(bufImage == null){
			try {
				bufImage = ImageIO.read(new File(fileName));
				setHeight(bufImage.getHeight());
				setWidth(bufImage.getWidth());
				for(int i = 0, n = imagePolicies.size(); i < n; i++){
					bufImage = (BufferedImage) imagePolicies.get(i).renderImage(bufImage);
				}
			} catch (IOException e) {
				bufImage = null;
			}
		}
		return bufImage;
	}

	@Override
	public void addImagePolicy(IImagePolicy policy) {
		imagePolicies.add(policy);
		
	}

	@Override
	public IImagePolicy getPolicy(int index) {
		return imagePolicies.get(index);
	}

	@Override
	public int getPolicyCount() {
		return imagePolicies.size();
	}

}
