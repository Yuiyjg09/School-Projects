package guifx;

import java.util.Optional;

import application.model.*;
import application.service.Service;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class HotelPane extends GridPane {
	private ListView<Konference> lvwKonferencer;
	private ListView<Hotel> lvwHoteller;
	private TextArea txaHotelServices;
	
	public HotelPane() {
		this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);
        
        Label lblKon = new Label("Konferencer");
        this.add(lblKon, 0, 0);
        
        lvwKonferencer= new ListView<>();
        this.add(lvwKonferencer, 0, 1, 1, 3);
        lvwKonferencer.setPrefWidth(200);
        lvwKonferencer.setPrefHeight(200);
        lvwKonferencer.getItems().setAll(Service.getKonferencer());
        
        
        Label lblHot = new Label("Hoteller");
        this.add(lblHot, 1, 0);
        
        lvwHoteller = new ListView<>();
        this.add(lvwHoteller, 1, 1, 1, 3);
        lvwHoteller.setPrefWidth(200);
        lvwHoteller.setPrefHeight(200);
        lvwHoteller.getItems().setAll(Service.getHoteller());
        
        ChangeListener<Hotel> listener2 =
            (ov, oldCompny, newCompany) -> this.updateControls();
            lvwHoteller.getSelectionModel().selectedItemProperty().addListener(listener2);
        
        Label lblHotelservices = new Label("Hotel-services:");
        this.add(lblHotelservices, 5, 4);
        GridPane.setValignment(lblHotelservices, VPos.BASELINE);
        lblHotelservices.setPadding(new Insets(4, 0, 4, 0));
        
        txaHotelServices = new TextArea();
        this.add(txaHotelServices, 6, 4);
        txaHotelServices.setPrefWidth(200);
        txaHotelServices.setPrefHeight(100);
        txaHotelServices.setEditable(false);
        
        if (lvwKonferencer.getItems().size() > 0) {
        	lvwKonferencer.getSelectionModel().select(0);
        }
        
        if (lvwHoteller.getItems().size() > 0) {
        	lvwHoteller.getSelectionModel().select(0);
        }
        
        HBox hbxButtons = new HBox(40);
        this.add(hbxButtons, 0, 5, 3, 1);
        hbxButtons.setPadding(new Insets(10, 0, 0, 0));
        hbxButtons.setAlignment(Pos.BASELINE_CENTER);
        
        Button btnCreate = new Button("Create Hotel");
        hbxButtons.getChildren().add(btnCreate);
        btnCreate.setOnAction(event -> this.createAction());

        Button btnUpdate = new Button("Update Hotel");
        hbxButtons.getChildren().add(btnUpdate);
        btnUpdate.setOnAction(event -> this.updateAction());

        Button btnDelete = new Button("Delete Hotel");
        hbxButtons.getChildren().add(btnDelete);
        btnDelete.setOnAction(event -> this.deleteAction());
        
        Button btnHotelService = new Button("Create HotelService");
        hbxButtons.getChildren().add(btnHotelService);
        btnHotelService.setOnAction(event -> this.createAction2());
        
	}
	
	private void createAction2() {
		Hotel hotellet = lvwHoteller.getSelectionModel().getSelectedItem();
		HotelServiceWindow dia = new HotelServiceWindow("Create Hotel", hotellet);
        dia.showAndWait();

        // Wait for the modal dialog to close
        int index2 = lvwHoteller.getItems().size() - 1;
        lvwHoteller.getItems().setAll(Service.getHoteller());
		lvwHoteller.getSelectionModel().select(index2);
    }
	
	private void createAction() {
		HotelWindow dia = new HotelWindow("Create Hotel");
        dia.showAndWait();

        // Wait for the modal dialog to close

        lvwHoteller.getItems().setAll(Service.getHoteller());
		int index2 = lvwHoteller.getItems().size() - 1;
		lvwHoteller.getSelectionModel().select(index2);
    }

    private void updateAction() {
    	Hotel company = lvwHoteller.getSelectionModel().getSelectedItem();
        if (company == null)
            return;

        HotelWindow dia = new HotelWindow("Update Hotel", company);
        dia.showAndWait();

        // Wait for the modal dialog to close

        lvwHoteller.getItems().setAll(Service.getHoteller());
		int index2 = lvwHoteller.getItems().size() - 1;
		lvwHoteller.getSelectionModel().select(index2);
    }

    private void deleteAction() {
    	Hotel company = lvwHoteller.getSelectionModel().getSelectedItem();
        if (company == null)
            return;

        
            Stage owner = (Stage) this.getScene().getWindow();
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Slet Hotel");
            alert.initOwner(owner);
            alert.setHeaderText("Er du sikker?");

            // Wait for the modal dialog to close
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                Service.deleteHotel(company);
                lvwKonferencer.getItems().setAll(Service.getKonferencer());
                this.updateControls();
            }
    }
	
	
	public void updateControls() {
		lvwKonferencer.getItems().setAll(Service.getKonferencer());
		int index = lvwKonferencer.getItems().size() - 1;
		lvwKonferencer.getSelectionModel().select(index);
		
		Hotel hotel = lvwHoteller.getSelectionModel().getSelectedItem();
		lvwHoteller.getItems().setAll(Service.getHoteller());
		int index2 = lvwHoteller.getItems().size() - 1;
		lvwHoteller.getSelectionModel().select(index2);
		
		if(hotel != null) {
			StringBuilder sb2 = new StringBuilder();
            for (HotelService hts : hotel.getHotelServices()) {
                sb2.append(hts + "\n");
            }
            txaHotelServices.setText(sb2.toString());
            }
            
	}
}
	
		

