package guifx;

import java.util.ArrayList;

import application.model.*;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import storage.Storage;


public class KundePane extends GridPane {
	
	private ListView<Kunde> lvwKunder;
	private ListView<Udlejning> lvwUdlejninger;
	private TextField txfSearch;
	
	public KundePane() {
		this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);
        
        Label lblSearch = new Label("Søg efter Kunde:");
        this.add(lblSearch, 0, 0);
        
        txfSearch = new TextField();
        this.add(txfSearch, 0, 1);
        
        Button btnSearch = new Button("Søg");
        this.add(btnSearch, 1, 1);
        btnSearch.setOnAction(event -> this.searchAction());
        
        lvwKunder = new ListView<Kunde>();
        this.add(lvwKunder, 0, 2, 1, 3);
        lvwKunder.setPrefHeight(200);
        lvwKunder.setPrefWidth(200);
        
        ChangeListener<Kunde> listener = (ov, oldKunde, newKunde) -> this.selectedKundeChanged();
        lvwKunder.getSelectionModel().selectedItemProperty().addListener(listener);
        
        lvwUdlejninger = new ListView<Udlejning>();
        this.add(lvwUdlejninger, 2, 2, 1, 3);
        lvwUdlejninger.setPrefHeight(200);
        lvwUdlejninger.setPrefWidth(200);
        
        ChangeListener<Udlejning> listener2 = (ov, oldKunde, newKunde) -> this.selectedUdlejningChanged();
        lvwUdlejninger.getSelectionModel().selectedItemProperty().addListener(listener2);
        
        Button btnNyKunde = new Button("Opret Ny Kunde");
        this.add(btnNyKunde, 0, 5);
        btnNyKunde.setOnAction(event -> this.createKundeAction());
        
        Button btnSletKunde = new Button("Slet Kunde");
        this.add(btnSletKunde, 2, 5);
        btnSletKunde.setOnAction(event -> this.deleteKundeAction());
        
        Button btnNyUdlejning = new Button("Lav ny Udlejning");
        this.add(btnNyUdlejning, 0, 6);
        btnNyUdlejning.setOnAction(event -> this.createUdlejningAction());
        
        Button btnVisUdlejning = new Button("Vis Udlejning");
        this.add(btnVisUdlejning, 1, 6);
        btnVisUdlejning.setOnAction(event -> this.visUdlejningAction());
        
        Button btnSletUdlejning = new Button("Slet Udlejning");
        this.add(btnSletUdlejning, 2, 6);
        btnSletUdlejning.setOnAction(event -> this.sletUdlejningAction());
        
	}
	
	private void selectedUdlejningChanged() {}

	public void updateControls() {}	
	
	private void searchAction() {
		ArrayList<Kunde> kunderFound = new ArrayList<>();
		boolean found = false;
		char[] searchTerm = txfSearch.getText().toLowerCase().trim().toCharArray();
		
		if(!txfSearch.getText().equals(null)) {
			for(Kunde kd : Storage.getKunder()) {
				char[] searchSet = kd.toString().toLowerCase().trim().toCharArray();
				int j = 0;
				while(!found && j < searchSet.length) {
					for(int i = 0; i < searchTerm.length ; i++) {
						if(searchSet[j] == searchTerm[i]) {
								kunderFound.add(kd);
								found = true;
						}
					}
					
					j++;
				}
			}
			
			if(found) {
				lvwKunder.getItems().setAll(kunderFound);
				lvwKunder.getSelectionModel().select(0);
				txfSearch.setText("");
			} else if(txfSearch.getText().equals(null)) {
				Alert alert = new Alert(null);
				alert.setAlertType(AlertType.INFORMATION);
				alert.setHeaderText("Intet input");
				alert.setContentText("Skriv navnet på kunden");
				alert.showAndWait();
			} else {
				Alert alert = new Alert(null);
				alert.setAlertType(AlertType.INFORMATION);
				alert.setHeaderText("Ingen Kunder fundet");
				alert.setContentText("Opret en ny Kunde");
				alert.showAndWait();
			}
		}
	}
	
	private void selectedKundeChanged() {
		if(!lvwKunder.getItems().isEmpty() && !lvwKunder.getSelectionModel().getSelectedItem().equals(null)) {
			System.out.println(lvwUdlejninger);
			lvwUdlejninger.getItems().setAll(lvwKunder.getSelectionModel().getSelectedItem().getUdlejninger());
			
		} else {
			lvwUdlejninger.getItems().setAll();
		}
	}
	
	private void createKundeAction() {
		KundeWindow dia = new KundeWindow("Opret ny Kunde");
		dia.showAndWait();
	}
	
	private void deleteKundeAction() {
		if(!(lvwKunder.getItems().isEmpty())) {
			lvwKunder.getItems().remove(lvwKunder.getSelectionModel().getSelectedItem());
			Storage.removeKunde(lvwKunder.getSelectionModel().getSelectedItem());
			
		} else {
			Alert alert = new Alert(null);
			alert.setAlertType(AlertType.INFORMATION);
			alert.setHeaderText("Ingen Kunde valgt");
			alert.setContentText("Vælg en Kunde, der skal slettes");
			alert.showAndWait();
		}
	}
	
	private void createUdlejningAction() {
		if(!(lvwKunder.getItems().isEmpty())) {
			UdlejningWindow dia = new UdlejningWindow("Opret Udlejning", lvwKunder.getSelectionModel().getSelectedItem());
			dia.showAndWait();
			
			if(!lvwKunder.getSelectionModel().getSelectedItem().getUdlejninger().isEmpty()) {
				lvwUdlejninger.getItems().setAll(lvwKunder.getSelectionModel().getSelectedItem().getUdlejninger());
			}
		} else {
			Alert alert = new Alert(null);
			alert.setAlertType(AlertType.INFORMATION);
			alert.setHeaderText("Ingen Kunde valgt");
			alert.setContentText("Vælg en Kunde for at oprette en Udlejning");
			alert.showAndWait();
		}
	}
	
	private void visUdlejningAction() {
		if(!(lvwUdlejninger.getItems().isEmpty())) {
			VisUdlejningWindow dia = new VisUdlejningWindow("", lvwUdlejninger.getSelectionModel().getSelectedItem());
			dia.showAndWait();
			
		} else {
			Alert alert = new Alert(null);
			alert.setAlertType(AlertType.INFORMATION);
			alert.setHeaderText("Ingen Kunde valgt");
			alert.setContentText("Vælg en Kunde for at oprette en Udlejning");
			alert.showAndWait();
		}
	}
	
	private void sletUdlejningAction() {
		if(!(lvwUdlejninger.getItems().isEmpty())) {
			lvwKunder.getSelectionModel().getSelectedItem().removeUdlejninger(lvwUdlejninger.getSelectionModel().getSelectedItem());
			lvwUdlejninger.getItems().remove(lvwUdlejninger.getSelectionModel().getSelectedItem());
			Storage.removeUdlejninger(lvwUdlejninger.getSelectionModel().getSelectedItem());
		} else {
			Alert alert = new Alert(null);
			alert.setAlertType(AlertType.INFORMATION);
			alert.setHeaderText("Ingen Udlejning valgt");
			alert.setContentText("Vælg en Kunde for at oprette en Udlejning");
			alert.showAndWait();
		}
	}
}
