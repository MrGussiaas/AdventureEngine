package objects;

import java.awt.Image;

import renderingpolicies.IImagePolicy;

public interface IDrawableObject extends IGameObject {
	public void setSpriteFile(String fileName);
	public String getSpriteFile();
	public Image createImage();
	public void addImagePolicy(IImagePolicy policy);
	public IImagePolicy getPolicy(int index);
	public int getPolicyCount();
}
