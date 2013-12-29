package objects.uifactories;

import io.IIOHandler;

import java.awt.Cursor;

import objects.IGameObject;

import ui.IGameModel;

public interface ICursorFactory {
	public Cursor makeCursor(IGameModel model, IGameObject objectClicked);
}
