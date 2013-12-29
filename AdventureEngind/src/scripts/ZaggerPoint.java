package scripts;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class ZaggerPoint implements IZaggerPoint {

	public ZaggerPoint(Point point) {
		super();
		this.point = point;
	}

	private Point point;
	private List<IZaggerPoint> children = new ArrayList<IZaggerPoint>(10);
	
	@Override
	public Point getPoint() {
		return point;
	}

	@Override
	public int getChildCount() {
		return children.size();
	}

	@Override
	public void addChild(IZaggerPoint point) {
		children.add(point);

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((point == null) ? 0 : point.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ZaggerPoint other = (ZaggerPoint) obj;
		if (point == null) {
			if (other.point != null)
				return false;
		} else if (!point.equals(other.point))
			return false;
		return true;
	}

	@Override
	public void removeChild(int index) {
		children.remove(index);

	}

	@Override
	public IZaggerPoint getChild(int index) {
		return children.get(index);
	}

}
