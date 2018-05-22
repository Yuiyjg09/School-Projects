package questions;

import javafx.application.Application;
import java.util.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class QuestionGUI extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }
    
    private Label messageLabel;
    private ArrayList<Question> questions;
    private TextArea textAreaQuestion;
    private TextField textFieldAnswer;
    private Button submitButton;
    private Button createQuestion;
    
    @Override
    public void init() {
    	questions = new ArrayList<Question>();
        Question q1 = new Question();
        questions.add(q1);
        q1.setText("Who was the inventor of Java?");
        q1.setAnswer("James Gosling");
    }

    @Override
    public void start(Stage stage) {        
        GridPane gridPane = new GridPane();
        initContent(gridPane);
        Scene scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.setTitle("Question time!");
        stage.setResizable(false);
        stage.show();
        this.showQuestion();
    }
    
    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);
        
        textAreaQuestion = new TextArea();
        textAreaQuestion.setEditable(false);
        textAreaQuestion.setFocusTraversable(false);
        pane.add(new Label("Question:"), 0, 0);
        pane.add(textAreaQuestion, 0, 1, 2, 1);
        
        textFieldAnswer = new TextField();
        textFieldAnswer.setOnAction(event -> this.submitButton.fire());
        pane.add(new Label("Answer:"), 0, 2);
        pane.add(textFieldAnswer, 0, 3, 2, 1);
        
        submitButton = new Button("Submit");
        createQuestion = new Button("Create Question");
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.BASELINE_RIGHT);
        hbox.getChildren().add(submitButton);
        hbox.getChildren().add(createQuestion);
        pane.add(hbox, 1, 4, 1, 1);
        
        submitButton.setOnAction(event -> submitAnswer());
        createQuestion.setOnAction(event -> createQuestionAction());
        
        messageLabel = new Label("Write an answer.");
        pane.add(messageLabel, 0, 4, 2, 1);
    }
    
    private void submitAnswer() {
        if (this.textFieldAnswer.getText().isEmpty()) {
            return;
        }
        String answer = this.textFieldAnswer.getText();
        
        if (questions.get(0).checkAnswer(answer)) {
            this.messageLabel.setText("The answer is correct");
        } else {
            this.messageLabel.setText("You answered '" + answer.substring(0, Math.min(answer.length(), 30)) + "'. The answer is wrong!");
        }
    }
    
    public void showQuestion() {
        this.textAreaQuestion.setText(questions.get(0).displayText());
    }
    
    public void createQuestionAction() {
    	CreateQuestionWindow dia = new CreateQuestionWindow(questions);
    	dia.showAndWait();
    }
    
    
    
}
