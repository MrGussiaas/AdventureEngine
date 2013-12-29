package objects.savegamedialoge;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import objects.ConcreteDrawableObject;
import objects.IDrawableObject;
import objects.inventorywindow.ImageCel;
import trigger.ITrigger;
import trigger.ITriggerHandler;
import trigger.ListCelChangedTrigger;
import trigger.ScrollDownTrigger;
import trigger.ScrollUpTrigger;

public class ListBox extends ConcreteDrawableObject implements IListBox {

	
	
	


	
	
	
	

	
	private IListCelFactory defaultFactory = new IListCelFactory(){

		@Override
		public IListCel createCel() {
			return new ListCel();
		}

		@Override
		public int getWidth() {
			return 200;
		}

		@Override
		public int getHeight() {
			return 25;
		}
		
	};
	private IListCelFactory imageFactory = new IListCelFactory(){

		@Override
		public IListCel createCel() {
			return new ImageCel();
		}

		@Override
		public int getWidth() {
			// TODO Auto-generated method stub
			return 32;
		}

		@Override
		public int getHeight() {
			// TODO Auto-generated method stub
			return 32;
		}
		
	};
	

	
	private IListCelFactory getCelFactory(Object object){
		if(object instanceof IDrawableObject){
			return imageFactory;
		}
		return defaultFactory;
	}
	
	private List<Object> items = new ArrayList<Object>(10);
	private List<IListCel> listCels = new ArrayList<IListCel>(10);

	private List<ISelectionListener> triggerHandlers = new ArrayList<ISelectionListener>(10);
	private int listStart;
	private int listEnd;

	private int cellsAcross = 0;
	private int cellsDown = 0;
	public ListBox(int cellsAcross, int cellsDown) {
		super();
		this.cellsAcross = cellsAcross;
		this.cellsDown = cellsDown;
		listCels = new ArrayList<IListCel>(cellsAcross * cellsDown);
	}


	
	int selectedCel;
	
	
	
	@Override
	public Image createImage() {
		int width = (int) getWidth();
		int height = (int) getHeight();
		BufferedImage bufImage = new BufferedImage((int)getWidth(), (int)getHeight(), BufferedImage.TYPE_3BYTE_BGR);;
		Graphics g = bufImage.getGraphics();
		g.setColor(Color.white);
		g.fillRect(0, 0, width, height);
		g.setColor(Color.black);
		g.drawLine(0, 0, 0, height);
		g.drawLine(1, 1, 1, height);
		g.drawLine(2, 2, 2, height);
		g.drawLine(0, height, width - 1, height);
		g.drawLine(0, height - 1, width - 2, height - 1);
		g.drawLine(0, height - 2, width - 3, height - 2);
		
		g.setColor(new Color(180, 180, 180));
		g.drawLine(1, 0, width, 0);
		g.drawLine(2, 1, width, 1);
		g.drawLine(3, 2, width, 2);
		
		g.drawLine(width, 0, width, height);
		g.drawLine(width - 1, 0, width - 1, height - 1);
		g.drawLine(width - 2, 0, width - 2, height - 2);
		
		g.setColor(Color.white);

		
		//int width = cellsAcross * CEL_WIDTH;
		//int height = cellsDown * CEL_HEIGHT;
		//BufferedImage bufImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);;
		//Graphics g = bufImage.getGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, width, height);
		int listEndOffset = cellsAcross * cellsDown;
		int itemCount = getItemCount();
		
		for(int i = listStart,j = 0, n = listStart + listEndOffset; i < n && i < itemCount; i++, j++){

			IDrawableObject object = getListCel(i);
			//int x = (int) ((j % cellsAcross) * getWidth()); 
			//int y = ((j - x) / cellsAcross) * 25;
			int x = (int) object.getX();
			int y = (int) object.getY();
			g.drawImage(object.createImage(), x, y, null);
			
		}
		return bufImage;
		
		/*for(int i = 0; i < celCount; i++){
			int celOffset = i * CEL_HEIGHT;
			int celEnd = celOffset + CEL_HEIGHT;
			int index = i + listStart;
			if(index < listCels.size()){
				IDrawableObject listCel = listCels.get(index);
				g.drawImage(listCel.createImage(), 3, (int)listCel.getY(), null);
			}
			
		}*/
		
		//return bufImage;
	}

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
		return getSelectedItem();
	}

	@Override
	public int getItemCount() {
		return items.size();
	}

	@Override
	public void addItem(Object item) {
		items.add(item);
		IListCelFactory celFactory = getCelFactory(item);
		IListCel newCel = celFactory.createCel();
		newCel.setValue(item);
		newCel.setHeight(celFactory.getHeight());
		newCel.setWidth(celFactory.getWidth());
		newCel.addSelectionListener(this);
		addContainedObject(newCel);
		
		listCels.add(newCel);
		int index = listCels.indexOf(newCel);
		newCel.setX(0);
		//newCel.setY(index * newCel.getHeight());
		double y = (int)((index - (index % cellsAcross)) / cellsAcross) * newCel.getHeight();
		newCel.setY(y);
		newCel.setX(newCel.getWidth() * (index % cellsAcross));

	}

	@Override
	public void removeItem(int index) {
		items.remove(index);
		removeContainedObject(listCels.get(index));
		listCels.get(index).removeSelectionListener(this);
		listCels.remove(index);
		

	}

	@Override
	public Object getItem(int index) {
		return items.get(index);
	}

	@Override
	public void addSelectionListener(ISelectionListener handler) {
		triggerHandlers.add(handler);

	}

	@Override
	public Object getSelectedItem() {
		return items.get(selectedCel);
	}

	@Override
	public void setSelectedItemIndex(int index) {
		this.selectedCel = index;

	}

	@Override
	public void scrollDown() {
		int newStart = listStart + 1;
		if(newStart < listCels.size()){
			for(int i = 0, n = listCels.size(); i < n; i++){
				int celHeight = (int) listCels.get(i).getHeight();
				int celY = (int) listCels.get(i).getY();
				listCels.get(i).setY(celY - celHeight);
			}
			listStart = newStart;
		}
		
	}

	@Override
	public void scrollUp() {
		int newStart = listStart - 1;
		if(newStart >= 0){
			for(int i = 0, n = listCels.size(); i < n; i++){
				int celHeight = (int) listCels.get(i).getHeight();
				int celY = (int) listCels.get(i).getY();
				listCels.get(i).setY(celY + celHeight);
			}
			listStart = newStart;
		}
		
	}

	@Override
	public void selectionChanged(IListCel cel) {
		for(int i = 0, n = listCels.size(); i < n; i++){
			listCels.get(i).setSelected(false);
		}
		for(int i = 0, n = triggerHandlers.size(); i < n; i++){
			triggerHandlers.get(i).selectionChanged(cel);
		}
		
		
	}

	@Override
	public IListCel getListCel(int index) {
		return listCels.get(index);
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
