package model;

import java.util.*;

public class testApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p1 = new Person("Bent", "Hansegenvej 1");
		System.out.println(p1.getNavn() + p1.getAdresse());
		p1.setNavn("Arnold");
		System.out.println(p1.getNavn() + p1.getAdresse());
		p1.setAdresse("Minegenvej 1");
		System.out.println(p1.getNavn() + p1.getAdresse());
		
		Mekaniker m1 = new Mekaniker("Jimmy", "Østergade 1", 200.0, 2001);
		System.out.println(m1.beregnugeløn(40) + " " + m1.getSvendebrevsår());
		
		Værkfører v1 = new Værkfører("Arne", "Brovej 2", 300.0, 1985, 1996, 2000.0);
		System.out.println(v1.beregnugeløn(40) + " " + v1.getUdnævnelsesår() + " " + v1.getUgentligtillæg());
		
		Synsmand s1 = new Synsmand("Hans", "Damvej 3", 225.0, 1998, 7, 250);
		
		ArrayList<Mekaniker> ansatte = new ArrayList<Mekaniker>();
		ansatte.add(m1);
		ansatte.add(v1);
		ansatte.add(s1);
		
		double totalløn = 0;
		for(Mekaniker mek : ansatte) {
			System.out.println(mek.beregnugeløn(40));
			
			totalløn += mek.beregnugeløn(40);
		}
		
		System.out.println(totalløn);
	}

}
