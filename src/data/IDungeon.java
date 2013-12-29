package data;

import java.io.Serializable;

public interface IDungeon extends IWarp {
	public String getFileName();
	public void setFileName(String fileName);
	
	public int getRoomCount();
	public IRoom getRoom(int index);
	public int getRoomIndex(IRoom room);
	
	public void removeRoom(int index);
	public void addRoom(IRoom room);
	
	public void setTopMapping(IWarp warp1, IWarp warp2);
	public void setLeftMapping(IWarp warp1, IWarp warp2);
	public void setBottomMapping(IWarp warp1, IWarp warp2);
	public void setRightMapping(IWarp warp1, IWarp warp2);
	
	public IWarp getTopMapping(IWarp warp);
	public IWarp getLeftMapping(IWarp warp);
	public IWarp getBottomMapping(IWarp warp);
	public IWarp getRightMapping(IWarp warp);
	
	public IRoom getCurrentRoom();
	public void setCurrentRoom(IRoom room);
	
	public IRoom getRoomById(int id);
	
	public IRoom getInitialRoom();
	public void setInitialRoom(IRoom initialRoom);
	
	
}
