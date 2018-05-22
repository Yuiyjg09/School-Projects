package questions;

import java.util.ArrayList;

public class AnyCorrectChoiceQuestion extends Question {
	
	private ArrayList<String> choices;

	public AnyCorrectChoiceQuestion() {
		super();
		choices = new ArrayList<String>();
	}
	
	public void addChoice(String choice, boolean correct) {
		choices.add(choice);
		if (correct) {
			// Convert choices.size() to string
			String choiceString = "" + choices.size();
			setAnswer(choiceString);
		}
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
