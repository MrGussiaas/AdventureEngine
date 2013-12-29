package data;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface IRoomSaverLoader {
	public void saveRoom (IRoom room, String fileName) throws FileNotFoundException, IOException;
	public IRoom loadRoom (String fileName) throws FileNotFoundException, IOException, ClassNotFoundException;
}
