package opg1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application
{

   public static void main(String[] args)
   {
      // TODO Auto-generated method stub
      Application.launch(args);
   }

   @Override
   public void start(Stage stage)
   {
      // TODO Auto-generated method stub
      stage.setTitle("Name Combiner");
      GridPane pane = new GridPane();
      this.initContent(pane);

      Scene scene = new Scene(pane);
      stage.setScene(scene);
      stage.show();

   }

   // -------------------------------------------------------------------------
   private TextField txfName;
   private TextField txfName2;
   private TextArea txAFullName;

   private void initContent(GridPane pane)
   {
      // enable this to show grid lines
      pane.setGridLinesVisible(false);

      // set padding of the pane
      pane.setPadding(new Insets(20));
      // set horizontal gap between components
      pane.setHgap(10);
      // set vertical gap between components
      pane.setVgap(10);

      // add a label to the pane (at col=0, row=0)
      Label lblName = new Label("First Name:");
      pane.add(lblName, 0, 0);

      Label lblName2 = new Label("Last Name:");
      pane.add(lblName2, 3, 0);

      Label yourName = new Label("Full Name:");
      pane.add(yourName, 0, 3);

      // add a text field to the pane (at col=1, row=0, extending 2 columns and
      // 1 row)
      txfName = new TextField();
      pane.add(txfName, 1, 0, 2, 1);
      txfName2 = new TextField();
      pane.add(txfName2, 4, 0, 2, 1);

      txAFullName = new TextArea();
      pane.add(txAFullName, 1, 3, 4, 1);

      Button btnCombi = new Button("Combine");
      pane.add(btnCombi, 1, 5);

      btnCombi.setOnAction(event -> {
         if (txfName.getText() != null && txfName2.getText() != null)
         {
            this.fillAction();
         }
      });
   }

   private void fillAction()
   {
      txAFullName.setText(txfName.getText() + " " + txfName2.getText());
   }

}
