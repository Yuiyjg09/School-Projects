package measure;

public class SortMethods {
    
	public static void bubbleSort(String[] array) {
        // TODO:
    	int n = array.length;
    	for(int j = 0; j < n - 1; j++) {
    		
    		for(int i = 0; i < n - 1; i++) {
    			
    			if(array[i].compareTo(array[i + 1]) > 0) {
    				swap(array[i], array[i + 1]);
    				
    			}
    			System.out.println(array.toString());
    		}
    		
    		
    	}
    }
    
    public static void insertionSort(String[] array) {        
        // TODO:
    }
    
    public static void selectionSort(String[] array) {  
        // TODO:
    }
    
    public static void swap(String a, String b) {
    	String temp = a;
		a = b;
		b = temp;
    }
}
