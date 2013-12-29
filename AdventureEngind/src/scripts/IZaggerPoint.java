package scripts;

import java.awt.Point;

public interface IZaggerPoint {
	public Point getPoint();
	public int getChildCount();
	
	public void addChild(IZaggerPoint point);
	public void removeChild(int index);
	public IZaggerPoint getChild(int index);
}
