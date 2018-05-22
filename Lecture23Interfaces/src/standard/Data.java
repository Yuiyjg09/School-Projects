package standard;

public class Data {
	public static double max(Measurable[] objects) {
		double largest = Double.MIN_VALUE;
		for(Measurable obj : objects) {
			if(obj.getMeasure() >= largest) {
				largest = obj.getMeasure();
			}
		}
		
		return largest;
	}
	
	public static double avg(Measurable[] objects) {
		double sum = 0.0;
		for(Measurable obj : objects) {
			sum += obj.getMeasure();
		}
		
		return sum / objects.length;
	}
	
	public static double avg(Measurable[] objects, Filter filter) {
		boolean[] fltr = new boolean[objects.length];
		for(int i = 0; i < objects.length; i++) {
			if(filter.accept(objects[i])) {
				fltr[i] = true;
			} else {
				fltr[i] = false;
			}
		}
		
		int length = 0;
		double sum = 0.0;
		for(int i = 0; i < objects.length; i++) {
			if(fltr[i]) {
			sum += objects[i].getMeasure();
			length++;
			}
		}
		
		return sum / length;
		
		
		
	}
	
	
}
