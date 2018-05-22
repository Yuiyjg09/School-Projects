package opg3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
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
   private TextArea txaName;
   private int num = 0;

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

      txaName = new TextArea();
      txaName.setText(num + "");
      pane.add(txaName, 1, 0, 1, 1);

      Button btnUp = new Button("Up");
      pane.add(btnUp, 1, 5);

      Button btnDown = new Button("Down");
      pane.add(btnDown, 3, 5);

      btnUp.setOnAction(event -> {
         this.upAction();
      });

      btnDown.setOnAction(event -> {
         this.downAction();
      });

   }

   private void upAction()
   {
      num += 1;
      txaName.setText(num + "");
   }

   private void downAction()
   {
      num -= 1;
      txaName.setText(num + "");
   }

}