
public class iPhone extends Phone implements Ringable {
	//attributes
	
	//constructors
	public iPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
		super(versionNumber, batteryPercentage, carrier, ringTone);
	}
	
	//methods
	@Override
	public String ring() {
		return "iPhone " + this.getVersionNumber() + " says " + this.getRingTone();
	}
	@Override
	public String unlock() {
		return "Unlocking via facial recognition";
	}
	@Override
	public void displayInfo() {
		System.out.println("iPhone " + this.getVersionNumber() + " from " + this.getCarrier());
	}
	
	//getters and setters
}
