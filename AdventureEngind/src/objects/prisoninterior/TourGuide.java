package objects.prisoninterior;

import java.awt.Point;

import commands.concretecommands.IObjectCommand;
import commands.concretecommands.IObjectCommandContext;
import commands.concretecommands.ObjectCommandContext;
import commands.concretecommands.ObjectCommandRegistry;

import objects.ConcreteDrawableObject;
import objects.IGameObject;
import objects.IGameObject.InternalObjectStates;
import objects.optiondialogue.OptionDialogue;
import renderingpolicies.TransparencyPolicy;
import scripts.ConcreteScriptRunner;
import scripts.IScriptRunner;
import scripts.IScriptableObject;
import scripts.gamescripts.EOTScript;
import scripts.gamescripts.GetSelectionScript;
import scripts.gamescripts.MessageScript;
import scripts.gamescripts.RemoveObjectFromModelByClassScript;
import scripts.prisontourscript.YesTourRunner;

public class TourGuide extends ConcreteDrawableObject implements IScriptableObject{
	@Override
	public Point getHotSpot() {
		super.getHotSpot();
		return new Point((int)(getWidth() / 2 + getX()), (int)(getHeight() + getY()));
	}

	@Override
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
		
		/*IObjectCommand command = ObjectCommandRegistry.getInstance().getCommand(this, super.getInternalState());
		IObjectCommandContext context = new ObjectCommandContext();
		if(getWayPointCount() == 0){
			return;
		}
		for(int i = 0, n = getWayPointCount() - 1; i < n; i++){
			removeWayPoint(0);
		}
		Point goalPoint = getWayPoint(0);
		Point hotSpot = getHotSpot();
		int dx = (int) (goalPoint.getX() - hotSpot.getX());
		int dy = (int) (goalPoint.getY() - hotSpot.getY());
		int xVelocity = 5;
		int yVelocity = 5;
		if(Math.abs(dx) < xVelocity){
			xVelocity = Math.abs(dx);
		}
		if(Math.abs(dy) < yVelocity){
			yVelocity = Math.abs(dy);
		}
		int xIncrement = dx != 0 ? (Math.abs(dx) / dx) * xVelocity : 0;
		setX(getX() + xIncrement);
		int yIncrement = dy != 0 ? (Math.abs(dy) / dy * yVelocity) : 0;
		setY(getY() + yIncrement);
		if(hotSpot.equals(goalPoint)){
			removeWayPoint(0);
			setInternalState(InternalObjectStates.DEFAULT_STATE);
		}*/
	}

	public TourGuide(){
		super.setSpriteFile(".\\images\\prisoninterior\\tourguide.bmp");
		super.addImagePolicy(new TransparencyPolicy(0xFFFA45EC));
	}

	@Override
	public IScriptRunner getActionScript() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IScriptRunner getLookScript() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IScriptRunner getTalkScript(IGameObject object) {
		ConcreteScriptRunner talkToTourGuideScript = new ConcreteScriptRunner();
		talkToTourGuideScript.addScript(new MessageScript("This is a test"));
		GetSelectionScript script = new GetSelectionScript(new OptionDialogue(new String[]{"Yes", "Yes"}, "Would you like to take a tour of the prison"));
		script.addScriptMapping(0, new YesTourRunner());
		script.addScriptMapping(1, new YesTourRunner());
		talkToTourGuideScript.addScript(script);
		
		talkToTourGuideScript.addScript(new EOTScript());
		
		return talkToTourGuideScript;
	}

	@Override
	public IScriptRunner getItmScript(IGameObject object) {
		// TODO Auto-generated method stub
		return null;
	}
}
