package guifx;

import application.service.Service;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class KatagoriPane extends Stage {
	
	public KatagoriPane(String title) {
		this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);
        
        
        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);
        
        Scene scene = new Scene(pane);
        this.setScene(scene);
	}

	private TextField txfNavn, txfPris;
	
	private void initContent(GridPane pane) {
		// TODO Auto-generated method stub
		
		Label lblNavn = new Label("Navn på Katagori:");
		pane.add(lblNavn, 0, 0);
		
		txfNavn = new TextField();
		pane.add(txfNavn, 0, 1);
		
		Label lblPris = new Label("Pris pr. dag: ");
		pane.add(lblPris, 0, 2);
		
		txfPris = new TextField();
		pane.add(txfPris, 0, 3);
		
		Button btnCreate = new Button("Opret Katagori");
		pane.add(btnCreate, 0, 4);
		btnCreate.setOnAction(event -> this.createAction());
		
		Button btnCancel = new Button("Cancel");
		pane.add(btnCancel, 1, 4);
		btnCancel.setOnAction(event -> this.cancelAction());
	}
	
	private void cancelAction() {
		this.hide();
	}
	
	private void createAction() {
		if(!(txfNavn.getText().equals(null)) && !(txfPris.getText().equals(null))) {
			String navn = txfNavn.getText().trim();
			double pris = Double.parseDouble(txfPris.getText().trim());
			if(pris >= 0) {
			Service.createKatagori(navn, pris);
			}
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
