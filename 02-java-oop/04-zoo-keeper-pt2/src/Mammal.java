
public class Mammal {
	//init fields
	protected int energyLevel = 100;
	
	//methods
	public int displayEnergy() {
		System.out.println("Current Energy Level: " + this.getEnergyLevel());
		return this.getEnergyLevel();
	}
	
	//constructors
	
	//getters and setters
	public int getEnergyLevel() {
		return this.energyLevel;
	}
	public void setEnergyLevel(int energy) {
		this.energyLevel = energy;
	}
}
