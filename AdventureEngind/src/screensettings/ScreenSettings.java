package screensettings;

public class ScreenSettings implements IScreenSettings{
	private static IScreenSettings instance;
	public static IScreenSettings getInstance(){
		if(instance == null){
			instance = new ScreenSettings();
		}
		return instance;
	}
	
	
	private int width;
	private int height;
	
	private ScreenSettings(){
		width = 640;
		height = 480;
	}
	
	
	
	public int getResWide(){
		return width;
	}
	public void setResWide(int width){
		this.width = width;
	}
	@Override
	public int getResHeight() {
		return height;
	}
	@Override
	public void setResHeight(int height) {
		this.height = height;
		
	}
	
}
