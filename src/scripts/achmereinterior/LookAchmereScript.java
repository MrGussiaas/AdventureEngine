package scripts.achmereinterior;

import scripts.ConcreteScriptRunner;
import scripts.gamescripts.EOTScript;
import scripts.gamescripts.MessageScript;

public class LookAchmereScript extends ConcreteScriptRunner {
	public LookAchmereScript(){
		addScript(new MessageScript("It is Achmere Ala King Mustafo the sole propietor of this fine establishment\n"));
		addScript(new EOTScript());
	}
}
