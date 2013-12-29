package commands.runners;

import commands.concretecommands.CommandMapCommandSettings;
import commands.concretecommands.ObjectMapNewObjectCommand;
import commands.concretecommands.ObjectMapNewObjectSettings;
import commands.concretecommands.PopPreviousCommand;
import commands.concretecommands.QuitGameCommand;
import commands.concretecommands.SendMouseUpCommand;
import commands.concretecommands.TriggerCommandSettings;

public class SettingsLeftClickRunner extends ConcreteRunner {
	public SettingsLeftClickRunner(){
		//addCommand(new PopPreviousCommand());
		addCommand(new SendMouseUpCommand());
		
		addCommand(new ObjectMapNewObjectSettings());
		addCommand(new TriggerCommandSettings());
		addCommand(new CommandMapCommandSettings());
		addCommand(new QuitGameCommand());
	}
}
