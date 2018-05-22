package guifx;

import application.service.Service;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class KundeWindow extends Stage{
	
	public KundeWindow(String title) {
		this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);
        
        
        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);
        
        Scene scene = new Scene(pane);
        this.setScene(scene);
	}
	
	private TextField txfNavn, txfTlfnr, txfEmail;
	private CheckBox chbErhvervskunde;
	
	private void initContent(GridPane pane) {
		
		Label lblNavn = new Label("Navn:");
		pane.add(lblNavn, 0, 0);
		
		txfNavn = new TextField();
		pane.add(txfNavn, 0, 1);
		
		Label lblTlfnr = new Label("Tlf.Nr.:");
		pane.add(lblTlfnr, 0, 2);
		
		txfTlfnr = new TextField();
		pane.add(txfTlfnr, 0, 3);
		
		Label lblEmail = new Label("E-Mail:");
		pane.add(lblEmail, 0, 4);
		
		txfEmail = new TextField();
		pane.add(txfEmail, 0, 5);
		
		Label lblErhvervskunde = new Label("Erhvervskunde");
		pane.add(lblErhvervskunde, 0, 6);
		
		chbErhvervskunde = new CheckBox();
		pane.add(chbErhvervskunde, 1, 6);
		
		Button btnCreateKunde = new Button("Opret");
		pane.add(btnCreateKunde, 0, 7);
		btnCreateKunde.setOnAction(event -> this.createKundeAction());
		
		Button btnCancel = new Button("Cancel");
		pane.add(btnCancel, 1, 7);
		btnCancel.setOnAction(event -> this.cancelAction());
	}
	
	private void cancelAction() {
		this.hide();
	}
	
	private void createKundeAction() {
		String navn = txfNavn.getText().trim();
		String tlfnr = txfTlfnr.getText().trim();
		String email = txfEmail.getText().trim();
		boolean erhvervskunde = chbErhvervskunde.isSelected();
		
		if(!(navn.equals(null)) && !(tlfnr.equals(null)) && !(email.equals(null))) {
			Service.createKunde(navn, email, tlfnr, erhvervskunde);
			this.hide();
		} else {
			Alert alert = new Alert(null);
			alert.setAlertType(AlertType.INFORMATION);
			alert.setHeaderText("Fejl");
			alert.setContentText("Nødvending information er ikke udfyldt");
			alert.showAndWait();
		}
	}
}
