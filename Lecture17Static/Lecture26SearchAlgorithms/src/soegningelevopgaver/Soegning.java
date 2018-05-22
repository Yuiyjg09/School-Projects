package soegningelevopgaver;

import java.util.*;

public class Soegning {

    public boolean findUlige(int[] tabel) {
        boolean found = false;
        int i = 0;
        
        while(!found && i<tabel.length) {
        	if(tabel[i] % 2 != 0) {
        		found = true;
        	} else {i++;}
        }
        
        return found;
    }
    
    
    public int findTiFemten(int[] tabel) {
    	boolean found = false;
    	int ulige = -1;
    	int i = 0;
    	
    	while(!found && i<tabel.length) {
    		if(tabel[i] >= 10 || tabel[i] <= 15) {
    			ulige = tabel[i];
    			found = true;
    		} else {i++;}
    	}
    	
    	return ulige;
    	
    }
    
    public boolean findSideståendeEns(int[] tabel) {
    	boolean found = false;
    	int i = 0;
    	
    	while(!found && i<tabel.length-1) {
    		if(tabel[i] == tabel[i+1]) {
    			found = true;
    		} else {i++;}
    	}
    	
    	return found;
    }
    
    public int findKRod(int n) {
    	boolean found = false;
    	int r = 0;
    	while(!found) {
    		if(r*r <= n) {
    			r++;
    		} else {
    			r--;
    			found = true;
    		}
    	}
    	
    	return r;
    }
    
    public int findKRodB(int n) {
    	boolean found = false;
    	int r = 0;
    	int low = 0;
    	int high = n;
    	int middle = -1;
    	while(!found && low <= high) {
    		middle = (low+high)/2;
    		if(middle*middle <= n && (middle + 1)*(middle + 1) > n) {
    			r = middle;
    			found = true;
    		} else {
    			high--;
    		}
    	}
    	return r;
    }
    
    public int findOgByt(int tal, ArrayList<Integer> liste) {
    	int pos = -1;
    	int i = 0;
    	int temp;
    	boolean found = false;
    	
    	while(!found && i<liste.size()) {
    		if(liste.get(i) == tal) {
    			temp = liste.get(i-1);
    			liste.set(i-1, liste.get(i));
    			liste.set(i, temp);
    			pos = i-1;
    			found = true;
    		} else {i++;}
    	}
    	return pos;
    }
    


}
