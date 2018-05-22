package opg8;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Opgave8_6 {
	public static void main(String[] args) {
		File theFirstFile = new File("tal.txt");
		File theSecondFile = new File("tal2.txt");
		
		try {
			Scanner scanFile1 = new Scanner(theFirstFile);
			Scanner scanFile2 = new Scanner(theSecondFile);
			
			ArrayList<Integer> list1 = new ArrayList<>();
			ArrayList<Integer> list2 = new ArrayList<>();
			ArrayList<Integer> result = new ArrayList<>();
			
			PrintWriter pw = new PrintWriter("output5.txt");
			
			while(scanFile1.hasNextInt() && scanFile2.hasNextInt()) {
				int tal1 = scanFile1.nextInt();
				int tal2 = scanFile2.nextInt();
				list1.add(tal1);
				list2.add(tal2);
			}
			int i1 = 0;
			int i2 = 0;
			while(i1 < list1.size()) {
				int tal1 = list1.get(i1);
				i2 = 0;
				while(i2 < list2.size()) {
					int tal2 = list2.get(i2);
					if(tal1 == tal2) {
						result.add(tal1);
						
					}
					i2++;
				}
				i1++;
			}
			
			int r1 = 0;
			while(r1 < result.size()) {
				pw.write(result.get(r1) + "\n");
				r1++;
			}
			
			pw.close();
			scanFile1.close();
			scanFile2.close();
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
