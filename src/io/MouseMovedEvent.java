package io;

import java.awt.Point;

public class MouseMovedEvent implements IInputEvent {
	private Point oldPoint;
	private Point newPoint;
	public Point getOldPoint() {
		return oldPoint;
	}
	public MouseMovedEvent(Point oldPoint, Point newPoint) {
		super();
		this.oldPoint = oldPoint;
		this.newPoint = newPoint;
	}
	public Point getNewPoint() {
		return newPoint;
	}
}
