package objects.prisoninterior;

import java.awt.Image;

import objects.ConcreteDrawableObject;
import objects.IGameObject;
import scripts.IScriptRunner;
import scripts.IScriptableObject;

public class LeftTorch extends ConcreteDrawableObject implements
		IScriptableObject {

	private int cycleCount;
	public Image createImage() {
		Image image = LeftTorchImageRegistry.getInstance().getImage(cycleCount);
		setWidth(image.getWidth(null));
		setHeight(image.getHeight(null));
		return image;
	}

	@Override
	public void update() {
		cycleCount++;
	}

	@Override
	public IScriptRunner getActionScript() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IScriptRunner getLookScript() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IScriptRunner getTalkScript(IGameObject object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IScriptRunner getItmScript(IGameObject object) {
		// TODO Auto-generated method stub
		return null;
	}

}
