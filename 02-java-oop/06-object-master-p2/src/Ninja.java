
public class Ninja extends Human {
	//init fields
	
	//constructors
	public Ninja() {
		this.setStealth(10);
	}
	//methods
	public void steal(Human otherHuman) {
		int stolenHP = otherHuman.getHealth() - this.getStealth();
		otherHuman.setHealth(stolenHP);
		this.setHealth(stolenHP);
	}
	public void runAway() {
		this.setHealth(this.getHealth() - 10);
	}
	//getters and setters
}
