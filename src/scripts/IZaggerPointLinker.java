package scripts;

import ui.IGameModel;

public interface IZaggerPointLinker {
	public void linkZaggerPoints(IZaggerPointModel zaggerModel, IGameModel gameModel);
	public IZaggerPoint createLinkedPoint(IZaggerPoint zaggerPoint, IZaggerPointModel zaggerModel, IGameModel gameModel);
}
