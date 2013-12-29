package objects.savegamedialoge;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import objects.ConcreteDrawableObject;
import objects.IGameObject;
import trigger.ITrigger;
import trigger.ITriggerHandler;
import trigger.ListCelChangedTrigger;

public class ListCel extends ConcreteDrawableObject implements IListCel {

	private Object value;
	private boolean selected;
	private List<ISelectionListener> handlers = new ArrayList<ISelectionListener>(10);
	public void mouseLeft() {
		for(int i = 0, n = handlers.size(); i < n; i++){
			handlers.get(i).selectionChanged(this);
		}
		setSelected(true);
		
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
		return value;
	}

	@Override
	public void setValue(Object value) {
		this.value = value;
		
	}

	@Override
	public Image createImage() {
		BufferedImage buff = new BufferedImage((int)getWidth(), (int)getHeight(), BufferedImage.TYPE_3BYTE_BGR);
		Graphics g = buff.getGraphics();
		Color bg = selected ? Color.BLACK : Color.white;
		Color fg = selected ? Color.WHITE : Color.black;
		int x = (int) getX();
		int y = (int) getY();
		int width = (int) getWidth();
		int height = (int) getHeight();
		g.setColor(bg);
		g.fillRect(x, 0, width, height);
		g.setColor(fg);
		if(value != null){
			g.drawString(value.toString(), 10, 18);
		}
		
		return buff;
		
	}
	@Override
	public boolean isSelected() {
		return selected;
	}
	@Override
	public void setSelected(boolean selected) {

		this.selected = selected;
		
	}

	@Override
	public void addSelectionListener(ISelectionListener handler) {
		handlers.add(handler);
		
	}

	@Override
	public void removeSelectionListener(ISelectionListener handler) {
		handlers.remove(handler);
		
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
