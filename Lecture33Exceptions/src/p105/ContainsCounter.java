package p105;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ContainsCounter {
	public static void main(String[] args) {
		System.out.println("Type the name of the Input-file: ");
		Scanner scanIn = new Scanner(System.in);
		
		
		int lines = 0;
		int words = 0;
		int chars = 0;
		
		if(scanIn.hasNextLine()) {
			File inFile = new File(scanIn.nextLine());
			 try {
				Scanner scanText = new Scanner(inFile);
				while(scanText.hasNextLine()) {
					String txt = scanText.nextLine().toString();
					char[] text = txt.toCharArray();
					
					words += txt.split(" ").length;
				
					chars += text.length;
					
					lines++;
				
					System.out.println("Lines: " + lines + "\n" + "Words: " + words + "\n" + "Chars: " + chars);
				}
				
			scanText.close();	
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			scanIn.close();
			 
		}
	}
}
