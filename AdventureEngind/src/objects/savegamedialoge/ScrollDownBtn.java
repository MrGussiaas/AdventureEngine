package objects.savegamedialoge;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import objects.settingswindow.CommandButton;
import trigger.ITriggerHandler;
import trigger.ScrollDownTrigger;

public class ScrollDownBtn extends CommandButton implements IScrollButton{
	private BufferedImage upImage;
	private BufferedImage downImage;
	private boolean clicked;
	private List<IScrollBarListener> handlers = new ArrayList<IScrollBarListener>(10);
	public ScrollDownBtn(){
		try {
			upImage = ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"scrolldownbtn_up.bmp"));
			downImage = ImageIO.read(new File(globalvariables.constants.IMAGE_LOCATION+"scrolldownbtn_down.bmp"));
			setWidth(upImage.getWidth());
			setHeight(upImage.getHeight());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Image createImage() {
		return clicked ? downImage : upImage;
	}

	@Override
	public void mouseUp() {
		clicked = false;
		for(int i = 0, n = handlers.size(); i < n; i++){
			handlers.get(i).scrollDown();
		}
	}

	@Override
	public void mouseLeft() {
		clicked = true;
	}

	@Override
	public void addITriggerHandler(IScrollBarListener handler) {
		handlers.add(handler);
		
	}


}
