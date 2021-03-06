package guifx;

import application.service.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class KajsbilerMainApp extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}
	
	@Override
    public void init() {
        Service.initStorage();
    }

	@Override
	public void start(Stage stage) {
		// TODO Auto-generated method stub
		stage.setTitle("Kajs Biler");
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
		// TODO Auto-generated method stub
		tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		
		Tab tabBiler = new Tab("Administration");
		tabPane.getTabs().add(tabBiler);
		
		AdminPane adminpane = new AdminPane();
		tabBiler.setContent(adminpane);
		tabBiler.setOnSelectionChanged(event -> adminpane.updateControls());
		
		Tab tabKunde = new Tab("Udlejning");
		tabPane.getTabs().add(tabKunde);
		
		KundePane kundepane = new KundePane();
		tabKunde.setContent(kundepane);
		tabKunde.setOnSelectionChanged(event -> kundepane.updateControls());
	}
}
