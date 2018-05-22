package opg7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Opgave7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("personer.txt");
		
		Scanner scanTarget = new Scanner(System.in);
		System.out.println("Type the Surname of the Target");
		
		if(scanTarget.hasNextLine()) {
			String target = scanTarget.nextLine();
			try {
				Scanner scanFile = new Scanner(file);
				boolean found = false;
				String theTarget = null;
				while(!found && scanFile.hasNextLine()) {
					String[] personen = scanFile.nextLine().split(" ");
					for(String s : personen) {
						if(s.toLowerCase().equals(target.toLowerCase())) {
							found = true;
							StringBuilder sb = new StringBuilder();
							for(String se: personen) {
								sb.append(se + " ");
							}
							theTarget = sb.toString();
						}
					}
				}
				
				if(found) {
					System.out.println("The person: " + theTarget + " has been found in the file");
				} else {
					System.out.println("The person: " + target + " is not in the file");
				}
				
				scanFile.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		scanTarget.close();
	}

}
