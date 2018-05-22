package yatzy;

import java.util.Random;

/**
 * Models a game of Yatzy. 
 */
public class Yatzy {
    /** 
     * Face values of the 5 dice. <br/>
     * 1 <= values[i] <= 6.
     */
    private int[] values = new int[5];

    /** 
     * Number of times the 5 dice have been thrown. <br/>
     * 0 <= throwCount <= 3.
     */
    private int throwCount = 0;

    /** 
     * Random number generator.
     */
    private Random random = new Random();
    
    /**
     * Rolls the 5 dice. <br/>
     * Only roll dice that are not hold. <br/>
     * Requires: holds contain 5 boolean values.
     */
    public void throwDice(boolean[] holds) {
        // TODO: Implement
    	for(int i = 0; i < values.length; i++) {
    		if(!holds[i]) {
    			values[i] = random.nextInt(5) + 1;
    		}
    	}
    	throwCount++;
    }

    /**
     * Returns the number of times the five dice have been thrown.
     */
    public int getThrowCount() {
        return throwCount;
    }
    
    /**
     * Resets the throw count.
     */
    public void resetThrowCount() {
        throwCount = 0;
    }
    
    /**
     * Get current dice values
     */
    public int[] getValues() {
        return values;
    }
    
    /**
     * Set the current dice values
     */
    public void setValues(int[] values) {
        this.values = values;
    }
    
    /**
     * Returns all results possible with the current face values. <br/>
     * The order of the results is the same as on the score board.
     */
    public int[] getPossibleResults() {
        int[] results = new int[15];
        for (int i = 0; i <= 5; i++) {
            results[i] = this.valueSpecificFace(i + 1);
        }
        results[6] = this.valueOnePair();
        results[7] = this.valueTwoPair();
        results[8] = this.valueThree();
        results[9] = this.valueFour();
        results[10] = this.valueFullHouse();
        results[11] = this.valueSmallStraight();
        results[12] = this.valueLargeStraight();
        results[13] = this.valueChance();
        results[14] = this.valueYatzy();
        return results;
    }
    
    /** 
     * Returns an int[7] containing the frequency of face values. <br/>
     * Frequency at index v is the number of dice with the face value v, 1 <= v <= 6. <br/>
     * Index 0 is not used.
     */
    private int[] freqFaceValue() {
        // TODO: Implement
    	int[] freq = new int[7];
    	for(int i = 0; i < values.length; i++) {
    		if(values[i] == 1) {
    			freq[1] += 1;
    		} else if(values[i] == 2) {
    			freq[2] += 1;
    		} else if(values[i] == 3) {
    			freq[3] += 1;
    		} else if(values[i] == 4) {
    			freq[4] += 1;
    		} else if(values[i] == 5) {
    			freq[5] += 1;
    		} else if(values[i] == 6) {
    			freq[6] += 1;
    		}
    	}
        return freq;
    }

    /**
     * Returns the total value for the dice currently showing the given face value
     * @param face the face value to return values for
     */
    public int valueSpecificFace(int face) {
        // TODO: Implement
    	int sum = 0;
    	
    	for(int i = 0; i < values.length; i++) {
    		if(values[i] == face) {
    			sum += face;
    		}
    	}
    	
        return sum;
    }

    /**
     * Returns the maximum value for n-of-a-kind for the given n. <br/>
     * For example, valueManyOfAKind(3) returns the maximum value for 3 of-a-kind. <br/>
     * Requires: 1 <= faceValue and faceValue <= 6
     * @param n number of kind
     */
    public int valueManyOfAKind(int n) {
        // TODO: Implement
    	int max = 0;
    	int[] freq = freqFaceValue();
    	for(int i = 0; i < freq.length; i++) {
    		if(n <= freq[i]) {
    			max = n * i;
    		}
    	}
        return max;
    }

    /**
     * The current value if you try to score the current face values as Yatzy.
     */
    public int valueYatzy() {
        // TODO: Implement
    	int yatzyValue = 0;
    	if(valueManyOfAKind(5) > 0) {
    		yatzyValue = 50;
    	}
        return yatzyValue;
    }

    /**
     * Returns the current score if used as "chance".
     */
    public int valueChance() {
        // TODO: Implement
    	int points = 0;
    	for(int i = 0; i < values.length; i++) {
    		points += values[i];
    	}
        return points;
    }

    /**
     * Returns the current score for one pair.
     */
    public int valueOnePair() {
        // TODO: Implement
        return valueManyOfAKind(2);
    }

    /**
     * Returns the current score for two pairs.
     */
    public int valueTwoPair() {
        // TODO: Implement
    	int points = 0;
    	int max = 0;
    	int[] freq = freqFaceValue();
    	
    	valueOnePair();
    	
    	if(valueOnePair() > 0) {
    		points += valueOnePair();
    		freq[(valueOnePair()/2)] = 0;
    		
    		
    	}
    	
    	for(int i = 0; i < freq.length; i++) {
    		if(2 <= freq[i]) {
    			max = 2 * i;
    		}
    	}
    	
		if(max > 0) {
			points += max;
		}
    	
        return points;
    }
    
    /**
     * Returns the current score for three of a kind.
     */
    public int valueThree() {
        // TODO: Implement
        return valueManyOfAKind(3);
    }
    
    /**
     * Returns the current score for four of a kind.
     */
    public int valueFour() {
        // TODO: Implement
        return valueManyOfAKind(4);
    }

    /**
     * Returns the value of a small straight with the current face values.
     */
    public int valueSmallStraight() {
        // TODO: Implement
    	int points = 0;
    	int[] freq = freqFaceValue();
    	boolean isSmall = false;
    	for(int i = 1; i < freq.length - 1; i++) {
    		if(freq[i] == 1) {
    			isSmall = true;
    		} else {
    			isSmall = false;
    		}
    	}
    	
    	if(isSmall) {
    		points = 15;
    	}
    	
        return points;
    }

    /**
     * Returns the value of a large straight with the current face values.
     */
    public int valueLargeStraight() {
        // TODO: Implement
    	int points = 0;
    	int face = 0;
    	int[] freq = freqFaceValue();
    	
    	for(int i = 2; i < freq.length; i++) {
    		if(freq[i] == 1) {
    			face += i;
    		} 
    	}
    	
    	if(face == 20) {
    		points = 20;
    	}
    	
        return points;
    }

    /**
     * Returns the value of a full house with the current face values.
     */
    public int valueFullHouse() {
        // TODO: Implement
    	int points = 0;
    	int max = 0;
    	int[] freq = freqFaceValue();
    	
    	valueOnePair();
    	
    	if(valueOnePair() > 0) {
    		
    		freq[(valueOnePair()/2)] = 0;
    	
    	}
    	for(int i = 0; i < freq.length; i++) {
    		if(3 <= freq[i]) {
    			max = 3 * i;
    		}
    	}
    	
		if(max > 0 && valueOnePair() > 0) {
			points += max + valueOnePair();
		}
    	
        return points;
    }

}
