package trigger;

import java.awt.Point;

public class DungeonRoomTrigger extends DungeonTrigger {
	
	private Point exactPoint;
	private int roomIndex;
	
	public DungeonRoomTrigger(String dungeonHandle, Point exactPoint, int roomIndex){
		super(dungeonHandle);
		this.exactPoint = exactPoint;
		this.roomIndex = roomIndex;
	}
	
	public Point getExactPoint() {
		return exactPoint;
	}

	public void setExactPoint(Point exactPoint) {
		this.exactPoint = exactPoint;
	}

	public int getRoomIndex() {
		return roomIndex;
	}

	public void setRoomIndex(int roomIndex) {
		this.roomIndex = roomIndex;
	}

	public DungeonRoomTrigger(String dungeonHandle) {
		super(dungeonHandle);
		exactPoint = new Point(0, 0);
	}

}
