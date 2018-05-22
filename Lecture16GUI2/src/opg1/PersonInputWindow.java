package opg1;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PersonInputWindow extends Stage
{
   public PersonInputWindow(String title, Stage owner)
   {
      this.initOwner(owner);
      this.initStyle(StageStyle.UTILITY);
      this.initModality(Modality.APPLICATION_MODAL);
      this.setMinHeight(100);
      this.setMinWidth(200);
      this.setResizable(false);

      this.setTitle(title);
      GridPane pane = new GridPane();
      this.initContent(pane);

      Scene scene = new Scene(pane);
      this.setScene(scene);
   }

   // -------------------------------------------------------------------------
   private TextField txfTitle;
   private TextField txfActor;
   private CheckBox chksenior;

   private Person actualMovie = null;

   private void initContent(GridPane pane)
   {
      // pane.setGridLinesVisible(true);
      pane.setPadding(new Insets(20));
      pane.setHgap(10);
      pane.setVgap(10);

      Label lblTitle = new Label("Name:");
      pane.add(lblTitle, 0, 0);

      Label lblActor = new Label("Title:");
      pane.add(lblActor, 0, 1);

      Label lblSenior = new Label("Senior:");
      pane.add(lblSenior, 0, 2);

      txfTitle = new TextField();
      pane.add(txfTitle, 1, 0, 2, 1);

      txfActor = new TextField();
      pane.add(txfActor, 1, 1, 2, 1);

      chksenior = new CheckBox("Senior");
      pane.add(chksenior, 1, 2, 2, 1);

      HBox buttonBox = new HBox(20);
      pane.add(buttonBox, 0, 3);
      buttonBox.setPadding(new Insets(10, 10, 0, 10));
      buttonBox.setAlignment(Pos.TOP_RIGHT);

      Button btnCancel = new Button("Cancel");
      buttonBox.getChildren().add(btnCancel);
      btnCancel.setOnAction(event -> this.cancelAction());

      Button btnOK = new Button("OK");
      buttonBox.getChildren().add(btnOK);
      btnOK.setOnAction(event -> this.okAction());
   }

   // -------------------------------------------------------------------------

   // -------------------------------------------------------------------------
   // Button actions

   private void cancelAction()
   {
      txfTitle.clear();
      txfTitle.requestFocus();
      txfActor.clear();
      actualMovie = null;
      this.hide();
   }

   private void okAction()
   {
      String title = txfTitle.getText().trim();
      String actor = txfActor.getText().trim();
      boolean senior = chksenior.isSelected();

      if (title.length() > 0 && actor.length() > 0)
      {
         actualMovie = new Person(title, actor, senior);
         txfTitle.requestFocus();
         this.hide();

      }
      else if (title.length() <= 0 && actor.length() > 0)
      {
         Alert fejl = new Alert(AlertType.INFORMATION);
         fejl.setHeaderText("No named typed");
         fejl.setContentText("Type the name of the person");
         fejl.show();
      }
      else if (title.length() > 0 && actor.length() <= 0)
      {
         Alert fejl = new Alert(AlertType.INFORMATION);
         fejl.setHeaderText("No title typed");
         fejl.setContentText("Type the title of the person");
         fejl.show();
      }
      else if (title.length() <= 0 && actor.length() <= 0)
      {
         Alert fejl = new Alert(AlertType.INFORMATION);
         fejl.setHeaderText("No named & title typed");
         fejl.setContentText("Type the name and the title of the person");
         fejl.show();
      }

   }

   public Person getActualPerson()
   {
      return actualMovie;
   }

   public void clearActualMovie()
   {
      actualMovie = null;
   }

}
