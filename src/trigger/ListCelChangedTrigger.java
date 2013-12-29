package trigger;

import objects.savegamedialoge.IListCel;

public class ListCelChangedTrigger extends ConcreteTrigger{
	private IListCel selectedCel;
	
	public ListCelChangedTrigger(IListCel selectedCel){
		this.selectedCel = selectedCel;
	}
	
	public IListCel getSelectedCel(){
		return selectedCel;
	}
}
