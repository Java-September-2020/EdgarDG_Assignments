
public class HumanTest {

	public static void main(String[] args) {
		Ninja trevorBelmont = new Ninja();
		Samurai simonBelmont = new Samurai();
		Wizard mariaRenard = new Wizard();
		Samurai sanosuke = new Samurai();
		Samurai odaNabunaga = new Samurai();
		System.out.println(trevorBelmont.getHealth());
		System.out.println(simonBelmont.getHealth());
		System.out.println(trevorBelmont.getStrength());
		System.out.println(trevorBelmont.getStealth());
		System.out.println(trevorBelmont.getIntelligence());
		trevorBelmont.attackHuman(simonBelmont);
		System.out.println(trevorBelmont.getHealth());
		System.out.println(simonBelmont.getHealth());
		
		System.out.println(odaNabunaga.howMany());
	}
}
