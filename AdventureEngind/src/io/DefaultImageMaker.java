package io;

import java.awt.Image;
import java.awt.Point;

import ui.ImageMaker;

public class DefaultImageMaker extends ImageMaker {
	private Image defaultImage;

	@Override
	public Image getImage(int cycle, Point start, Point end) {
		// TODO Auto-generated method stub
		return defaultImage;
	}

	public DefaultImageMaker(Image defaultImage) {
		this.defaultImage = defaultImage;
	}
}
