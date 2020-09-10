
public class Human {
	//init fields
	private int strength = 3;
	private int stealth = 3;
	private int intelligence = 3;
	private int health = 100;
	
	//constructors
	
	//methods
	public void attackHuman(Human otherHuman) {
		System.out.println("POW! You have punched them with all your strength!");
		otherHuman.setHealth(otherHuman.getHealth() - this.getStrength());
	}
	
	//getters and setters
	public int getStrength() {
		return this.strength;
	}
	public int getStealth() {
		return this.stealth;
	}
	public int getIntelligence() {
		return this.intelligence;
	}
	public int getHealth() {
		return this.health;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public void setStealth(int stealth) {
		this.stealth= stealth;
	}
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
	public void setHealth(int health) {
		this.health = health;
	}
}
