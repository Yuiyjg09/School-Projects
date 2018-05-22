package guifx;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import application.model.*;
import application.service.*;


public class HotelServiceWindow extends Stage {
	private Hotel hotel;
	
	public HotelServiceWindow(String title, Hotel hotel) {
		this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);
        
        this.hotel = hotel;
        
        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);

	}
	
	private TextField txfName, txfBeskrivelse, txfPris;
	private Label lblError;
	
	private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblName = new Label("Navn");
        pane.add(lblName, 0, 0);

        txfName = new TextField();
        pane.add(txfName, 0, 1);
        txfName.setPrefWidth(200);

        Label lblHours = new Label("Beskrivelse");
        pane.add(lblHours, 0, 2);

        txfBeskrivelse = new TextField();
        pane.add(txfBeskrivelse, 0, 3);
        
        Label lblPris = new Label("Pris");
        pane.add(lblPris, 0, 4);
        
        txfPris = new TextField();
        pane.add(txfPris, 0, 5);
        txfPris.setPrefWidth(200);
          
        Button btnCancel = new Button("Cancel");
        pane.add(btnCancel, 0, 14);
        GridPane.setHalignment(btnCancel, HPos.LEFT);
        btnCancel.setOnAction(event -> this.cancelAction());

        Button btnOK = new Button("OK");
        pane.add(btnOK, 0, 14);
        GridPane.setHalignment(btnOK, HPos.RIGHT);
        btnOK.setOnAction(event -> this.okAction());

        lblError = new Label();
        pane.add(lblError, 0, 15);
        lblError.setStyle("-fx-text-fill: red");

        this.initControls();
    }

    private void initControls() {
    	
    	txfName.clear();
     	txfBeskrivelse.clear();
        txfPris.clear();
    	
    }
    
    private void cancelAction() {
        this.hide();
    }

    private void okAction() {
        String name = txfName.getText().trim();
        if (name.length() == 0) {
            lblError.setText("Udfyld navn");
            return;
        }

        String beskrivelse = txfBeskrivelse.getText().trim();
        if(beskrivelse.length() == 0) {
        	lblError.setText("Udfyld adresse");
            return;
        }
        
        double pris = 0.0;
        try {
            pris = Double.parseDouble(txfPris.getText().trim());
        } catch (NumberFormatException ex) {
            // do nothing
        }
        if (pris < 0) {
            lblError.setText("Pris skal være et positivt tal");
            return;
        }
        
        

        // Call service methods
        Service.createHotelService(hotel, name, beskrivelse, pris);
            
        

        this.hide();
    }
}
