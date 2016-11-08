
public class Agent {
	public Integer score, energy, ammo;
	public Integer x,y;
	public Integer orientation;
	public Integer pokemonsCaptured;
	public boolean in_game;
	public Agent(){
		score = 0;
		energy = 100;
		ammo = 5;
		x = 1;
		y = 1;
		in_game = true;
	}
	public void updateAgent(Integer new_score, Integer new_energy, Integer new_ammo,Integer new_x, Integer new_y, Integer new_orientation, Integer new_pokemonsCaptured){
		score = new_score;
		ammo = new_ammo;
		energy = new_energy;
		x = new_x;
		y = new_y;
		orientation = new_orientation;
		pokemonsCaptured = new_pokemonsCaptured;
	}
}
