package opg4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Opgave4 {

	public static void main(String[] args) {
		Scanner scanIn = new Scanner(System.in);
		System.out.println("Type the name of the Input-File");
		
		
		
		if(scanIn.hasNextLine()) {
			File theFile = new File(scanIn.nextLine());
			
			
			System.out.println("Type the targeted Integer of your choice");
			
			if(scanIn.hasNextInt()) {
				int num = scanIn.nextInt();
				
				boolean resultat = intSearchInFile(theFile, num);
				
				if(resultat) {
					System.out.println("The Integer has been found in the file");
				} else {
					System.out.println("The Integer is not in the file");
				}
			}
		}
		scanIn.close();
		
	}
	
	public static boolean intSearchInFile(File file, int target) {
		boolean result = false;
		
		try(Scanner scanFile = new Scanner(file)) {
			while(!result && scanFile.hasNextInt()) {
				int n = scanFile.nextInt();
				if(n == target) {
					result = true;
				}
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

}
