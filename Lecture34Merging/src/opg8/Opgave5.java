package opg8;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Opgave5 {

	public static void main(String[] args) {
		File theFirstFile = new File("tal.txt");
		File theSecondFile = new File("tal2.txt");
		
		try {
			Scanner scanFile1 = new Scanner(theFirstFile);
			Scanner scanFile2 = new Scanner(theSecondFile);
			
			PrintWriter pw = new PrintWriter("output6.txt");
			int tal1 = scanFile1.nextInt();
			int tal2 = scanFile2.nextInt();
			while(scanFile1.hasNextInt() && scanFile2.hasNextInt()) {
				
				
				if(tal1 <= tal2) {
					pw.write(tal1 + "\n");
					tal1 = scanFile1.nextInt();
				} else if(tal2 <= tal1) {
					pw.write(tal2 + "\n");
					tal2 = scanFile2.nextInt();
				}
				
				
			}
			
			if(scanFile1.hasNextInt()) {
				
				while(scanFile1.hasNextInt()) {
					tal1 = scanFile1.nextInt();
					if(tal1 < tal2) {
						pw.write(tal1 + "\n");
					} else if(tal2 < tal1) {
						pw.write(tal2 + "\n");
					} else {
						pw.write(tal1 + "\n");
					}
				}
			} else if(scanFile2.hasNextInt()) {
				
				while(scanFile2.hasNextInt()) {
					tal2 = scanFile2.nextInt();
					if(tal1 <= tal2) {
						pw.write(tal1 + "\n");
					} else if(tal2 <= tal1) {
						pw.write(tal2 + "\n");
					} else {
						pw.write(tal2 + "\n");
					}
				}
			}
			
			pw.close();
			scanFile1.close();
			scanFile2.close();
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		
		
		
		
	}

}
