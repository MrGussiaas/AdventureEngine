package trigger.processors;

import javax.swing.JOptionPane;

import objects.IGameObject;
import objects.IInterfaceableObject;
import objects.hudbar.HudBar;
import objects.inventorywindow.InventoryWindow;

import trigger.ITrigger;
import trigger.ITriggerProcessor;
import ui.IGameModel;

public class SetActiveInventoryProcessor implements ITriggerProcessor {

	@Override
	public void processTrigger(ITrigger trigger, IGameModel model) {
		IInterfaceableObject casted = (IInterfaceableObject) InventoryWindow.getInstance();
		model.setActiveInventoryItem((IGameObject) casted.getValue());
		HudBar castedHudBar = (HudBar) HudBar.getInstance();
		castedHudBar.setInventoryObject((IGameObject) casted.getValue());

	}

}
