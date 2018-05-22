package guifx;

import java.time.LocalDate;
import java.time.LocalTime;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import opg1.*;
import service.Service;

public class KampWindow extends Stage{
	private Kamp kamp;
	
	public KampWindow(String title, Kamp kamp) {
		this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.kamp = kamp;

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
	}
	
	

	public KampWindow(String title) {
		this(title, null);
	}
	
	//-----------------------------------------------------------------------------------------------
	
	private TextField txfSted, txfTimer, txfMinuter;
	private DatePicker dp1;
	
	private void initContent(GridPane pane) {
		pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);
        
        Label lblSted = new Label("Sted:");
        pane.add(lblSted, 0, 0);
        
        txfSted = new TextField();
        pane.add(txfSted, 0, 1);
        
        Label lblTimer = new Label("Timer");
        pane.add(lblTimer, 0, 2);
        
        Label lblMinuter = new Label("Minuter");
        pane.add(lblMinuter, 0, 4);
        
        txfTimer = new TextField();
        pane.add(txfTimer, 0, 3);
        
        txfMinuter = new TextField();
        pane.add(txfMinuter, 0, 5);
        
        dp1 = new DatePicker();
        pane.add(dp1, 0, 6);
        dp1.setValue(LocalDate.now());
        
        Button btnOk = new Button("OK");
        pane.add(btnOk, 0, 7);
        btnOk.setOnAction(event -> this.okAction());
        
        Button btnCancel = new Button("Cancel");
        pane.add(btnCancel, 0, 8);
        btnCancel.setOnAction(event -> this.cancelAction());
        
        this.initControls();
        		
	}
	
	private void initControls() {
        if (kamp != null) {
            txfSted.setText(kamp.getSted());
            txfTimer.setText(kamp.getTid().getHour() + "");
            txfTimer.setText(kamp.getTid().getMinute() + "");
            
        } else {
            txfSted.clear();
            txfTimer.clear();
            txfMinuter.clear();
        }
    }
	
	private void cancelAction() {
        this.hide();
    }
	
	private void okAction() {
		if(txfSted.getText() != null && txfTimer.getText() != null && txfMinuter.getText() != null) {
			String sted = txfSted.getText();
			
			int timer = 0;
			int minuter = 0;
			try {
	            timer = Integer.parseInt(txfTimer.getText().trim());
	            minuter = Integer.parseInt(txfMinuter.getText().trim());
	        } catch (NumberFormatException ex) {
	            // do nothing
	        }
			
			if(!(minuter > -1) && !(minuter < 60)) {
				System.out.println("Invalid input");
				return;
			}
			
			if(!(timer > -1) && !(timer < 24)) {
				System.out.println("Invalid input");
				return;
			}
			
			LocalTime tid = LocalTime.of(timer, minuter);
			
			LocalDate dato = dp1.getValue();
			
			if(dato.isBefore(LocalDate.now())) {
				System.out.println("Invalid input");
				return;
			}
			
			if(kamp != null) {
				Service.updateKamp(kamp, sted, dato, tid);
			} else {
				Service.createKamp(sted, dato, tid);
			}
			
			this.hide();
		}
	}

}
