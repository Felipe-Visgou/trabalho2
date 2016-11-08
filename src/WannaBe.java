import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class WannaBe {
	public int x,y;
	public boolean in_game;
	public int type;
	public WannaBe(int nx, int ny, int ntype){
		x = nx;
		y = ny;
		in_game = true;
		type = ntype;
	}
}
