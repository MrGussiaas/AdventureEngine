package renderingpolicies;

import java.awt.Image;

public interface IImagePolicy extends IPolicy {
	public Image renderImage(Image img);
}
