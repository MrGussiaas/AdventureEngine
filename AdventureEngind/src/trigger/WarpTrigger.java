package trigger;

import java.awt.Point;

import objects.IGameObject;

public class WarpTrigger extends ConcreteTrigger {

	private int newX;
	private int newY;
	
	
	public int getNewX() {
		return newX;
	}


	public void setNewX(int newX) {
		this.newX = newX;
	}


	public int getNewY() {
		return newY;
	}


	public void setNewY(int newY) {
		this.newY = newY;
	}

	
	public WarpTrigger(){
		this.newX = 200;
		this.newY=20;
	}
	
	public WarpTrigger(int newX, int newY) {
		super();
		this.newX = newX;
		this.newY = newY;
	}


	@Override
	public boolean isTriggerable(IGameObject object) {
		// TODO Auto-generated method stub
		Point hotSpot = object.getHotSpot();
		if(hotSpot.getX() >= super.getX() && hotSpot.getX() <= super.getX() + super.getWidth() && hotSpot.getY() >= super.getY() && hotSpot.getY() <= super.getY() + super.getHeight()){
			return true;
		}
		return false;
	}

}
