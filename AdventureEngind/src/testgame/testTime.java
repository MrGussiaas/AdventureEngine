package testgame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class testTime implements ActionListener{
	private int calls;

	public int getCalls(){
		return calls;
	}
	
	public static class ThreadTimer implements Runnable
	{

		private ActionListener listener;
		private int milliupdate;
		
		public ThreadTimer(ActionListener listener, int milliupdate){
			this.listener = listener;
			this.milliupdate = milliupdate;
		}
		
		public void run() {
			long currentTime = System.currentTimeMillis();
			while(true){
				if(System.currentTimeMillis() - currentTime > milliupdate){
					currentTime = System.currentTimeMillis();
					listener.actionPerformed(null);
					;

				}
			}
			
		}
		
	}
	
	public static void main(String[] args){
		testTime myTime = new testTime();
		GraphicTimer myTimer = new GraphicTimer(1, myTime);
		myTimer.start();
		long currentTime = System.currentTimeMillis();
		
		while(System.currentTimeMillis() - currentTime < 1000){
		}
		
		System.out.println(myTime.getCalls());
		
	}
	public void actionPerformed(ActionEvent arg0) {
		calls++;
		
	}
}
