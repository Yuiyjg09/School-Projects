package guifx;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import application.model.*;
import application.service.*;
import java.time.LocalDate;

public class UdflugtWindow extends Stage {
	private Konference konference;
	
	public UdflugtWindow(String title, Konference konference) {
		this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.konference = konference;

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
	}
	
	public UdflugtWindow(String title) {
		this(title, null);
	}
	
	private TextField txfName, txfBeskrivelse, txfPris, txfNavn, txfTlfnr, txfEmail;
    private Label lblError;
    private DatePicker datepicker;

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

        txfBeskrivelse = new TextField();
        pane.add(txfBeskrivelse, 0, 3);
        
        Label lblPris = new Label("Pris");
        pane.add(lblPris, 0, 4);
        
        txfPris = new TextField();
        pane.add(txfPris, 0, 5);
        txfPris.setPrefWidth(200);
        
        
        datepicker = new DatePicker();
        datepicker.setValue(LocalDate.now());
        final Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>() {
        	@Override
            public DateCell call(final DatePicker datePicker) {
              return new DateCell() {
                @Override
                public void updateItem(LocalDate item, boolean empty) {
                  super.updateItem(item, empty);

                  if (item.isBefore(datepicker.getValue().plusDays(1))) {
                    setDisable(true);
                    setStyle("-fx-background-color: #EEEEEE;");
                  }
                }
              };
            }
          };
          
          datepicker.setDayCellFactory(dayCellFactory);
          pane.add(new Label("Dato"), 0, 6);
          pane.add(datepicker, 0, 7);
          
        Label lblName2 = new Label("Navn på Udflugtsafholder");
        pane.add(lblName2, 0, 8);

        txfNavn = new TextField();
        pane.add(txfNavn, 0, 9);
        txfNavn.setPrefWidth(200);
        
        Label lblTflnr = new Label("Tlf.Nr. på Udflugtsafholder");
        pane.add(lblTflnr, 0, 10);

        txfTlfnr = new TextField();
        pane.add(txfTlfnr, 0, 11);
        txfTlfnr.setPrefWidth(200);
        
        Label lblEmail = new Label("E-Mail på Udflugtsafholder");
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
     	txfBeskrivelse.clear();
        txfPris.clear();
        txfNavn.clear();
        txfTlfnr.clear();
        txfEmail.clear();
    	
    }

    // -------------------------------------------------------------------------

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
        
        Person udflugtsafholder = Service.createPerson(txfNavn.getText().trim(), txfTlfnr.getText().trim(), txfEmail.getText().trim());
        
        LocalDate datoTid = datepicker.getValue();

        // Call service methods
        
            Service.createUdflugt(konference, name, beskrivelse, udflugtsafholder, datoTid, pris);
        

        this.hide();
    }
}
