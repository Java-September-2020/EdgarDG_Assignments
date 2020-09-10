
public class Gorilla extends Mammal {
	//init fields
	
	//methods
	public void throwSomething() {
		System.out.println("Gorilla has thrown a ball. Lost 5 energy.");
		this.setEnergyLevel(this.getEnergyLevel() - 5);
	}
	public void eatBananas() {
		System.out.println("Gorilla has eaten a delicious banana. They're happy! Gained 10 Energy.");
		this.setEnergyLevel(this.getEnergyLevel() + 10);
		if(this.getEnergyLevel() > 100) {
			System.out.println("Already full. At Max Energy!");
			setEnergyLevel(100);
		}
	}
	public void climb() {
		System.out.println("Gorilla has climbed a majestic tree. They're a little tired. Lost 10 Energy.");
		this.setEnergyLevel(this.getEnergyLevel() - 10);
	}
}