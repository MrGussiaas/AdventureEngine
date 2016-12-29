package screensettings;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;

import objects.IDrawableObject;
import objects.IGameObject;

public class ScreenConverterUtils {
	
	public static Rectangle getScaledDimension(Rectangle rect, IScreenSettings settings){
		int pixWid = getPixelWidth(settings);
		int pixHgt = getPixelHeight(settings);
		
		int tranX = (int) (pixWid * rect.getX());
		int tranY = (int) (pixHgt * rect.getY());
		int tranWid = (int) (pixWid * rect.getWidth());
		int tranHgt = (int) (pixHgt * rect.getHeight());
		return new Rectangle(tranX, tranY, tranWid, tranHgt);
	}
	
	public static int getPixelWidth(IScreenSettings settings){
		int realWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int offSet = settings.getResWide();
		return realWidth / offSet;
		//return 1;
	}
	
	public static int getPixelWidth(IScreenSettings settings, int viewWidth){;
		int offSet = settings.getResWide();
		return viewWidth / offSet;
	}
	
	public static int getPixelHeight(IScreenSettings settings, int viewHeight){;
	int offSet = settings.getResHeight();
	return viewHeight / offSet;
}
	
	public static int getPixelHeight(IScreenSettings settings){
		int realHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		int offSet = settings.getResHeight();
		return realHeight / offSet;
		//return 1;
	}
	
	public static Rectangle getScaledDimension(IGameObject object, IScreenSettings settings){
		int tranX = (int) object.getX();
		int tranY = (int) object.getY();
		int tranWid = (int) object.getWidth();
		int tranHgt = (int) object.getHeight();
		return new Rectangle(tranX, tranY, tranWid, tranHgt);
		
	}
	
	public static int getVerticalSplits(int viewWidth, int normalizedWidth){

		
		return (viewWidth - normalizedWidth) + 1;
		
	}
	
	public static int getHorizontalSplits(int viewHeight, int normalizedHeight){

		
		return (viewHeight - normalizedHeight) + 1;
		
	}
	
	public static int getObjectHeight(IDrawableObject object){
		return object.createImage().getWidth(null);
	}
	
	public static int getObjectWidth(IDrawableObject object){
		return object.createImage().getHeight(null);
	}
	
	public static Point computeCenter(IScreenSettings settings, IGameObject object){
		int midX = (int) ((settings.getResWide() / 2) - (object.getWidth() / 2));
		int midY = (int)((settings.getResHeight() / 2)-(object.getHeight() / 2));
		return new Point(midX, midY);
	}
	
	public static Point computeCenter(Rectangle settings, IGameObject object){
		int midX = (int) ((settings.getWidth() / 2) - (object.getWidth() / 2)) ;
		int midY = (int)((settings.getHeight() / 2)-(object.getHeight() / 2));
		return new Point(midX, midY);
	}
	
	public static Point computeCenter(Rectangle outer, Rectangle inner){
		int midX = (int) ((outer.getWidth() / 2) - (inner.getWidth() / 2)) ;
		int midY = (int)((outer.getHeight() / 2)-(inner.getHeight() / 2));
		return new Point(midX, midY);
	}
}
