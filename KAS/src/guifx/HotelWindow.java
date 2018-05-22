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


public class HotelWindow extends Stage{
	private Hotel hotel;
	
	public HotelWindow(String title, Hotel hotel) {
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
	
	public HotelWindow(String title) {
		this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);
        

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
	}
	
	private TextField txfName, txfAdresse, txfPrisEnkelt, txfPrisDobbelt, txfNavn, txfTlfnr, txfEmail;
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

        Label lblHours = new Label("Adresse");
        pane.add(lblHours, 0, 2);

        txfAdresse = new TextField();
        pane.add(txfAdresse, 0, 3);
        
        Label lblPris = new Label("Pris (Enkelt)");
        pane.add(lblPris, 0, 4);
        
        txfPrisEnkelt = new TextField();
        pane.add(txfPrisEnkelt, 0, 5);
        txfPrisEnkelt.setPrefWidth(200);
        
        Label lblPris2 = new Label("Pris (Dobbelt)");
        pane.add(lblPris2, 0, 6);
        
        txfPrisDobbelt = new TextField();
        pane.add(txfPrisDobbelt, 0, 7);
        txfPrisDobbelt.setPrefWidth(200);
         
        Label lblName2 = new Label("Navn på hotelbestyrer");
        pane.add(lblName2, 0, 8);

        txfNavn = new TextField();
        pane.add(txfNavn, 0, 9);
        txfNavn.setPrefWidth(200);
        
        Label lblTflnr = new Label("Tlf.Nr. på hotelbestyrer");
        pane.add(lblTflnr, 0, 10);

        txfTlfnr = new TextField();
        pane.add(txfTlfnr, 0, 11);
        txfTlfnr.setPrefWidth(200);
        
        Label lblEmail = new Label("E-Mail på hotelbestyrer");
        pane.add(lblEmail, 0, 12);

        txfEmail = new TextField();
        pane.add(txfEmail, 0, 13);
        txfEmail.setPrefWidth(200);
          
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
     	txfAdresse.clear();
     	txfPrisEnkelt.clear();
        txfNavn.clear();
        txfTlfnr.clear();
        txfEmail.clear();
    	
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

        String Adresse = txfAdresse.getText().trim();
        if(Adresse.length() == 0) {
        	lblError.setText("Udfyld adresse");
            return;
        }
        
        double prisEnkelt = 0.0;
        try {
        	prisEnkelt = Double.parseDouble(txfPrisEnkelt.getText().trim());
        } catch (NumberFormatException ex) {
            // do nothing
        }
        if (prisEnkelt < 0) {
            lblError.setText("Pris skal være et positivt tal");
            return;
        }
        
        double prisDobbelt = 0.0;
        try {
        	prisDobbelt = Double.parseDouble(txfPrisDobbelt.getText().trim());
        } catch (NumberFormatException ex) {
            // do nothing
        }
        if (prisDobbelt < 0) {
            lblError.setText("Pris skal være et positivt tal");
            return;
        }
        
        Person hotelbestyrer = Service.createPerson(txfNavn.getText().trim(), txfTlfnr.getText().trim(), txfEmail.getText().trim());
        
        String navn = txfName.getText().trim();
        
        String adresse = txfAdresse.getText().trim();

        // Call service methods
        if(hotel == null) {
        Service.createHotel(navn, adresse, prisEnkelt, prisDobbelt, hotelbestyrer.getTlfnr(), hotelbestyrer);
        } else {
        	Service.updateHotel(hotel, navn, Adresse, prisEnkelt, prisDobbelt, hotelbestyrer.getTlfnr(), hotelbestyrer);
        }

        this.hide();
    }
}
