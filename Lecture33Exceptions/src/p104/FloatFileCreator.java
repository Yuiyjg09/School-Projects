package p104;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FloatFileCreator {

	public static void main(String[] args) {
		System.out.println("Type the name of the Input-file: ");
		Scanner scanIn = new Scanner(System.in);
		
		if(scanIn.hasNextLine()) {
			File inFile = new File(scanIn.nextLine());
			try {
				Scanner scanFloat = new Scanner(inFile);
				double avgR = 0;
				double avgL = 0;
				int counter = 0;
				
				int counterR = 0;
				
				int counterL = 0;
				
				while(scanFloat.hasNextDouble()) {
					if(counter % 2 == 0) {
						avgL += scanFloat.nextDouble();
						counterL++;
					} else {
						avgR += scanFloat.nextDouble();
						counterR++;
					}
					counter++;
				}
				
				float resultL = (float) avgL / counterL;
				float resultR = (float) avgR / counterR;
				
				System.out.println("Left: " + resultL);
				System.out.println("Right: " + resultR);
				
				scanFloat.close();
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (InputMismatchException e) {
				e.getMessage();
			}
			
			scanIn.close();
			
		}
	}

}
