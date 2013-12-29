package scripts;

import ui.IGameModel;

public interface IZaggerModelFactory {
	public IZaggerPointModel createZaggerPointsFromModel(IGameModel model);
	
}
