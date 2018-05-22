package questions;

import javafx.application.Application;
import java.util.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CreateQuestionWindow extends Stage {
	private Question question;
	private ArrayList<Question> questions;
	
	public CreateQuestionWindow(ArrayList<Question> questions) {
		this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);
        
        this.setTitle("Create a new Question");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
        
        this.questions = questions;
	}
	
	//--------------------------------------------------
	private Button createBtn;
	private HBox hbox;
	private Button cancelBtn;
	private ListView<Placeholder> lvwTypes;
	private Placeholder q1, q2, q3, q4, q5;
	
	
	private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);
        
        q1 = new Placeholder("Question", 1);
        q2 = new Placeholder("Choice Question", 2);
        q3 = new Placeholder("Multi-Choice Question", 3);
        q4 = new Placeholder("Any-Correct-Choice Question", 4);
        q5 = new Placeholder("Numeric Question", 5);
        
        lvwTypes = new ListView<Placeholder>();
        lvwTypes.getItems().add(q1);
        lvwTypes.getItems().add(q2);
        lvwTypes.getItems().add(q3);
        lvwTypes.getItems().add(q4);
        lvwTypes.getItems().add(q5);
        pane.add(lvwTypes, 0, 0);
        
        hbox = new HBox();
        pane.add(hbox, 1, 4, 1, 1);
        
        cancelBtn = new Button("cancel");
        hbox.getChildren().add(cancelBtn);
        cancelBtn.setOnAction(event -> cancelAction());
        
        createBtn = new Button("create");
        hbox.getChildren().add(createBtn);
        createBtn.setOnAction(event -> createAction());
        
        this.initControls();
	}
	
	private void initControls() {
		
	}
	
	//---------------------------------------------------
	
	
	private void cancelAction() {
        this.hide();
    }
	
	private void createAction() {
		
		this.hide();
	}
}
