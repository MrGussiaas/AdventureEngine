package scripts.achmereinterior;

import scripts.ConcreteScriptRunner;
import scripts.gamescripts.EOTScript;
import scripts.gamescripts.MessageScript;

public class LookBeerScript extends ConcreteScriptRunner {
	public LookBeerScript(){
		addScript(new MessageScript("A cooler filled with all of the fine brews the world has to offer\n"+
				"If you were not a man with an important mission / no money you would probably drink them all."));
		addScript(new EOTScript());
	}
}
