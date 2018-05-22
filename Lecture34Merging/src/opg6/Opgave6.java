package opg6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Opgave6 {

	public static void main(String[] args) {
		File theFirstFile = new File("tal.txt");
		File theSecondFile = new File("tal2.txt");
		
		try {
			Scanner scanFile1 = new Scanner(theFirstFile);
			
			
			PrintWriter pw = new PrintWriter("output2.txt");
			while(scanFile1.hasNextInt()) {
				int tal1 = scanFile1.nextInt();
				Scanner scanFile2 = new Scanner(theSecondFile);
				int tal2 = scanFile2.nextInt();
				while(scanFile1.hasNextInt() && scanFile2.hasNextInt()) {
					if(tal1 == tal2) {
						pw.write(tal1 + "\n");
					} 
					tal2 = scanFile2.nextInt();
					
				}
				scanFile2.close();
			}
			
			
			pw.close();
			scanFile1.close();
			
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}

}
