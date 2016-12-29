package renderingpolicies;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;

import screensettings.ScreenConverterUtils;
import screensettings.ScreenSettings;

public class ScaleUpPolicy implements IImagePolicy {

	private BufferedImage cachedImage;
	private int newWidth;
	private int newHeight;
	private int [] newPix;
	
	private int translateCoord (int x, int y, int width, int height){
		return (width * y) + x;
	}
	
	public ScaleUpPolicy(int width, int height){
		this.newHeight = height;
		this.newWidth = width;
		newPix = new int[newWidth * newHeight];
		cachedImage = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
	}
	
	private void recurseFillPixel(int[] pixels, int pixelWidth, int pixelHeight, int x, int y, int color){
		if(pixelWidth == 0 || pixelHeight == 0){
			return;
		}
		if(y < newHeight && x < newWidth){		
			int trnaslateCoord2 = translateCoord(x, y, newWidth, newHeight);
			pixels[trnaslateCoord2] = color;
			recurseFillPixel(pixels, pixelWidth - 1, pixelHeight, x+1, y, color);
			recurseFillPixel(pixels, pixelWidth, pixelHeight - 1, x, y+1, color);
			
		}
	}
	
	public Image renderImage(Image img) {
		
		int origWidth = img.getWidth(null);
		int origHeight = img.getHeight(null);
		int pixWidth = ScreenConverterUtils.getPixelWidth(ScreenSettings.getInstance(), newWidth);
		int pixHeight = ScreenConverterUtils.getPixelHeight(ScreenSettings.getInstance(), newHeight);
		int[] origPix = new int[origWidth * origHeight];
		int tilesAcross = ScreenConverterUtils.getVerticalSplits(newWidth / pixWidth, origWidth);
		int tilesDown = ScreenConverterUtils.getHorizontalSplits(newHeight / pixHeight, origHeight);
		try {
			new PixelGrabber(img,0,0,origWidth,origHeight,origPix,0,origWidth).grabPixels();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int clipWidth = tilesAcross > 0 ? (newWidth / pixWidth) / (tilesAcross) : (newWidth / pixWidth);
		int clipHeight = tilesDown > 0 ? (newHeight / pixHeight) / (tilesDown) : (newHeight / pixHeight);
		//DataBufferByte rgbBuffer = (DataBufferByte)nonScaledImage.getData().getDataBuffer();
		//byte[] rgb = rgbBuffer.getData();
		
				
		for(int i = 0; i < tilesAcross; i++){
			for(int k = 0; k < tilesDown ; k++){
				int subX = (clipWidth * i) + i;
				int subY = (clipHeight * k) + k;
				for(int ii = 0; ii < clipWidth; ii++){
					for(int kk = 0; kk < clipHeight; kk++){
						int origX = subX + ii;
						int origY = subY + kk;
						int translateCoord = translateCoord(origX, origY, origWidth, origHeight);
						int newX = (origX + (i)) * pixWidth;
						int newY = (origY + (k)) * pixHeight;
						if(origX < origWidth && origY < origHeight){
							recurseFillPixel(newPix,pixWidth,pixHeight, newX, newY, origPix[translateCoord]);
						}
					}
				}
			}
		}
		
		cachedImage.setRGB(0, 0, newWidth, newHeight, newPix, 0, newWidth);
		return(cachedImage);
	}

}
