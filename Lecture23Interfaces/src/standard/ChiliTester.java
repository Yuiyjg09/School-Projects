package standard;

public class ChiliTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChiliFilter chilifilter = new ChiliFilter(10000);
		
		Chili c1 = new Chili("Rød Peber", 10);
		Chili c2 = new Chili("Jalapenos", 300);
		Chili c3 = new Chili("Trinidad Scorpion", 1463700);
		Chili c4 = new Chili("Red Savina Habanero", 500000);
		Chili c5 = new Chili("Ghost Chili", 1041427);
		
		Measurable[] m1 = {c1, c2, c3, c4, c5};
		Measurable[] m2 = {c3, c4, c5};
		
		Data data = new Data();
		System.out.println(data.max(m1));
		System.out.println(data.avg(m1));
		
		System.out.println(data.avg(m1, chilifilter));
		
		System.out.println(data.avg(m2, chilifilter));
		
	}

}
