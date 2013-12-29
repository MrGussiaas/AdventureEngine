package objects.prisoninterior;

import objects.ConcreteDrawableObject;
import objects.IGameObject;
import objects.optiondialogue.OptionDialogue;
import renderingpolicies.TransparencyPolicy;
import scripts.ConcreteScriptRunner;
import scripts.IScriptRunner;
import scripts.IScriptableObject;
import scripts.gamescripts.EOTScript;
import scripts.gamescripts.GetSelectionScript;
import scripts.gamescripts.MessageScript;
import scripts.gamescripts.RemoveObjectFromModelByClassScript;

public class TourGuide extends ConcreteDrawableObject implements IScriptableObject{
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
		talkToTourGuideScript.addScript(new GetSelectionScript(new OptionDialogue(new String[]{"Yes", "Yes"}, "Would you like to take a tour of the prison")));
		talkToTourGuideScript.addScript(new RemoveObjectFromModelByClassScript(OptionDialogue.class));
		talkToTourGuideScript.addScript(new EOTScript());
		
		return talkToTourGuideScript;
	}

	@Override
	public IScriptRunner getItmScript(IGameObject object) {
		// TODO Auto-generated method stub
		return null;
	}
}
