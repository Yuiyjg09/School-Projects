package carmodel;

public class carApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		car c1 = new car("AB53617", 30, 2008);
		car c2 = new car("BB56617", 30, 2012);
		car c3 = new car("AX33617", 30, 2013);
		car c4 = new car("CV53688", 30, 2009);
		car c5 = new car("XY76321", 30, 2010);
		
		rental r1 = new rental(1, "5-6-18", 7);
		rental r2 = new rental(1, "10-6-18", 7);
		
		r1.addCar(c1);
		r1.addCar(c2);
		r1.addCar(c3);
		
		r2.addCar(c4);
		r2.addCar(c5);
		
		
		System.out.println(r1.getPrice());
		System.out.println(r2.getPrice());
	}

}
