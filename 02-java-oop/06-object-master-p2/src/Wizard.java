
public class Wizard extends Human {
	//init fields
	
	//constructor
	public Wizard() {
		this.setHealth(50);
		this.setIntelligence(8);
	}
	//methods
	public void heal(Human otherHuman) {
		otherHuman.setHealth(otherHuman.getHealth() + this.getIntelligence());
	}
	public void fireball(Human otherHuman) {
		otherHuman.setHealth(otherHuman.getHealth() - (this.getIntelligence() * 3));
	}
	//setters and getters
}
