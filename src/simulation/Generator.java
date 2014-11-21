package simulation;

import java.util.Random;

public class Generator {
	Random random = new Random();
	
	public int neuerGastDauer(){
		return random.nextInt(15)+15;
	}
	
	public int notierenDauer(){
		return random.nextInt(3)+3;
	}
	
	public int kassierenDauer(){
		return random.nextInt(3)+3;
	}
	
	public int servierenDauer(){
		return random.nextInt(3)+3;
	}
	
	public int zubereitungsDauer(){
		return random.nextInt(30)+20;
	}
	
	public int essenDauer(){
		return random.nextInt(60)+60;
	}
	
}
