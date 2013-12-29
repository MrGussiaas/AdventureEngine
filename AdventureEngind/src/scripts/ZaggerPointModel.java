package scripts;

import java.util.ArrayList;
import java.util.List;

public class ZaggerPointModel implements IZaggerPointModel {

	private List<IZaggerPoint> zaggerPoints = new ArrayList<IZaggerPoint>(10);
	private IZaggerPoint startZagger;
	private IZaggerPoint endZagger;
	public int getZaggerPointCount() {
		return zaggerPoints.size();
	}

	@Override
	public IZaggerPoint getZaggerPoint(int index) {
		return zaggerPoints.get(index);
	}

	@Override
	public void addZaggerPoint(IZaggerPoint zaggerPoint) {
		zaggerPoints.add(zaggerPoint);

	}

	@Override
	public void removeZaggerPoint(int index) {
		zaggerPoints.remove(index);

	}

	@Override
	public IZaggerPoint getStart() {
		return startZagger;
	}

	@Override
	public void setStart(IZaggerPoint zaggerPoint) {
		this.startZagger = zaggerPoint;

	}

	@Override
	public IZaggerPoint getEnd() {
		return endZagger;
	}

	@Override
	public void setEnd(IZaggerPoint zaggerPoint) {
		this.endZagger = zaggerPoint;

	}

}
