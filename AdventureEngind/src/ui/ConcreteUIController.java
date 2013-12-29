package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import objects.ConcreteDrawableObject;
import objects.IBarrierObject;
import objects.IDrawableObject;
import objects.IGameObject;
import objects.MessageBoxObject;
import screensettings.ScreenConverterUtils;
import screensettings.ScreenSettings;
import trigger.ITrigger;
import trigger.ITriggerDescriptor;
import trigger.ITriggerHandler;
import trigger.ITriggerProcessor;
import trigger.processors.ControllerProcessors;

public class ConcreteUIController implements IUIController {

	private Image view;
	private IGameModel model = null;
	private List<ITriggerHandler> triggerHandlers = new ArrayList<ITriggerHandler>(10);
	private static final Comparator<IGameObject> Y_SORTER = new Comparator<IGameObject>(){

		@Override
		public int compare(IGameObject arg0, IGameObject arg1) {
			double y1 = arg0.getZIndex();
			double y2 = arg1.getZIndex();
			Double d1 = new Double(y1);
			Double d2 = new Double(y2);
			return d1.compareTo(d2);
		}
		
	};
	
	

	private TestFrame viewFrame = null;
	public ConcreteUIController(TestFrame viewFrame){
		view = new BufferedImage((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight(), BufferedImage.TYPE_3BYTE_BGR);
		this.viewFrame = viewFrame;
	}
	
	public Image getView() {
		return view;
	}

	
	public void refreshView() {
		Graphics graphics = view.getGraphics();
		Rectangle clipSize = new Rectangle(0, 0, ScreenSettings.getInstance().getResWide(), ScreenSettings.getInstance().getResHeight());
		clipSize = ScreenConverterUtils.getScaledDimension(clipSize, ScreenSettings.getInstance());
		graphics.setClip((int)clipSize.getX(), (int)clipSize.getY(), (int)clipSize.getWidth(), (int)clipSize.getHeight());
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, view.getWidth(null), view.getHeight(null));
		model.sortObjects(Y_SORTER);

		IDrawableObject bgObject = model.getBackgroundObject();
		
		if(bgObject != null){
			Image image = bgObject.createImage();
			Rectangle scaledDim = ScreenConverterUtils.getScaledDimension(bgObject, ScreenSettings.getInstance());
			int x = (int) scaledDim.getX();
			int y = (int) scaledDim.getY();
			int width = (int) scaledDim.getWidth();
			int height = (int) scaledDim.getHeight();
			graphics.drawImage(image, x, y, x+width, y+height, 0, 0, (int)bgObject.getWidth(), (int)bgObject.getHeight(), null);
		
		}
		
		for(int i = 0, n = model.getObjectCount(); i < n; i++){
			if(!(model.getObject(i) instanceof IDrawableObject)){
				continue;
			}
			ConcreteDrawableObject object = (ConcreteDrawableObject) model.getObject(i);
			Image image = object.createImage();
			Rectangle scaledDim = ScreenConverterUtils.getScaledDimension(object, ScreenSettings.getInstance());
			int x = (int) scaledDim.getX();
			int y = (int) scaledDim.getY();
			int width = (int) scaledDim.getWidth();
			int height = (int) scaledDim.getHeight();
			graphics.drawImage(image, x, y, x+width, y+height, 0, 0, (int)object.getWidth(), (int)object.getHeight(), null);
			graphics.setColor(Color.BLACK);
			
			graphics.drawRect((int)object.getHotSpot().getX() * ScreenConverterUtils.getPixelWidth(ScreenSettings.getInstance()), (int)object.getHotSpot().getY() * ScreenConverterUtils.getPixelHeight(ScreenSettings.getInstance()), 5, 5);
			//graphics.drawImage(img, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, observer)
			//graphics.drawImage(image, x, y, null);
			
			
		}
		
		graphics.setColor(Color.cyan);
		for(int i = 0, n = model.getTriggerCount(); i < n; i++){
			ITrigger trigger = model.getTrigger(i);
			Rectangle dimRect = ScreenConverterUtils.getScaledDimension(trigger, ScreenSettings.getInstance());
			int x = (int) dimRect.getX();
			int y = (int) dimRect.getY();
			int width = (int) dimRect.getWidth();
			int height = (int) dimRect.getHeight();
			graphics.fillRect(x, y, width, height);
		}
		
		
		for(int i = 0, n = model.getBarrierCount(); i < n; i++){
			graphics.setColor(Color.pink);
			IBarrierObject barrier = model.getBarrier(i);
			Rectangle dimRect = ScreenConverterUtils.getScaledDimension(barrier, ScreenSettings.getInstance());
			int x = (int) dimRect.getX();
			int y = (int) dimRect.getY();
			int width = (int) dimRect.getWidth();
			int height = (int) dimRect.getHeight();
			graphics.fillRect(x, y, width, height);
			graphics.setColor(Color.black);
			int cx = x + (width / 2) - 5;
			int cy = y + (height / 2) - 5;
			graphics.drawString(""+i, cx, cy);
		}
		
		viewFrame.setCursor(model.getCursor());
		if(model.getOnScreenMessage() != null){
			IDrawableObject message = new MessageBoxObject(model.getOnScreenMessage());
			graphics.drawImage(message.createImage(), 25, 100, null);
		}
		List<Point> l1 = new ArrayList<Point>(10);
		l1.add(model.getAvatar().getHotSpot());
		for(int i = 0, n = model.getAvatar().getWayPointCount(); i < n; i++){
			l1.add(model.getAvatar().getWayPoint(i));
		}
		for(int i = 1, n = l1.size(); i < n; i++){
			Point p1 = l1.get(i - 1);
			Point p2 = l1.get(i);
			graphics.setColor(Color.cyan);
			graphics.fillRect((int)p2.getX() * 2, (int)p2.getY() * 2, 10 ,10) ;
			graphics.setColor(Color.black);
			graphics.drawString(""+i, (int)p2.getX() * 2 + 5, (int)p2.getY() * 2 + 5);
		}

		

	}

	
	public void setView(Image view) {
		this.view = view;

	}

	@Override
	public void setModel(IGameModel model) {
		this.model = model;

	}

	@Override
	public IGameModel getModel() {
		// TODO Auto-generated method stub
		return model;
	}

	@Override
	public void handleTrigger(ITrigger trigger) {
		ITriggerProcessor processor = ControllerProcessors.getInstance().getProcessor(trigger);
		processor.processTrigger(trigger, model);
		for(int i = 0, n = triggerHandlers.size(); i < n; i++){
			triggerHandlers.get(i).handleTrigger(trigger);
		}
		
	}

	@Override
	public void handleTrigger(IGameModel model, ITriggerDescriptor descriptor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addITriggerHandler(ITriggerHandler handler) {
		triggerHandlers.add(handler);
		
	}

}
