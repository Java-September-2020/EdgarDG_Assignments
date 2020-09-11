
public class PhoneTester {

	public static void main(String[] args) {
		Galaxy s9 = new Galaxy("S9", 99, "Verizon", "Ring! Ring! Ring!");
		iPhone iPhoneTen = new iPhone("X", 99, "AT&T", "Zing. Zing.");
		
		s9.displayInfo();
		System.out.println(s9.ring());
		System.out.println(s9.unlock());
		
		iPhoneTen.displayInfo();
		System.out.println(iPhoneTen.ring());
		System.out.println(iPhoneTen.unlock());
	}

}
