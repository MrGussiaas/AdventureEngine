package objects.inventorywindow;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import objects.ConcreteDrawableObject;
import objects.IDrawableObject;
import objects.IGameObject;
import objects.IInterfaceableObject;
import objects.savegamedialoge.IListBox;
import objects.savegamedialoge.IListCel;
import objects.savegamedialoge.IScrollButton;
import objects.savegamedialoge.ISelectionListener;
import objects.savegamedialoge.ListBox;
import objects.savegamedialoge.ScrollDownBtn;
import objects.savegamedialoge.ScrollUpBtn;
import objects.settingswindow.CancelButton;
import objects.settingswindow.CommandButton;
import objects.settingswindow.SaveButton;
import screensettings.ScreenConverterUtils;
import screensettings.ScreenSettings;
import testgame.Apple;
import testgame.AvatarObject;
import testgame.SnackDesk;

public class InventoryWindow extends ConcreteDrawableObject implements IInterfaceableObject, ISelectionListener{
	private static IGameObject instance;
	private IListBox listBox = new ListBox(6, 3);
	private IDrawableObject okBtn = new SaveButton("OK");
	private IDrawableObject cancelBtn = new CancelButton("Cancel");
	private IDrawableObject scrollUpBtn = new ScrollUpBtn();
	private IDrawableObject scrollDownBtn = new ScrollDownBtn();
	private Object activeItem;

	
	public static IGameObject getInstance(){
		if(instance == null){
			instance = new InventoryWindow();
		}
		return instance;
	}
	
	
	public IListBox getListBox(){
		return listBox;
	}
	
	private InventoryWindow(){
		int width = 280;
		int height = 200;
		super.setWidth(width);
		super.setHeight(height);
		int headerMargins = 55;
		Rectangle topRect = new Rectangle(0, 0, width, headerMargins);
		Rectangle midRec = new Rectangle(0, headerMargins, width, height - headerMargins * 2);
		Rectangle interfaceRect = new Rectangle(0, 0, width / 4, headerMargins);
		listBox.setWidth(192);
		listBox.setHeight(96);
		
		Point listPoint = ScreenConverterUtils.computeCenter(midRec, listBox);
		listBox.setX(listPoint.getX());
		listBox.setY(listPoint.getY() + headerMargins);

		listBox.addSelectionListener(this);

		
		Point point = ScreenConverterUtils.computeCenter(ScreenSettings.getInstance(), this);
		Point okPoint = ScreenConverterUtils.computeCenter(interfaceRect, okBtn);
		Point cancelPoint = ScreenConverterUtils.computeCenter(interfaceRect, cancelBtn);
		Point scrollUpPoint = ScreenConverterUtils.computeCenter(interfaceRect, scrollUpBtn);
		Point scrollDownPoint = ScreenConverterUtils.computeCenter(interfaceRect, scrollDownBtn);

		int yOffSet = (int) (getHeight() - headerMargins);
		int xOffSet = 4;
		okBtn.setX(okPoint.getX() + xOffSet);
		okBtn.setY(okPoint.getY() + yOffSet);
		cancelBtn.setX(cancelPoint.getX() + interfaceRect.getWidth() + xOffSet);
		cancelBtn.setY(cancelPoint.getY() + yOffSet);
		scrollUpBtn.setX(scrollUpPoint.getX() + interfaceRect.getWidth() * 2 + xOffSet);
		scrollUpBtn.setY(scrollUpPoint.getY() + yOffSet);
		scrollDownBtn.setX(scrollDownPoint.getX() + interfaceRect.getWidth() * 3 + xOffSet);
		scrollDownBtn.setY(scrollDownPoint.getY() + yOffSet);
		IScrollButton castedBtn = (IScrollButton) scrollUpBtn;
		IScrollButton castedDownBtn = (IScrollButton) scrollDownBtn;
		
		castedBtn.addITriggerHandler(listBox);
		castedDownBtn.addITriggerHandler(listBox);
		
		addContainedObject(listBox);
		addContainedObject( okBtn);
		addContainedObject( cancelBtn);
		addContainedObject( scrollUpBtn);
		addContainedObject( scrollDownBtn);
		
		super.setX(point.getX());
		super.setY(point.getY());
	}
	public Image createImage() {
		int width = (int) getWidth();
		int height = (int) getHeight();
		BufferedImage bufImage = new BufferedImage((int)getWidth(), (int)getHeight(), BufferedImage.TYPE_3BYTE_BGR);;
		Graphics g = bufImage.getGraphics();
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, width, height);
		g.setColor(Color.black);

		g.drawLine(0, 0, 0, height);
		g.drawLine(1, 1, 1, height);
		g.drawLine(2, 2, 2, height);
		g.drawLine(0, height, width - 1, height);
		g.drawLine(0, height - 1, width - 2, height - 1);
		g.drawLine(0, height - 2, width - 3, height - 2);
		g.drawImage(okBtn.createImage(), (int)okBtn.getX(), (int)okBtn.getY(), null);
		g.drawImage(cancelBtn.createImage(), (int)cancelBtn.getX(), (int)cancelBtn.getY(), null);
		g.drawImage(scrollDownBtn.createImage(), (int)scrollDownBtn.getX(), (int)scrollDownBtn.getY(), null);
		g.drawImage(scrollUpBtn.createImage(), (int)scrollUpBtn.getX(), (int)scrollDownBtn.getY(), null);
		
		
		
		g.setColor(new Color(180, 180, 180));
		g.drawLine(1, 0, width, 0);
		g.drawLine(2, 1, width, 1);
		g.drawLine(3, 2, width, 2);
		
		g.drawLine(width, 0, width, height);
		g.drawLine(width - 1, 0, width - 1, height - 1);
		g.drawLine(width - 2, 0, width - 2, height - 2);
		g.setColor(Color.black);
		g.drawImage(listBox.createImage(), (int)listBox.getX(), (int)listBox.getY(), null);
		return bufImage;
	}


	@Override
	public void mouseLeft() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseUp() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent event) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Object getValue() {
		return activeItem;
	}


	@Override
	public void selectionChanged(IListCel cel) {
		activeItem = cel.getValue();
		
	}


	@Override
	public void setValue(Object object) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited() {
		// TODO Auto-generated method stub
		
	}

}
