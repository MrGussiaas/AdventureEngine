package data.rooms.achmere;

import java.awt.Image;
import java.awt.Point;

import objects.ConcreteDrawableObject;
import objects.IGameObject;
import scripts.IScriptRunner;
import scripts.IScriptableObject;
import scripts.achmereinterior.AchmereActionScript;
import scripts.achmereinterior.LookAchmereScript;
import ui.AchmereImageMaker;
import ui.IImageMaker;

public class Achmere extends ConcreteDrawableObject implements
		IScriptableObject {

	private int cycleCount;
	public IScriptRunner getActionScript() {
		return new AchmereActionScript();
	}

	@Override
	public IScriptRunner getLookScript() {
		// TODO Auto-generated method stub
		return new LookAchmereScript();
	}

	@Override
	public IScriptRunner getTalkScript(IGameObject object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Image createImage() {
		Point start = getHotSpot();
		Point end = new Point((int)getX(), (int)getY());;
		if(getWayPointCount() > 0){
			end = getWayPoint(0);
		}
		IImageMaker maker = AchmereImageMaker.getInstance().getMaker(getInternalState());
		Image image = maker.getImage(cycleCount, start, end);
		setWidth(image.getWidth(null));
		setHeight(image.getHeight(null));
		return image;
	}

	@Override
	public void update() {
		cycleCount++;
	}

	@Override
	public IScriptRunner getItmScript(IGameObject object) {
		// TODO Auto-generated method stub
		return null;
	}

}
