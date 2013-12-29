package io;

import ui.TestFrame;

public class RefreshEvent implements IInputEvent {
	private TestFrame frame;
	public RefreshEvent(TestFrame frame){
		this.frame = frame;
	}
	public TestFrame getFrame(){
		return frame;
	}
	public void setFrame(TestFrame frame){
		this.frame = frame;
	}
}
