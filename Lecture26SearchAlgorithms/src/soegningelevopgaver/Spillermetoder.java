package soegningelevopgaver;

import java.util.ArrayList;

public class Spillermetoder {
    public Spiller findScoreLinear(ArrayList<Spiller> spillere, int score) {
        // TODO Opgave 4.1
    	boolean found = false;
    	int i = 0;
    	Spiller spilleren = null;
    	
    	while(!found && i<spillere.size()) {
    		if(score == spillere.get(i).getMaal()) {
    			spilleren = spillere.get(i);
    			found = true;
    		} else {i++;}
    	}
    	
        return spilleren;
    }

    // Her tilføjes metoder der løser opgve 4.2 og 4.3
    
    public Spiller findScoreBinær(ArrayList<Spiller> spillere, int score) {
    	boolean found = false;
    	int left = 0;
    	int right = spillere.size()-1;
    	int middle = -1; 
    	Spiller spilleren = null;
    	
    	while(!found && left <= right) {
    		middle = (left + right)/2; 
    		if(score == spillere.get(middle).getMaal()) {
    			spilleren = spillere.get(middle);
    			found = true;
    		} else if(spillere.get(middle).getMaal() < score) {
				right = middle - 1;
    			} else {
    				left = middle + 1;
    			}
    		}
    	
        return spilleren;
    }

    public static void main(String[] args) {
        Spillermetoder metoder = new Spillermetoder();

        // Her afprøves opgave 4.1
        ArrayList<Spiller> spillerListe = new ArrayList<>();
        spillerListe.add(new Spiller("Hans", 196, 99, 45));
        spillerListe.add(new Spiller("Bo", 203, 89, 60));
        spillerListe.add(new Spiller("Jens", 188, 109, 32));
        spillerListe.add(new Spiller("Finn", 194, 102, 12));
        spillerListe.add(new Spiller("Lars", 192, 86, 35));
        spillerListe.add(new Spiller("Mads", 200, 103, 37));
        
        ArrayList<Spiller> spillerListe2 = new ArrayList<>();
        spillerListe2.add(new Spiller("Finn", 194, 102, 12));
        spillerListe2.add(new Spiller("Jens", 188, 109, 32));
        spillerListe2.add(new Spiller("Lars", 192, 86, 35));
        spillerListe2.add(new Spiller("Mads", 200, 103, 37));
        spillerListe2.add(new Spiller("Hans", 196, 99, 45));
        spillerListe2.add(new Spiller("Bo", 203, 89, 60));
        
        System.out.println("Spiller der har scoret 35 mål: " + metoder.findScoreLinear(spillerListe, 35));
        System.out.println("Spiller der har scoret 30 mål: " + metoder.findScoreLinear(spillerListe, 30));

        // Tilføj kode der afprøver opgaver 4.2 og 4.3
        System.out.println("Spiller der har scoret 35 mål: " + metoder.findScoreBinær(spillerListe2, 35));
        System.out.println("Spiller der har scoret 30 mål: " + metoder.findScoreBinær(spillerListe2, 30));
    }

}
