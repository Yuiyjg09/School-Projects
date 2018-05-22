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

public class KonferenceWindow extends Stage {
	private Konference konference;
	
	public KonferenceWindow(String title, Konference konference) {
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
	
	public KonferenceWindow(String title) {
		this(title, null);
	}
	
	private TextField txfName, txfAdresse, txfPris;
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

        txfAdresse = new TextField();
        pane.add(txfAdresse, 0, 3);
        
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
          
        Button btnCancel = new Button("Cancel");
        pane.add(btnCancel, 0, 8);
        GridPane.setHalignment(btnCancel, HPos.LEFT);
        btnCancel.setOnAction(event -> this.cancelAction());

        Button btnOK = new Button("OK");
        pane.add(btnOK, 0, 8);
        GridPane.setHalignment(btnOK, HPos.RIGHT);
        btnOK.setOnAction(event -> this.okAction());

        lblError = new Label();
        pane.add(lblError, 0, 9);
        lblError.setStyle("-fx-text-fill: red");

        this.initControls();
    }

    private void initControls() {
        if (konference != null) {
            txfName.setText(konference.getNavn());
            txfAdresse.setText("" + konference.getAdresse());
            txfPris.setText("" + konference.getPris());
        } else {
            txfName.clear();
            txfAdresse.clear();
            txfPris.clear();
        }
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

        String adresse = txfAdresse.getText().trim();
        if(adresse.length() == 0) {
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
        
        LocalDate datoTid = datepicker.getValue();

        // Call service methods
        if (konference != null) {
            Service.updateKonference(konference, name, adresse, datoTid, pris);;
        } else {
            Service.createKonference(name, adresse, datoTid, pris);
        }

        this.hide();
    }
}
