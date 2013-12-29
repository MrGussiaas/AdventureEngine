package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class RoomSaver implements IRoomSaverLoader {

	public void saveRoom(IRoom room, String fileName) throws FileNotFoundException, IOException {
		ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName));
		outputStream.writeObject(room);
	}

	@Override
	public IRoom loadRoom(String fileName) throws FileNotFoundException,
			IOException, ClassNotFoundException {
		ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName));
		return (IRoom) inputStream.readObject();
	}

}
