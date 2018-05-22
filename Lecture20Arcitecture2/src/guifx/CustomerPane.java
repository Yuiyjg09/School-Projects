package guifx;

import application.model.Company;
import application.model.Customer;
import application.service.Service;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class CustomerPane extends Stage {
    private Customer customer;
    private Company companyAdd;

    public CustomerPane(String title, Customer customer, Company companyAdd) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.customer = customer;
        this.companyAdd = companyAdd;

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    public CustomerPane(String title, Company companyAdd) {
    	this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.companyAdd = companyAdd;

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
        
    }

    // -------------------------------------------------------------------------

    private TextField txfName, txfID;
    private Label lblError;

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblName = new Label("Name");
        pane.add(lblName, 0, 0);

        txfName = new TextField();
        pane.add(txfName, 0, 1);
        txfName.setPrefWidth(200);

        Label lblID = new Label("Customer ID:");
        pane.add(lblID, 0, 2);
        
        txfID = new TextField();
        pane.add(txfID, 0, 3);
        txfID.setPrefWidth(200);

        Button btnCancel = new Button("Cancel");
        pane.add(btnCancel, 0, 6);
        GridPane.setHalignment(btnCancel, HPos.LEFT);
        btnCancel.setOnAction(event -> this.cancelAction());

        Button btnOK = new Button("OK");
        pane.add(btnOK, 0, 7);
        GridPane.setHalignment(btnOK, HPos.RIGHT);
        btnOK.setOnAction(event -> this.okAction());

        lblError = new Label();
        pane.add(lblError, 0, 8);
        lblError.setStyle("-fx-text-fill: red");

        this.initControls();
    }

    private void initControls() {
        if (customer != null) {
            txfName.setText(customer.getName());
            
            
           
        } else {
            txfName.clear();
        }
    }

    // -------------------------------------------------------------------------

    private void cancelAction() {
        this.hide();
    }

    private void okAction() {
        String name = txfName.getText().trim();
        if (name.length() == 0) {
            lblError.setText("Name is empty");
            return;
        }
        
        int customerID = Integer.parseInt(txfID.getText());
        
        
        if(customerID < 0) {
        	lblError.setText("Do not use a negative number for ID");
        }
        
        
        // Call Service methods
        if (customer != null) {
            Service.updateCustomer(customer, name, customerID);
            System.out.println(customer.getName());
            System.out.println(companyAdd.getCustomers());
        }  else {
        	customer = Service.createCustomer(name, customerID);
        	Service.connectCustomerToCompany(customer, companyAdd);
        	System.out.println(customer.getName());
        	System.out.println(companyAdd.getName());
            System.out.println(companyAdd.getCustomers());
        }

        this.hide();
    }

    // -------------------------------------------------------------------------

    
}