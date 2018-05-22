package guifx;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import service.Service;
import opg1.*;

public class MainApp extends Application{

	public static void main(String[] args) {
		Application.launch(args);
	}
	
	public void initStorage() {
		Service.createSomeObjects();
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Administration af Spiller-deltagelse");
        GridPane pane = new GridPane();
        this.initContent(pane);
        this.initStorage();
        
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
		
	}
//---------------------------------------------------------------------------------------------------------------------	
	private TextField txfSted, txfDato, txfTid;
	private ListView<Kamp> lvwKampe;
	
	private void initContent(GridPane pane) {
		pane.setGridLinesVisible(false);

        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(10);
        
        Label lblkamp = new Label("Kampe:");
        pane.add(lblkamp, 0, 0);
        
        lvwKampe = new ListView<>();
        pane.add(lvwKampe, 0, 1, 1, 3);
        lvwKampe.setPrefHeight(200);
        lvwKampe.setPrefWidth(200);
        lvwKampe.getItems().setAll(Service.getKampe());
        
        ChangeListener<Kamp> listener =
                (ov, oldCompny, newCompany) -> this.updateControls();
                lvwKampe.getSelectionModel().selectedItemProperty().addListener(listener);
                
        Label lblSted = new Label("Sted:");
        pane.add(lblSted, 2, 1);
        
        txfSted = new TextField();
        pane.add(txfSted, 2, 2);
        txfSted.setEditable(false);
        
        Label lblDato = new Label("Dato:");
        pane.add(lblDato, 2, 3);
        
        txfDato = new TextField();
        pane.add(txfDato, 2, 4);
        txfDato.setEditable(false);
        
        Label lblTid = new Label("Tid:");
        pane.add(lblTid, 2, 5);
        
        txfTid = new TextField();
        pane.add(txfTid, 2, 6);
        txfTid.setEditable(false);
        
        Button btnOpret = new Button("Opret");
        pane.add(btnOpret, 2, 7);
        btnOpret.setOnAction(event -> this.createKampAction());
        
        Button btnUpdate = new Button("Opdater");
        pane.add(btnUpdate, 3, 7);
        btnUpdate.setOnAction(event -> this.updateKampAction());
        
        Button btnFile = new Button("Lav Fil");
        pane.add(btnFile, 2, 8);
        btnFile.setOnAction(event -> this.createFileAction());
    }

	public void updateControls() {
		Kamp kamp = lvwKampe.getSelectionModel().getSelectedItem();
		if(kamp != null) {
			txfSted.setText(kamp.getSted());
			txfDato.setText(kamp.getDato().toString());
			txfTid.setText(kamp.getTid().toString());
		} else {
			txfSted.clear();
			txfDato.clear();
			txfTid.clear();
		}
	}
	
	private void createKampAction() {
		KampWindow dia = new KampWindow("Opret Kamp");
		dia.showAndWait();
		
		lvwKampe.getItems().setAll(Service.getKampe());
		int index = lvwKampe.getItems().size() -1;
		lvwKampe.getSelectionModel().select(index);
	}
	
	private void updateKampAction() {
		Kamp kamp = lvwKampe.getSelectionModel().getSelectedItem();
		KampWindow dia = new KampWindow("Opret Kamp", kamp);
		dia.showAndWait();
		
		lvwKampe.getItems().setAll(Service.getKampe());
		int index = lvwKampe.getItems().size() -1;
		lvwKampe.getSelectionModel().select(index);
	}
	
	private void createFileAction() {
		Kamp kamp = lvwKampe.getSelectionModel().getSelectedItem();
		if(kamp != null) {
			kamp.spillerHonorar("kampe.txt");
		}
	}
	
	

}
