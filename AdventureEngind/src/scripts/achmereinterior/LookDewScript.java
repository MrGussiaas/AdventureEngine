package scripts.achmereinterior;

import scripts.ConcreteScriptRunner;
import scripts.gamescripts.EOTScript;
import scripts.gamescripts.MessageScript;

public class LookDewScript extends ConcreteScriptRunner {
	public LookDewScript(){
		addScript(new MessageScript("This cooler is filled with the finest stuff on Earth, Mountain Dew, the nectar of the Gods. . ."));
		addScript(new MessageScript("The fuel of the Phoenix. . ."));
		addScript(new MessageScript("The Strength of Hercules. . ."));
		addScript(new MessageScript("The only reason to get out of bed."));
		addScript(new EOTScript());
	}
}
