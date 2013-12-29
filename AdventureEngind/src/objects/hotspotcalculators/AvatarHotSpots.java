package objects.hotspotcalculators;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import objects.IGameObject;



public class AvatarHotSpots {
	
	private static AvatarHotSpots instance;
	
	public static AvatarHotSpots getInstance(){
		if(instance == null){
			instance = new AvatarHotSpots();
		}
		return instance;
	}
	
	public IHotSpotCalculator getCalculator(IGameObject.InternalObjectStates state){
		IHotSpotCalculator answer = calculators.get(state);
		if(answer == null){
			return DEFAULT_CALCULATOR;
		}
		else{
			return answer;
		}
	}
	
	private AvatarHotSpots(){
		calculators.put(IGameObject.InternalObjectStates.HIT_BY_A_TRUCK_STATE, new IHotSpotCalculator(){

			@Override
			public Point computeHotSpot(IGameObject object) {
				return new Point((int)object.getX() + 5, (int)object.getY() + 5);
			}
			
		});
	}
	
	private static final IHotSpotCalculator DEFAULT_CALCULATOR = new IHotSpotCalculator(){

		public Point computeHotSpot(IGameObject object) {
			return new Point((int)(object.getWidth() / 2 + object.getX()), (int)(object.getHeight() + object.getY()));
		}
		
	};
	private Map<IGameObject.InternalObjectStates, IHotSpotCalculator> calculators = new HashMap<IGameObject.InternalObjectStates, IHotSpotCalculator>(10);

}
