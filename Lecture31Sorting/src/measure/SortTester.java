package measure;

import java.util.ArrayList;

import test.*;

public class SortTester {

    public static void main(String[] args) {
        
        int testSize = 3000;
        ArrayList<String> bigList = ListGenerator.generateString(testSize, 12);
        String[] bigArray1 = bigList.toArray(new String[0]);
        String[] bigArray2 = bigList.toArray(new String[0]);
        String[] bigArray3 = bigList.toArray(new String[0]);
        System.out.println(bigList);
        
        // Bubble Sort Test
        Measurer.start();
        test.Stringmethods.bubbleSort(bigArray1);
        Measurer.stop();
        System.out.println(String.format("BubbleSort (%d) -- Total time in milliseconds: %d", 
                testSize, Measurer.durationInMilliSeconds()));
        
        // Insertion Sort Test
        Measurer.start();
        test.Stringmethods.insertionSort(bigArray2);
        Measurer.stop();
        System.out.println(String.format("InsertionSort (%d) -- Total time in milliseconds: %d", 
                testSize, Measurer.durationInMilliSeconds()));
        
        // Selection Sort Test
        Measurer.start();
        test.Stringmethods.selectionSort(bigArray3);
        Measurer.stop();
        System.out.println(String.format("SelectionSort (%d) -- Total time in milliseconds: %d", 
                testSize, Measurer.durationInMilliSeconds()));
    }

}
