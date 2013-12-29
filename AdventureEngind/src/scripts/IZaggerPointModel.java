package scripts;


public interface IZaggerPointModel {
	public int getZaggerPointCount();
	public IZaggerPoint getZaggerPoint(int index);
	public void addZaggerPoint(IZaggerPoint zaggerPoint);
	public void removeZaggerPoint(int index);
	public IZaggerPoint getStart();
	public void setStart(IZaggerPoint zaggerPoint);
	
	public IZaggerPoint getEnd();
	public void setEnd(IZaggerPoint zaggerPoint);
	
}
