package objects.hotspotcalculators;

import java.awt.Point;

import objects.IGameObject;

public interface IHotSpotCalculator{
	public Point computeHotSpot(IGameObject object);
}
