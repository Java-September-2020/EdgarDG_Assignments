
public class Samurai extends Human{
	//init fields
	private static int samuraiCount;
	
	//constructors
	public Samurai() {
		this.setHealth(200);
		samuraiCount++;
	}
	
	//methods
	public void meditate() {
		this.setHealth(this.getHealth() / 2);
	}
	public void deathBlow(Human otherHuman) {
		otherHuman.setHealth(0);
		//Literally would be this.getHealth() / 2 -- but that's too OP. So, - half of MAX HP = 100
		this.setHealth(this.getHealth() - 100);
	}
	public String howMany() {
		return "There are currently " + this.getSamuraiCount() + " Samurai present.";
	}
	//getters and setters
	public int getSamuraiCount() {
		return samuraiCount;
	}
}
