package objects.inventorywindow;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import objects.IDrawableObject;
import objects.savegamedialoge.ListBox;

public class GridList extends ListBox {

	private int cellsAcross = 0;
	private int cellsDown = 0;
	private int listStart = 0;
	private static final int CEL_HEIGHT = 32;
	private static final int CEL_WIDTH = 32;
	

	
	public GridList(int cellsAcross, int cellsDown) {
		super(cellsAcross, cellsDown);
		this.cellsAcross = cellsAcross;
		this.cellsDown = cellsDown;
	}

	@Override
	public double getHeight() {
		return CEL_HEIGHT * cellsDown;
	}

	@Override
	public double getWidth() {
		return CEL_WIDTH * cellsAcross;
	}

	public int getCellsAcross() {
		return cellsAcross;
	}

	public void setCellsAcross(int cellsAcross) {
		this.cellsAcross = cellsAcross;
	}

	public int getCellsDown() {
		return cellsDown;
	}

	public void setCellsDown(int cellsDown) {
		this.cellsDown = cellsDown;
	}

	public Image createImage() {
		int width = cellsAcross * CEL_WIDTH;
		int height = cellsDown * CEL_HEIGHT;
		BufferedImage bufImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);;
		Graphics g = bufImage.getGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, width, height);
		int listEndOffset = cellsAcross * cellsDown;
		int itemCount = super.getItemCount();
		
		for(int i = listStart,j = 0, n = listStart + listEndOffset; i < n && i < itemCount; i++, j++){
			int x = (j % cellsAcross) * CEL_WIDTH; 
			int y = ((j - x) / cellsAcross) * CEL_HEIGHT;
			IDrawableObject object = super.getListCel(i);
			g.drawImage(object.createImage(), x, y, null);
			
		}
		return bufImage;
	}

	@Override
	public Object getSelectedItem() {
		// TODO Auto-generated method stub
		return super.getSelectedItem();
	}

	@Override
	public void scrollDown() {
		// TODO Auto-generated method stub
		super.scrollDown();
	}

	@Override
	public void scrollUp() {
		// TODO Auto-generated method stub
		super.scrollUp();
	}

}
