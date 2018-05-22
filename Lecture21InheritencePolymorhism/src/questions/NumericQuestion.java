package questions;

public class NumericQuestion extends Question {
	public NumericQuestion(String text, String answer) {
		super();
		super.setAnswer(answer);
		super.setText(text);
	}
	
	@Override
	public boolean checkAnswer(String response) {
		double responsenum = Double.parseDouble(response);
		double answernum = Double.parseDouble(getAnswer());
		if(responsenum <= answernum + 0.01 && responsenum >= answernum - 0.01) {
			return true;
		} else {
			return false;
		}
	}
}
