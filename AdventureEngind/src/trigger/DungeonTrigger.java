package trigger;

import data.IDungeon;

public class DungeonTrigger extends WarpTrigger {
	private String dungeonHandle;
	
	public DungeonTrigger(String dungeonHandle){
		this.dungeonHandle = dungeonHandle;
	}

	public String getDungeonHandle() {
		return dungeonHandle;
	}

	public void setDungeonHandle(String dungeonHandle) {
		this.dungeonHandle = dungeonHandle;
	}
}
