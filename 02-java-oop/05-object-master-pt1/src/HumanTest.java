
public class HumanTest {

	public static void main(String[] args) {
		Human trevorBelmont = new Human();
		Human simonBelmont = new Human();
		Human mariaRenard = new Human();
		System.out.println(trevorBelmont.getHealth());
		System.out.println(simonBelmont.getHealth());
		System.out.println(trevorBelmont.getStrength());
		System.out.println(trevorBelmont.getStealth());
		System.out.println(trevorBelmont.getIntelligence());
		trevorBelmont.attackHuman(simonBelmont);
		System.out.println(trevorBelmont.getHealth());
		System.out.println(simonBelmont.getHealth());
	}
}
