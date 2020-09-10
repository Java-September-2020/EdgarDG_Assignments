public class Bat extends Mammal {
    //init fields

	//constructor
	public Bat() {
		this.energyLevel = 300;
	}
	
    //methods
    public void fly() {
        System.out.println("A gust of wind batters everything around the Bat as it takes off in flight! Lost 50 Energy.");
        setEnergyLevel(getEnergyLevel() - 50);
    }
    public void eatHumans() {
        System.out.println("Bat has eaten a human! Oh the humanity!!! Gains 25 Energy.");
        setEnergyLevel(getEnergyLevel() + 25);
		if(this.getEnergyLevel() > 300) {
			System.out.println("Already full. At Max Energy!");
			setEnergyLevel(300);
		}
    }
    public void attackTown() {
        System.out.println("In the wake of the Bat, the fire burns in eery silence. The only sounds are of burning buildings and dying embers. Lost 100 Energy.");
        setEnergyLevel(getEnergyLevel() - 100);
        
    }
}