package model2;

import java.util.ArrayList;

public class SwimmerApp {
    
    public static void main(String[] args) {
    	
    	TrainingPlan a = new TrainingPlan('A', 16, 10);

    	
        ArrayList<Double> lapTimes = new ArrayList<>();
        lapTimes.add(1.02);
        lapTimes.add(1.01);
        lapTimes.add(0.99);
        lapTimes.add(0.98);
        lapTimes.add(1.02);
        lapTimes.add(1.04);
        lapTimes.add(0.99);
        Swimmer s1 = new Swimmer("Jan", 1994, lapTimes, "AGF");
        s1.setTrainingPlan(a);

        lapTimes = new ArrayList<>();
        lapTimes.add(1.05);
        lapTimes.add(1.01);
        lapTimes.add(1.04);
        lapTimes.add(1.06);
        lapTimes.add(1.08);
        lapTimes.add(1.04);
        lapTimes.add(1.02);
        Swimmer s2 = new Swimmer("Bo", 1995, lapTimes, "Lyseng");
        s2.setTrainingPlan(a);
        
        ArrayList<Swimmer> swimmers = new ArrayList<>();
        swimmers.add(s1);
        swimmers.add(s2);
       
        for (Swimmer s : swimmers) {
            System.out.println(s.getName() + " bedste tid: " + s.bestLapTime());
        }
        
        a.addSwimmer(s1);
        a.addSwimmer(s2);
        
        for (Swimmer s : a.getSwimmers()) {
        	System.out.println("Swimmer: " + s.getName());
        }
        
    }
    
}
