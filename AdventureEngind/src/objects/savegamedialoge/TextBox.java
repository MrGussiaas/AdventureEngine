package objects.savegamedialoge;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.JOptionPane;

import objects.ConcreteDrawableObject;
import objects.IInterfaceableObject;
import trigger.ITrigger;
import trigger.ListCelChangedTrigger;

public class TextBox extends ConcreteDrawableObject implements IInterfaceableObject, ISelectionListener{



	private String text = "";
	
	
	
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
		g.setColor(Color.black);
		g.drawChars(text.toCharArray(), 0, text.length(), 10, 18);
		return bufImage;
		
		
		
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
		String acceptedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz 0123456789";
		if(event.getKeyCode() == KeyEvent.VK_BACK_SPACE){
			text = text.substring(0, text.length() - 1);
		}
		if(text.length() == 30){
			return;
		}
		char keyChar = event.getKeyChar();
		if(acceptedChars.indexOf(keyChar) >= 0){
			text = text + event.getKeyChar();
		}
		
	}

	@Override
	public Object getValue() {
		// TODO Auto-generated method stub
		return text;
	}

	@Override
	public void selectionChanged(IListCel cel) {
		text =cel.getValue().toString();
		
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
