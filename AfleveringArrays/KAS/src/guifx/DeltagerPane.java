package guifx;

import application.model.*;
import application.service.Service;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;



public class DeltagerPane extends GridPane {
    private ListView<Konference> konferencer;
    private TextArea deltagere;
    private TextField konfTitel;
    private TextArea konfBeskriv;
	
	public DeltagerPane() {
		this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);
        
        Label lblKonf = new Label("Konferencer");
        this.add(lblKonf, 0, 1);
        
        konferencer = new ListView<>();
        this.add(konferencer, 0, 2, 1, 3);
        konferencer.setPrefHeight(200);
        konferencer.setPrefWidth(200);
        konferencer.getItems().setAll(Service.getKonferencer());
        
        ChangeListener<Konference> listener = (ov, oldKonf, newKonf) -> this.selectedKonferenceChanged();
        konferencer.getSelectionModel().selectedItemProperty().addListener(listener);
        
        konfTitel = new TextField();
        this.add(konfTitel, 3, 2);
        konfTitel.setEditable(false);
        
        konfBeskriv = new TextArea();
        this.add(konfBeskriv, 3, 3);
        konfBeskriv.setPrefHeight(150);
        konfBeskriv.setPrefWidth(200);
        konfBeskriv.setEditable(false);
        
        Label lblDelt = new Label("Deltagere");
        this.add(lblDelt, 4, 1);
        
        deltagere = new TextArea();
        this.add(deltagere, 4, 2, 1, 3);
        deltagere.setPrefHeight(200);
        deltagere.setPrefWidth(200);
        deltagere.setEditable(false);
        
        Button btnTilmeld = new Button("Tilmeld");
        this.add(btnTilmeld, 6, 4);
        btnTilmeld.setOnAction(event -> this.tilmeldAction());
        
        if (konferencer.getItems().size() > 0) {
        	konferencer.getSelectionModel().select(0);
        }
	}
	
	private void tilmeldAction() {
	    Konference konference = konferencer.getSelectionModel().getSelectedItem();
	    if (konference == null) {
	        return;
	    }
	    
	    TilmeldWindow dia = new TilmeldWindow("Tilmeld Deltager", konference);
	    dia.showAndWait();
	    
	}
	
	private void selectedKonferenceChanged() {
	    this.updateControls();
	}
	
	public void updateControls() {
		int selectIndex = konferencer.getSelectionModel().getSelectedIndex();
        konferencer.getItems().setAll(Service.getKonferencer());
        konferencer.getSelectionModel().select(selectIndex);
        
		Konference konference = konferencer.getSelectionModel().getSelectedItem();
		if (konference != null) {
		    konfTitel.setText(konference.getNavn());
		    konfBeskriv.setText(konference.getAdresse() + "\n" + konference.getDatoTid() + "\n" + konference.getPris());
		    StringBuilder sb = new StringBuilder();
		    for (Deltager delt : konference.getDeltagere()) {
		    	sb.append(delt + "\n");
		        
		    }
		    deltagere.setText(sb.toString());
		} else {
		    konfTitel.clear();
		    konfBeskriv.clear();
		    deltagere.clear();
		}
	}
}