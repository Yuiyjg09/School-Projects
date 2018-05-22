package opg2;

public class Opgave2 {

	public static void main(String[] args) {
		int[] tal = {1, 2, 2, 5, 6, 8, 12};
		int[] tal2 = {1, 2, 3, 7, 9, 9, 10};
		
		int[] resultat = mergeSortedIntArrays(tal, tal2);
		
		for(int i : resultat) {
			System.out.print(i + " ");
		}
		System.out.println();
		
	}
	
	public static int[] mergeSortedIntArrays(int[] ary1, int[] ary2) {
		int[] result = new int[ary1.length + ary2.length];
		int i1 = 0;
		int r1 = 0;
		
		while(i1 < ary1.length) {
			int tal1 = ary1[i1];
			int i2 = 0;
			while(i2 < ary2.length) {
				int tal2 = ary2[i2];
				if(tal1 == tal2) {
					result[r1] = tal1;
					r1++;
				}
				i2++;
			}
			i1++;
		}
		
		int counter = 0;
		for(int i : result) {
			if(i != 0) {
				counter++;
			}
		}
		
		int[] result2 = new int[counter];
		
		
		for(int i = 0; i < result2.length; i++) {
			if(result[i] != 0) {
				result2[i] = result[i];
			}
		}
		
		return result2;
	}

}
