package testgame;

import java.awt.Font;
import java.awt.GraphicsEnvironment;

public class FontTest {
	public static void main(String[] args){
		Font[] f = GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
		for(int i = 0, n = f.length; i < n; i++){
			System.out.println(f[i].getFontName());
		}
	}
}
