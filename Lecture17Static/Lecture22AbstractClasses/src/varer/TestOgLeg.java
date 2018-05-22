package varer;

public class TestOgLeg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Indkøbsvogn i1 = new Indkøbsvogn(1);
		
		Vare v1 = new Vare(20, "Et eller andet...", "Et eller andet...", 0.25);
		Fødevare f1 = new Fødevare(10, "Melon", "Melon", 7);
		ElArtikler e1 = new ElArtikler(300, "Automatisk Melon-Hakker", "Det siger lidt sig selv...", 5);
		Spiritus s1 = new Spiritus(15, "Snebajer", "Snebajer TM: Knappes op og bælles...", 5);
		
		i1.lægIKurven(s1);
		i1.lægIKurven(e1);
		i1.lægIKurven(f1, 2);
		i1.lægIKurven(v1);
		
		i1.bon();
	}

}
