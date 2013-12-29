package scripts.achmereinterior;

import scripts.ConcreteScriptRunner;
import scripts.gamescripts.EOTScript;
import scripts.gamescripts.MessageScript;

public class AchmereActionScript extends ConcreteScriptRunner {
	public AchmereActionScript(){
		addScript(new MessageScript("Do you really have to touch everyone?  Can't you just keep your hands to yourself?"));
		addScript(new EOTScript());
	}
}
