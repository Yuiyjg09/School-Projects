package test;

import customer.*;

public class Stringmethods {
	
	public static void selectionSort(String[] array) {
			for(int i = 0; i < array.length; i++) {
				int minPos = minimumposition(array, i);
				String temp = array[i];
				array[i] = array[minPos];
				array[minPos] = temp;
			}
			
			for(int k = 0; k < array.length; k++) {
    			System.out.print(array[k] + ", ");
    		}
    		System.out.println();
	}
	
	public static void selectionSort(Customer[] array) {
		for(int i = 0; i < array.length; i++) {
			int minPos = minimumposition(array, i);
			Customer temp = array[i];
			array[i] = array[minPos];
			array[minPos] = temp;
		}
		
		for(int k = 0; k < array.length; k++) {
			System.out.print(array[k] + ", ");
		}
		System.out.println();
}
	
	private static int minimumposition(String[] a, int from) {
		int minPos = from;
		for(int i = from + 1; i < a.length; i++) {
			if(a[i].compareTo(a[minPos]) < 0) { minPos = i;}
		}
		
		return minPos;
	}
	
	private static int minimumposition(Customer[] a, int from) {
		int minPos = from;
		for(int i = from + 1; i < a.length; i++) {
			if(a[i].compareTo(a[minPos]) < 0) { minPos = i;}
		}
		
		return minPos;
	}
	
	public static void bubbleSort(String[] array) {
      
    	int n = array.length;
    	for(int j = 0; j < n - 1; j++) {
    		
    		for(int i = 0; i < n - 1; i++) {
    			
    			if(array[i].compareTo(array[i + 1]) > 0) {
    				String temp = array[i];
    				array[i] = array[i + 1];
    				array[i + 1] = temp;
    			}

    		}
    		
    		for(int i = 0; i < array.length; i++) {
    			System.out.print(array[i] + ", ");
    		}
    		System.out.println();
    	}
    }
	
	public static void swap(String a, String b) {
    	String temp = a;
		a = b;
		b = temp;
    }
	
	public static void insertionSort(String[] array) {
		for(int i = 1; i < array.length - 1; i++) {
			String key = array[i];
			
			int j = i;
			while(j > 0 && array[j - 1].compareTo(key) > 0) {
				array[j] = array[j-1];
				j--;
			}
			array[j] = key;
			
			for(int k = 0; k < array.length; k++) {
    			System.out.print(array[k] + ", ");
    		}
    		System.out.println();
		}
		
	}
}
