package maryLamb;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class LineMarker {
	
	public static void main(String[] args) {
	File file = new File("mary.txt");
	
		
		try {
			Scanner scanner = new Scanner(file);
			int i = 1;
			PrintWriter pw = new PrintWriter("output.txt");
			while(scanner.hasNextLine()) {
				String input = scanner.nextLine();
				String out = "/* " + i + " */ " + input + "\n";
				pw.write(out);
				i++;
			}
			scanner.close();
			pw.close();
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
}
