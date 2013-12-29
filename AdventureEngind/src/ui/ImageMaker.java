package ui;

import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class ImageMaker implements IImageMaker {
	private List<Image> walkRightImages = new ArrayList<Image>(10);
	private List<Image> walkLeftImages = new ArrayList<Image>(10);
	private List<Image> walkUpImages = new ArrayList<Image>(10);
	private List<Image> walkDownImages = new ArrayList<Image>(10);
	public void addDxPosImage(Image image) {
		walkRightImages.add(image);

	}

	public void addDyPosImage(Image image) {
		walkDownImages.add(image);

	}

	@Override
	public void addDxNegImage(Image image) {
		walkLeftImages.add(image);

	}

	@Override
	public void addDyNegImage(Image image) {
		walkUpImages.add(image);

	}

	@Override
	public Image getImage(int cycle, Point start, Point end) {
		int dx = (int) (end.getX() - start.getX());
		int dy = (int) (end.getY() - start.getY());
		if(Math.abs(dx) > Math.abs(dy)){
			return dx > 0 ? walkRightImages.get(cycle % walkRightImages.size()) : walkLeftImages.get(cycle % walkLeftImages.size());
		}
		else{
			return dy > 0 ? walkDownImages.get(cycle % walkDownImages.size()) : walkUpImages.get(cycle % walkUpImages.size());
		}
	}

}
