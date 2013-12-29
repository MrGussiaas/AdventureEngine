package ui;

import java.awt.Image;
import java.awt.Point;
import java.io.Serializable;

public interface IImageMaker extends Serializable {
	public void addDxPosImage(Image image);
	public void addDyPosImage(Image image);
	public void addDxNegImage(Image image);
	public void addDyNegImage(Image image);
	public Image getImage(int cycle, Point start, Point end);
	
}
