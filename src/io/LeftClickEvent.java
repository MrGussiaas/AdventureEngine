package io;

import objects.IGameObject;

public class LeftClickEvent implements IInputEvent {
	private int x = 0;
	private int y = 0;
	private IGameObject clickedObject;
	
	public LeftClickEvent(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public IGameObject getClickedObject(){
		return clickedObject;
	}
	
	public void setClickedObject(IGameObject object){
		this.clickedObject = object;
	}
	
	
	
}
