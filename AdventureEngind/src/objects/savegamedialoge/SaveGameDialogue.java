package objects.savegamedialoge;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import objects.ConcreteDrawableObject;
import objects.IDrawableObject;
import objects.IGameObject;
import objects.IInterfaceableObject;
import objects.settingswindow.CancelButton;
import objects.settingswindow.SaveButton;
import screensettings.ScreenConverterUtils;
import screensettings.ScreenSettings;

public class SaveGameDialogue extends ConcreteDrawableObject implements IInterfaceableObject{

	public IListBox getListBox() {
		return listBox;
	}

	private static final int headerHeight = 40;
	private static final int marginWidth = 50;

	@Override
	public double getZIndex() {
		return Double.MAX_VALUE;
	}

	private BufferedImage background;
	private IDrawableObject saveBtn = new SaveButton("Save");
	private IDrawableObject cancelBtn = new CancelButton("Cancel");
	private IDrawableObject fileName = new TextBox();
	private IListBox listBox = new ListBox(1, 6);
	private IDrawableObject scrollUp = new ScrollUpBtn();
	private IDrawableObject scrollDown = new ScrollDownBtn();
	
	private static IGameObject instance;
	
	
	public static IGameObject getInstance(){
		if(instance == null){
			instance = new SaveGameDialogue();
		}
		return instance;
	}
	

	private SaveGameDialogue(){
		try {
			background = ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"StatusWindowBackground.bmp"));
			setWidth(background.getWidth());
			setHeight(background.getHeight());
			Point center = ScreenConverterUtils.computeCenter(ScreenSettings.getInstance(), this);
			setX(center.getX());
			setY(center.getY());
			fileName.setWidth(250);
			fileName.setHeight(25);
			listBox.setWidth(200);
			listBox.setHeight(150);
			//listBox.setCelCount(6);


			
			Rectangle bottomRectangle = new Rectangle(0, (int) (getHeight() - headerHeight), (int)getWidth(), headerHeight);
			Rectangle middleRect1 = new Rectangle(0, headerHeight, (int)getWidth() - marginWidth, (int)getHeight() - headerHeight * 2);
			Rectangle marginRect = new Rectangle((int)getWidth() - marginWidth, (int) middleRect1.getY(), marginWidth, (int)getHeight() - headerHeight * 2);
			int midRect = (int) (bottomRectangle.getWidth() / 2);
			Rectangle rect1 = new Rectangle(0, headerHeight, midRect, headerHeight);
			Rectangle rect2 = new Rectangle(midRect, headerHeight, midRect, headerHeight);
			Point savePoint = ScreenConverterUtils.computeCenter(rect1, saveBtn);
			Point cancelPoint = ScreenConverterUtils.computeCenter(rect2, cancelBtn);
			Point textPoint = ScreenConverterUtils.computeCenter(bottomRectangle, fileName);
			Point listPoint = ScreenConverterUtils.computeCenter(middleRect1, listBox);
			Point scrollUpPoint = ScreenConverterUtils.computeCenter(marginRect, scrollUp);
			Point scrollDownPoint = ScreenConverterUtils.computeCenter(marginRect, scrollDown);
			saveBtn.setX(savePoint.getX());
			saveBtn.setY(getHeight() - headerHeight + savePoint.getY());
			cancelBtn.setX(midRect + cancelPoint.getX());
			cancelBtn.setY(getHeight() - headerHeight + cancelPoint.getY());
			listBox.setX(listPoint.getX());
			listBox.setY(listPoint.getY() + headerHeight);
			IScrollButton upScroll = (IScrollButton) scrollUp;
			IScrollButton downScroll = (IScrollButton) scrollDown;
			upScroll.addITriggerHandler(listBox);
			downScroll.addITriggerHandler(listBox);
			listBox.addSelectionListener((ISelectionListener) fileName);
			fileName.setX(textPoint.getX());
			fileName.setY(textPoint.getY());
			scrollUp.setX(scrollUpPoint.getX() + getWidth() - marginWidth);
			scrollUp.setY(headerHeight + 10);
			scrollDown.setX(scrollDownPoint.getX() + getWidth() - marginWidth);
			scrollDown.setY(getHeight() - headerHeight - 40);
			addContainedObject(saveBtn);
			addContainedObject(cancelBtn);
			addContainedObject(fileName);
			addContainedObject(listBox);
			addContainedObject(scrollUp);
			addContainedObject(scrollDown);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Image createImage() {
		int width = (int)getWidth();
		int height = (int)getHeight();
		BufferedImage answer = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);

		
		Graphics g = answer.getGraphics();
		g.drawImage(background, 0, 0, null);
		g.drawImage(saveBtn.createImage(), (int)saveBtn.getX(), (int)saveBtn.getY(), null);
		g.drawImage(cancelBtn.createImage(), (int)cancelBtn.getX(), (int)cancelBtn.getY(), null);
		g.drawImage(fileName.createImage(), (int)fileName.getX(), (int)fileName.getY(), null);
		g.drawImage(listBox.createImage(), (int)listBox.getX(), (int)listBox.getY(), null);
		g.drawImage(scrollUp.createImage(), (int)scrollUp.getX(), (int)scrollUp.getY(), null);
		g.drawImage(scrollDown.createImage(), (int)scrollDown.getX(), (int)scrollDown.getY(), null);
		return answer;
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
		IInterfaceableObject castedObject = (IInterfaceableObject) fileName;
		castedObject.keyTyped(event);
		
	}

	@Override
	public Object getValue() {
		IInterfaceableObject castedObject = (IInterfaceableObject) fileName;
		return castedObject.getValue();
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
