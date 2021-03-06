package ui;

import io.IIOHandler;
import io.IInputEvent;
import io.IOPropogater;
import io.KeyTypedEvent;
import io.LeftClickEvent;
import io.LeftPressEvent;
import io.MouseEnteredHudAreaEvent;
import io.MouseExitedHudAreaEvent;
import io.MouseMovedEvent;
import io.RefreshEvent;
import io.RightClickEvent;

import java.awt.Container;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import commands.UniversalCommandQueue;
import screensettings.ScreenConverterUtils;
import screensettings.ScreenSettings;
import testgame.GraphicTimer;

public class TestFrame extends JFrame implements IOPropogater{
	
	private List<IIOHandler> ioHandlers = new ArrayList<IIOHandler>(10);
	private Point previousPoint = new Point(0, 0);
	
	private class ICGraphicTimer implements Runnable, ActionListener{
		private TestFrame testFrame;
		private int eventCount = 0;
		private int secondsPassedSum = 0;
		private long prevTime = System.currentTimeMillis();
		private int frameCount = 0;
		public ICGraphicTimer (TestFrame testFrame){
			this.testFrame = testFrame;
		}
		
		public ICGraphicTimer(int frameCount, TestFrame testFrame){
			this.frameCount = frameCount;
			this.testFrame = testFrame;
		}
		
		public void actionPerformed(ActionEvent e) {
		//	long curTime = System.currentTimeMillis();
			
			fireEvent(new RefreshEvent(testFrame));
			for(int i = 0, n = UniversalCommandQueue.getInstance().getEventCount(); i < n; i++){
				fireEvent(UniversalCommandQueue.getInstance().getEvent(0));
				UniversalCommandQueue.getInstance().removeEvent(i);
			}
			//long timeElapsed = System.currentTimeMillis() - curTime;
		//	System.out.println(timeElapsed);
			/*long curTime = System.currentTimeMillis();
			long timeElapsed = curTime - prevTime;
			prevTime = curTime;
			
			eventCount ++;
			secondsPassedSum += timeElapsed;
			frameCount++;
			if(secondsPassedSum >= 1000){
				frameCount = 0;
				secondsPassedSum = 0;
			}*/
			//System.out.println("fps: " + (secondsPassedSum / eventCount));
			
			
			
		}
		@Override
		public void run() {

			//	long curTime = System.currentTimeMillis();
				int delay = 1000 / frameCount;
				while(true){
				fireEvent(new RefreshEvent(testFrame));
				try {
					Thread.sleep(delay);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				

			
		}
	};
	
	public TestFrame(){
		GraphicTimer myTimer = new GraphicTimer(40, new ICGraphicTimer(this));
		getContentPane().addMouseListener(this);
		getContentPane().addMouseMotionListener(this);
		addKeyListener(this);
		new Thread(new ICGraphicTimer(128, this)).start();
	}
	
	public void refresh(Image img){
		Container contentPane = getContentPane();
		//contentPane.getGraphics().drawImage(img, 0, 0, getWidth(), getHeight(), 0,0,img.getWidth(this), img.getHeight(this), this);
		contentPane.getGraphics().drawImage(img, 0, 0, null);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		if(arg0.getButton() == MouseEvent.BUTTON1){
			//System.out.println("y: " + arg0.getY() + "casted: " + ((int)arg0.getY()));
			//int pixWid = ScreenConverterUtils.getPixelWidth(ScreenSettings.getInstance());
			//int pixHt = ScreenConverterUtils.getPixelHeight(ScreenSettings.getInstance());
			//int tilesDown = ScreenConverterUtils.getHorizontalSplits(getHeight(), ScreenSettings.getInstance().getResHeight());
			//int tilesAcross = ScreenConverterUtils.getVerticalSplits(getWidth(), ScreenSettings.getInstance().getResWide())
			//int tranx = (arg0.getX() - (arg0.getX() % pixWid)) / pixWid;
			//int trany = (arg0.getY() - (arg0.getY() % pixHt)) / pixHt;
			fireEvent(new LeftPressEvent(arg0.getX(), arg0.getY()));
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		if(arg0.getButton() == MouseEvent.BUTTON3){
			fireEvent(new RightClickEvent(this));
		}
		if(arg0.getButton() == MouseEvent.BUTTON1){
			//System.out.println("y: " + arg0.getY() + "casted: " + ((int)arg0.getY()));

			int pixWid = ScreenConverterUtils.getPixelWidth(ScreenSettings.getInstance(), getWidth());
			int pixHt = ScreenConverterUtils.getPixelHeight(ScreenSettings.getInstance(), getHeight());
			int mx = (arg0.getX() - (arg0.getX() % pixWid)) / pixWid;
			int my = (arg0.getY() - (arg0.getY() % pixHt)) / pixHt;
			int tilesDown = ScreenConverterUtils.getHorizontalSplits(this.getHeight() / pixHt, ScreenSettings.getInstance().getResHeight());
			int tilesAcross = ScreenConverterUtils.getVerticalSplits(this.getWidth() / pixWid, ScreenSettings.getInstance().getResWide());
			int clipWidth = (tilesAcross > 0 ? this.getWidth() / (tilesAcross) : this.getWidth()) / pixWid;
			int clipHeight = (tilesDown > 0 ? this.getHeight() / (tilesDown) : this.getHeight()) / pixHt;

			int xOffset = (mx - (mx % clipWidth)) / ((clipWidth));
			
			int yOffset = (my - (my % clipHeight)) / ((clipHeight));

			int trany = my - yOffset;
			int tranx = mx - xOffset;
			fireEvent(new LeftClickEvent(tranx, trany));
		}
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		fireEvent(new KeyTypedEvent(arg0));
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		if(arg0.getKeyCode() == KeyEvent.VK_ESCAPE){
			System.exit(0);
		}
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fireEvent(IInputEvent event) {
		for(int i = 0, n = ioHandlers.size(); i < n; i++){
			ioHandlers.get(i).processEvent(event);
		}
		
	}

	@Override
	public void addIIOHandler(IIOHandler handler) {
		ioHandlers.add(handler);
		
	}

	@Override
	public int getHandlerCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void removeHandler(int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeAllHandlers() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {

		int tranx = arg0.getX();
		int trany = arg0.getY();
		if(trany <= 50 && previousPoint.getY() > 50){
			fireEvent(new MouseEnteredHudAreaEvent());
		}
		else if(previousPoint.getY() <= 50 && trany > 50){
			fireEvent(new MouseExitedHudAreaEvent());
		}
		else{
			fireEvent(new MouseMovedEvent(previousPoint, new Point(tranx, trany)));
		}
		previousPoint = new Point(tranx, trany);
		
		
		
	}
}
