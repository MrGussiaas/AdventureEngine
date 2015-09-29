package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConcreteDungeon implements IDungeon {

	private List<IRoom> rooms = new ArrayList<IRoom>(10);
	
	private Map<IWarp, IWarp> topMappings = new HashMap<IWarp, IWarp>(10);
	private Map<IWarp, IWarp> rightMappings = new HashMap<IWarp, IWarp>(10);
	private Map<IWarp, IWarp> bottomMappings = new HashMap<IWarp, IWarp>(10);
	private Map<IWarp, IWarp> leftMappings = new HashMap<IWarp, IWarp>(10);
	private IRoom currentRoom;
	private int id;
	private String fileName;
	private IRoom initialRoom;
	
	
	
	public int getRoomCount() {
		return rooms.size();
	}

	@Override
	public IRoom getRoom(int index) {
		return rooms.get(index);
	}

	@Override
	public void removeRoom(int index) {
		rooms.remove(index);

	}

	public void addRoom(IRoom room) {
		rooms.add(room);

	}

	@Override
	public void setTopMapping(IWarp warp1, IWarp warp2) {
		topMappings.put(warp1, warp2);
		
	}

	@Override
	public void setLeftMapping(IWarp warp1, IWarp warp2) {
		leftMappings.put(warp1, warp2);
		
	}

	@Override
	public void setBottomMapping(IWarp warp1, IWarp warp2) {
		bottomMappings.put(warp1, warp2);
		
	}

	@Override
	public void setRightMapping(IWarp warp1, IWarp warp2) {
		rightMappings.put(warp1, warp2);
		
	}

	@Override
	public IWarp getTopMapping(IWarp warp) {
		return topMappings.get(warp);
	}

	@Override
	public IWarp getLeftMapping(IWarp warp) {
		return leftMappings.get(warp);
	}

	@Override
	public IWarp getBottomMapping(IWarp warp) {
		return bottomMappings.get(warp);
	}

	@Override
	public IWarp getRightMapping(IWarp warp) {
		return rightMappings.get(warp);
	}

	@Override
	public IRoom getCurrentRoom() {
		return currentRoom;
	}

	@Override
	public void setCurrentRoom(IRoom room) {
		this.currentRoom = room;
		
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
		
	}

	@Override
	public int getRoomIndex(IRoom room) {
		return rooms.indexOf(room);
	}

	@Override
	public String getFileName() {
		return fileName;
	}

	@Override
	public void setFileName(String fileName) {
		this.fileName = fileName;
		
	}

	@Override
	public IRoom getRoomById(int id) {
		for(int i = 0, n = rooms.size(); i < n; i++){
			if(rooms.get(i).getId() == id){
				return rooms.get(i);
			}
		}
		return null;
	}

	@Override
	public IRoom getInitialRoom() {
		return initialRoom;
	}

	@Override
	public void setInitialRoom(IRoom initialRoom) {
		this.initialRoom = initialRoom;
		
	}

}
