package model3;

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
        a.createSwimmer("Jan", 1994, lapTimes, "AGF");
        

        lapTimes = new ArrayList<>();
        lapTimes.add(1.05);
        lapTimes.add(1.01);
        lapTimes.add(1.04);
        lapTimes.add(1.06);
        lapTimes.add(1.08);
        lapTimes.add(1.04);
        lapTimes.add(1.02);
        a.createSwimmer("Bo", 1995, lapTimes, "Lyseng");
        
        ArrayList<Swimmer> swimmers = new ArrayList<>();
        
       
        for (Swimmer s : swimmers) {
            System.out.println(s.getName() + " bedste tid: " + s.bestLapTime());
        }
        
        
        
       
        
    }
    
}
