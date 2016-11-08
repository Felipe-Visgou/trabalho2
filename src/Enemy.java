
public class Enemy {
	public Integer damage, energy;
	public int x,y;
	public boolean in_game;
	public Enemy(int nx, int ny, int ndamage){
		energy = 100;
		x = nx;
		y = ny;
		damage = ndamage;
		in_game = true;
	}
	public void updateEnemy(Integer new_energy){
		energy = new_energy;
	}
}
