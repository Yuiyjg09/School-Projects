package opg1;

public class ProfSpiller extends Spiller{
	private double kampHonoar;

	public ProfSpiller(String navn, int årgang, double kampHonoar) {
		super(navn, årgang);
		this.setKampHonoar(kampHonoar);
	}

	public double getKampHonoar() {
		return kampHonoar;
	}

	public void setKampHonoar(double kampHonoar) {
		this.kampHonoar = kampHonoar;
	}
	
	@Override
	public double kampHonorar() {
		double totalKampHonorar = 0.0;
		int deltagelsesCounter = 0;
		int afbudsCounter = 0;
		
		for(Deltagelse dtg : super.getDeltagelser()) {
			totalKampHonorar += 10;
			deltagelsesCounter++;
			if(dtg.isAfbud()) {
				afbudsCounter++;
			}
		}
		
		totalKampHonorar = totalKampHonorar - afbudsCounter / deltagelsesCounter * 100;
		
		return totalKampHonorar;
	}
	
}
