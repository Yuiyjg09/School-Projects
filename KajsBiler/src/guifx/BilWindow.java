package guifx;

import application.service.Service;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class BilWindow extends Stage {
	
	public BilWindow(String title) {
		this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);
        
        
        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);
        
        Scene scene = new Scene(pane);
        this.setScene(scene);
	}
	
	private TextField txfMaerke, txfModel, txfNummerplade;
	private ComboBox<String> cbBrændstof;

	private void initContent(GridPane pane) {
		// TODO Auto-generated method stub
		
		Label lblMaerke = new Label("Mærke: ");
		pane.add(lblMaerke, 0, 0);
		
		txfMaerke = new TextField();
		pane.add(txfMaerke, 0, 1);
		
		Label lblModel = new Label("Model: ");
		pane.add(lblModel, 0, 2);
		
		txfModel = new TextField();
		pane.add(txfModel, 0, 3);
		
		Label lblNummerplade = new Label("Nummerplade:");
		pane.add(lblNummerplade, 0, 4);
		
		txfNummerplade = new TextField();
		pane.add(txfNummerplade, 0, 5);
		
		Label lblBrændstof = new Label("Brændstof:");
		pane.add(lblBrændstof, 0, 6);
		
		cbBrændstof = new ComboBox<String>();
		pane.add(cbBrændstof, 0, 7);
		cbBrændstof.getItems().add("Benzin");
		cbBrændstof.getItems().add("Diesel");
		cbBrændstof.getItems().add("El");
		cbBrændstof.getItems().add("Hybrid: Benzin/El");
		cbBrændstof.getItems().add("Hybrid: Diesel/El");
		cbBrændstof.getSelectionModel().select(0);
		
		Button btnRegistrer = new Button("Registrer Bil");
		pane.add(btnRegistrer, 0, 8);
		btnRegistrer.setOnAction(event -> this.registrerAction());
		
		Button btnCancel = new Button("Cancel");
		pane.add(btnCancel, 1, 8);
		btnCancel.setOnAction(event -> this.cancelAction());
	}
	
	private void cancelAction() {
		this.hide();
	}
	
	private void registrerAction() {
		if(!(txfMaerke.getText().equals(null)) && !(txfModel.getText().equals(null)) && !(txfNummerplade.getText().equals(null))) {
			String maerke = txfMaerke.getText().trim();
			String model = txfModel.getText().trim();
			String nummerplade = txfNummerplade.getText().trim();
			String brændstof = cbBrændstof.getSelectionModel().getSelectedItem();
			
			Service.createBil(model, maerke, nummerplade, brændstof);
			
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