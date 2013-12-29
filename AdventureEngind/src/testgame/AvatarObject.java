package testgame;

import io.DefaultImageMaker;

import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import commands.ICommand;
import commands.concretecommands.IObjectCommand;
import commands.concretecommands.IObjectCommandContext;
import commands.concretecommands.ObjectCommandContext;
import commands.concretecommands.ObjectCommandRegistry;
import commands.concretecommands.WalkToCommand;

import objects.ConcreteDrawableObject;
import objects.IGameObject;
import objects.hotspotcalculators.AvatarHotSpots;
import ui.AvatarImageMaker;
import ui.IImageMaker;
import ui.ImageMaker;

public class AvatarObject extends ConcreteDrawableObject {
	

	private int cycleCount = 0;
	
	
	

	
	@Override
	public Point getHotSpot() {
		return AvatarHotSpots.getInstance().getCalculator(getInternalState()).computeHotSpot(this);
	}


	public AvatarObject(){
		super.setSpriteFile(".\\images\\avatardown1.bmp");
		super.setInternalState(IGameObject.InternalObjectStates.DEFAULT_STATE);	

		
	}

	
	public void update() {
		IObjectCommand command = ObjectCommandRegistry.getInstance().getCommand(this, super.getInternalState());
		IObjectCommandContext context = new ObjectCommandContext();
		if(command != null){
			command.executeCommand(context, this);
			int newX = context.getNewX();
			int newY = context.getNewY();
			if(newX == super.getX() && newY == super.getY() && getWayPointCount() > 0){
				removeWayPoint(0);
			}
			super.setX(newX);
			
			super.setY(newY);
			InternalObjectStates newState = context.getNewState();
			if(newState != null){
				super.setInternalState(newState);
			}
			
		}
		cycleCount++;
	}


	@Override
	public Image createImage() {
		IImageMaker maker = AvatarImageMaker.getInstance().getImageMaker(super.getInternalState());
		Point start = getHotSpot();
		Point end = new Point((int)getX(), (int)getY());;
		if(getWayPointCount() > 0){
			end = getWayPoint(0);
		}
		
		Image image = maker.getImage(cycleCount, start, end);
		setWidth(image.getWidth(null));
		setHeight(image.getHeight(null));
		return image;
	}
}
