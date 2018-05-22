package yatzy;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Yatzy");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    // -------------------------------------------------------------------------

    // The Yatzy game object
    private Yatzy yatzy = new Yatzy();
    // Shows the face values of the 5 dice.
    private TextField[] txfValues;
    // Shows the hold status of the 5 dice.
    private CheckBox[] chbHolds;
    private Button[] btnResults;
    private TextField txfSumSame, txfBonus, txfSumOther, txfTotal;
    private Label lblRolled;
    private Button btnRoll;
    private boolean[] hold = {false, false, false, false, false};
    private int[] resetValues = new int[5];
    private boolean bonus = true;

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        // ---------------------------------------------------------------------

        GridPane dicePane = new GridPane();
        pane.add(dicePane, 0, 0);
        dicePane.setGridLinesVisible(false);
        dicePane.setPadding(new Insets(10));
        dicePane.setHgap(10);
        dicePane.setVgap(10);
        dicePane.setStyle("-fx-border-color: black");

        
        txfValues = new TextField[5];
        
        txfValues[0] = new TextField();
        dicePane.add(txfValues[0], 0, 0);
        txfValues[0].setPrefWidth(90);
        txfValues[0].setPrefHeight(90);
        txfValues[0].setDisable(true);
        
        
        txfValues[1] = new TextField();
        dicePane.add(txfValues[1], 1, 0, 1, 1);
        txfValues[1].setPrefWidth(90);
        txfValues[1].setPrefHeight(90);
        txfValues[1].setDisable(true);
        
        txfValues[2] = new TextField();
        dicePane.add(txfValues[2], 2, 0, 1, 1);
        txfValues[2].setPrefWidth(90);
        txfValues[2].setPrefHeight(90);
        txfValues[2].setDisable(true);
        
        txfValues[3] = new TextField();
        dicePane.add(txfValues[3], 3, 0, 1, 1);
        txfValues[3].setPrefWidth(90);
        txfValues[3].setPrefHeight(90);
        txfValues[3].setDisable(true);
        
        txfValues[4] = new TextField();
        dicePane.add(txfValues[4], 4, 0, 1, 1);
        txfValues[4].setPrefWidth(90);
        txfValues[4].setPrefHeight(90);
        txfValues[4].setDisable(true);
        
        
        chbHolds = new CheckBox[5];
        chbHolds[0] = new CheckBox();
        dicePane.add(chbHolds[0], 0, 1, 1, 1);
        chbHolds[0].setDisable(false);
        
        chbHolds[1] = new CheckBox();
        dicePane.add(chbHolds[1], 1, 1, 1, 1);
        chbHolds[1].setDisable(false);
        
        chbHolds[2] = new CheckBox();
        dicePane.add(chbHolds[2], 2, 1, 1, 1);
        chbHolds[2].setDisable(false);
        
        chbHolds[3] = new CheckBox();
        dicePane.add(chbHolds[3], 3, 1, 1, 1);
        chbHolds[3].setDisable(false);
        
        chbHolds[4] = new CheckBox();
        dicePane.add(chbHolds[4], 4, 1, 1, 1);
        chbHolds[4].setDisable(false);
        
        
        btnRoll = new Button("Let's Roll!");
        dicePane.add(btnRoll, 3, 2);
        
        lblRolled = new Label("Rolled: 0");
        dicePane.add(lblRolled, 4, 2);

        // ---------------------------------------------------------------------

        GridPane scorePane = new GridPane();
        pane.add(scorePane, 0, 3);
        scorePane.setGridLinesVisible(false);
        scorePane.setPadding(new Insets(10));
        scorePane.setVgap(5);
        scorePane.setHgap(10);
        scorePane.setStyle("-fx-border-color: black");

        
        Label onelbl = new Label("1-s");
        scorePane.add(onelbl, 0, 0);
        Label twolbl = new Label("2-s");
        scorePane.add(twolbl, 0, 1);
        Label threelbl = new Label("3-s");
        scorePane.add(threelbl, 0, 2);
        Label fourlbl = new Label("4-s");
        scorePane.add(fourlbl, 0, 3);
        Label fivelbl = new Label("5-s");
        scorePane.add(fivelbl, 0, 4);
        Label sixlbl = new Label("6-s");
        scorePane.add(sixlbl, 0, 5);
        Label pairlbl = new Label("One pair");
        scorePane.add(pairlbl, 0, 6);
        Label twopairlbl = new Label("Two pairs");
        scorePane.add(twopairlbl, 0, 7);
        Label threeslbl = new Label("Three same");
        scorePane.add(threeslbl, 0, 8);
        Label fourslbl = new Label("Four same");
        scorePane.add(fourslbl, 0, 9);
        Label houselbl = new Label("Full House");
        scorePane.add(houselbl, 0, 10);
        Label smalllbl = new Label("Small Straight");
        scorePane.add(smalllbl, 0, 11);
        Label largelbl = new Label("Large Straight");
        scorePane.add(largelbl, 0, 12);
        Label chancelbl = new Label("Chance");
        scorePane.add(chancelbl, 0, 13);
        Label yatzylbl = new Label("Yatzy");
        scorePane.add(yatzylbl, 0, 14);
        
        
        btnResults = new Button[15];
        
        for(int i = 0; i < btnResults.length; i++) {
        	btnResults[i] = new Button();
        	btnResults[i].setPrefWidth(50);
        	scorePane.add(btnResults[i], 1, i);
        	btnResults[i].setDisable(true);
        }
        
        Label sum1lbl = new Label("Sum");
        scorePane.add(sum1lbl, 2, 5);
        
        Label sum2lbl = new Label("Sum");
        scorePane.add(sum2lbl, 2, 14);

        
        txfSumSame = new TextField();
        txfSumSame.setPrefWidth(50);
        scorePane.add(txfSumSame, 3, 5);
        txfSumSame.setDisable(true);
        txfSumSame.setText(0 + "");
        
        Label bonuslbl = new Label("Bonus");
        scorePane.add(bonuslbl, 4, 5);
        
        Label totallbl = new Label("Total");
        scorePane.add(totallbl, 4, 14);
        
        txfBonus = new TextField();
        txfBonus.setPrefWidth(50);
        scorePane.add(txfBonus, 5, 5);
        txfBonus.setDisable(true);
        txfBonus.setText(0 + "");
        
        txfSumOther = new TextField();
        txfSumOther.setPrefWidth(50);
        scorePane.add(txfSumOther, 3, 14);
        txfSumOther.setDisable(true);
        txfSumOther.setText(0 + "");
        
        txfTotal = new TextField();
        txfTotal.setPrefWidth(50);
        scorePane.add(txfTotal, 5, 14);
        txfTotal.setDisable(true);
        txfTotal.setText(0 + "");
        
        btnRoll.setOnAction(event -> this.rollAction());
        
        
        
        
    }

    // -------------------------------------------------------------------------

    
    
    private void rollAction() {
    	if(yatzy.getThrowCount() < 3) {
    		checkCheck();
    	
    		yatzy.throwDice(hold);
    		int[] values = yatzy.getValues();
    	
    		for(int i = 0; i < values.length; i++) {
    		txfValues[i].setText(values[i] + "");
    		}
    		
    		lblRolled.setText("Rolled: " + yatzy.getThrowCount());
    		
    		
    		if(yatzy.getThrowCount() == 3) {
    			btnRoll.setDisable(true);
    			for(int i = 0; i < chbHolds.length; i++) {
    				chbHolds[i].setDisable(true);
    			}
    			
    			int[] results = yatzy.getPossibleResults();
    			
    			
    			
    			
    			if(Integer.parseInt(txfSumSame.getText()) >= 63 && bonus) {
    				txfBonus.setText("50");
    				bonus = false;
    			} else {
    				txfBonus.setText("0");
    			}
    			
    			
    			int otherSum = 0;
    			if(results[14] >= 50) {
    					otherSum += results[14];
    			}
    			
    			
    			
    			txfSumOther.setText(otherSum + "");
    			
    			
    			for(int i = 0; i < btnResults.length; i++) {
    				int j = i;
    				
    				if(results[i] > 0) {
    				btnResults[i].setDisable(false);
    				btnResults[i].setText(results[i] + "");
    				btnResults[i].setOnAction(event -> this.setTotal(j, results[j]));
    				
    				}
    			}
    		}
    	} 
    }
    
    private void checkCheck() {
    	if(chbHolds[0].isSelected()) {
        	hold[0] = true;
        } else {
        	hold[0] = false;
        }
        
        if(chbHolds[1].isSelected()) {
        	hold[1] = true;
        } else {
        	hold[1] = false;
        }
        
        if(chbHolds[2].isSelected()) {
        	hold[2] = true;
        } else {
        	hold[2] = false;
        }
        
        if(chbHolds[3].isSelected()) {
        	hold[3] = true;
        } else {
        	hold[3] = false;
        }
        
        if(chbHolds[4].isSelected()) {
        	hold[4] = true;
        } else {
        	hold[4] = false;
        }
    }
    
    private void setTotal(int i, int r) {
    	int lastScore = Integer.parseInt(txfTotal.getText()) + Integer.parseInt(txfBonus.getText());
    	lastScore += r;
    	txfTotal.setText(lastScore + "");
    	
    	
    	if(i < 6) {
    		int lastSum = Integer.parseInt(txfSumSame.getText()) + r;
    		txfSumSame.setText(lastSum + "");
    	}
    	
    	for(int k = 0; k < btnResults.length; k++) {
    	btnResults[k].setDisable(true);
    	}
    	
    	restartGame(resetValues);
    	
    }
    
    private void restartGame(int[] values) {
    	yatzy.resetThrowCount();
    	lblRolled.setText(yatzy.getThrowCount() + "");
    	yatzy.setValues(values);
    	btnRoll.setDisable(false);
    	
    	
    	
    	for(int i = 0; i < chbHolds.length; i++) {
			chbHolds[i].setDisable(false);
			chbHolds[i].setSelected(false);
		}
    	
    }

    

}
