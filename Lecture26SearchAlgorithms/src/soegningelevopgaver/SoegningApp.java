package soegningelevopgaver;

import java.util.*;

public class SoegningApp {

	 
	
	public static void main(String[] args) {
		Soegning s = new Soegning();
		
		ArrayList<Integer> liste = new ArrayList<Integer>();
		liste.add(2);
		liste.add(3);
		liste.add(8);
		liste.add(9);
		liste.add(12);
		
		// Kode til afprøvning af opgave 1
		int[] talArray = {2,4,8,2};
		System.out.println("Er der et ulige tal i talArray ? " + s.findUlige(talArray));
		System.out.println(s.findTiFemten(talArray));
		
		
		talArray[2] = 15;
		System.out.println("Er der et ulige tal i talArray ? " + s.findUlige(talArray));
		
		
		

		// Her tilføjes kode til at afprøve opgaverne 2,3,5,6 og 7
		System.out.println(s.findTiFemten(talArray));
		System.out.println(s.findSideståendeEns(talArray));
		
		talArray[1] = 15;
		System.out.println(s.findTiFemten(talArray));
		
		System.out.println(s.findKRod(9));
		System.out.println(s.findKRodB(9));
		System.out.println(s.findOgByt(8, liste));
	}

}
