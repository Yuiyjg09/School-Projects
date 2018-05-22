package questions;

import java.util.*;

public class MultiChoiceQuestion extends ChoiceQuestion {
	private ArrayList<String> correctAnswers = new ArrayList<>();
	
	public MultiChoiceQuestion() {
		super();
	}
	
	@Override
	public void setAnswer(String correctResponse) {
		correctAnswers.add(correctResponse);
	}
	
	
	@Override
	public void addChoice(String choice, boolean correct) {
		super.getChoices().add(choice);
		if (correct) {
			// Convert choices.size() to string
			String choiceString = "" + super.getChoices().size();
			setAnswer(choiceString);
		}
	}
	
	@Override
	public boolean checkAnswer(String response) {
		boolean realAnswer = false;
		String correct = " ";
		for(String s : correctAnswers) {
			correct = s + "";
		}
		if(correct.trim() == response.trim()) {
			realAnswer = true;
		}
		
		return realAnswer;
	}
	
	
}
