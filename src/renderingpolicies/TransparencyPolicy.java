package renderingpolicies;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;

public class TransparencyPolicy implements IImagePolicy {
	private int transparencyBits;
	
	public TransparencyPolicy(int transparencyBits){
		this.transparencyBits = transparencyBits;
	}
	
	@Override
	public Image renderImage(Image img) {
		int width = img.getWidth(null);
		int height = img.getHeight(null);
		
		int ipix[] = new int[width*height];
		long mpix[] = new long[width*height];
		int mask = 0 <<24;
		mask = mask | 0x00ffffff;
		boolean gotfg = false;
		boolean gotma = false;
		try {
			gotfg = new PixelGrabber(img,0,0,width,height,ipix,0,width).grabPixels();
		}
		catch (InterruptedException e) {}

		for(int i=0, rc = width * height;i<rc;i++)
		{
			int fg = ipix[i];
			if(fg == transparencyBits){
				ipix[i] = mask;
			}
		}
		BufferedImage offIm = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
		offIm.setRGB(0, 0, width, height, ipix, 0, width);
		Image fin = offIm;
		return(fin);
	}

}
