package objects.hoverbutton;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import objects.ConcreteDrawableObject;
import objects.IInterfaceableObject;
import objects.savegamedialoge.IListCel;
import objects.savegamedialoge.ISelectionListener;

public class HoverButton extends ConcreteDrawableObject implements
		IInterfaceableObject, IListCel {

	private String text;
	private List<ISelectionListener> listeners = new ArrayList<ISelectionListener>(10);
	private static final int CHAR_WIDTH = 10;
	private static final int CHAR_HEIGHT = 10;
	private Color textColor = Color.BLACK;
	private Object id;
	
	@Override
	public Image createImage() {
		int yStart = 10;
		String[] messageLines = text.split("\n");
		int greatestLines = 0;
		for(int i = 0, n = messageLines.length; i < n; i++){
			String line = messageLines[i];
			if(line.length() > greatestLines){
				greatestLines = line.length();
			}
			
		}
		int width = greatestLines * CHAR_WIDTH + 10;
		int height = CHAR_HEIGHT * messageLines.length + 5;
		BufferedImage bufImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
		Graphics g = bufImage.getGraphics();
		g.setColor(Color.GRAY);
		
		g.fillRect(0, 0, width, height);
		g.setColor(textColor);
		g.drawRect(0, 0, width, height);
		for(int i = 0, n = messageLines.length; i < n; i++){
			g.drawChars(messageLines[i].toCharArray(), 0, messageLines[i].length(), 0, yStart);
			yStart += CHAR_HEIGHT;
		}
		return bufImage;
		
		
	}

	public HoverButton(String text, Integer id){
		this.text = text;
		this.id = id;
	}
	
	public void mouseLeft() {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseUp() {
		for(int i = 0, n = listeners.size(); i < n; i++){
			listeners.get(i).selectionChanged(this);
		}

	}

	@Override
	public void keyTyped(KeyEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getValue() {
		return id;
	}

	@Override
	public void setValue(Object object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered() {
		textColor = Color.red;
		
	}

	@Override
	public void mouseExited() {
		textColor = Color.black;
		
	}

	@Override
	public boolean isSelected() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setSelected(boolean selected) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addSelectionListener(ISelectionListener handler) {
		listeners.add(handler);
		
	}

	@Override
	public void removeSelectionListener(ISelectionListener handler) {
		listeners.remove(handler);
		
	}

}
