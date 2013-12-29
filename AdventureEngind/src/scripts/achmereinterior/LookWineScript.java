package scripts.achmereinterior;

import scripts.ConcreteScriptRunner;
import scripts.gamescripts.EOTScript;
import scripts.gamescripts.MessageScript;

public class LookWineScript extends ConcreteScriptRunner {
	public LookWineScript(){
		addScript(new MessageScript("All of the finest wines that a convenience store has to offer"));
		addScript(new EOTScript());
	}
}
