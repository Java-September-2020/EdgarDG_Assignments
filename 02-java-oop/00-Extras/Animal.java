
public class Animal {
	//attributes
	private String species;
	private char gender;
	private int health;
	
	//constructor
	public Animal() {
		
	}
	public Animal(String species, char gender) {
		this.species = species;
		this.gender = gender;
	}
	
	//methods
	public void battle(String powerMove, Animal target) {
		
	}
	
	
	//Getters and Setters
	public String getSpecies() {
		return this.species;
	}
	public char getGender() {
		return this.gender;
	}
	public int getHealth() {
		return this.health;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public void setHealth(int health) {
		this.health = health;
	}
}
