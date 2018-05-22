package guifx;

import application.service.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class KASMainApp extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
    public void init() {
        Service.initStorage();
    }
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("KAS");
        BorderPane pane = new BorderPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
	}
	
	private void initContent(BorderPane pane) {
        TabPane tabPane = new TabPane();
        this.initTabPane(tabPane);
        pane.setCenter(tabPane);
    }
	
	private void initTabPane(TabPane tabPane) {
		tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		
		Tab tabDeltagere = new Tab("Deltagere");
		tabPane.getTabs().add(tabDeltagere);
		
		DeltagerPane deltagerPane = new DeltagerPane();
		tabDeltagere.setContent(deltagerPane);
		tabDeltagere.setOnSelectionChanged(event -> deltagerPane.updateControls());
		
		Tab tabKonferencer = new Tab("Konferencer");
		tabPane.getTabs().add(tabKonferencer);
		
		KonferencePane konferencePane = new KonferencePane();
		tabKonferencer.setContent(konferencePane);
		tabKonferencer.setOnSelectionChanged(event -> konferencePane.updateControls());
		
		Tab tabHotel = new Tab("Hotel");
		tabPane.getTabs().add(tabHotel);
		
		HotelPane hotelPane = new HotelPane();
		tabHotel.setContent(hotelPane);
		tabHotel.setOnSelectionChanged(event -> hotelPane.updateControls());
	}
}
