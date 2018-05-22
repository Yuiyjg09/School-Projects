package opgRadiobtn;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import opg1.Person;

public class RButtonSelector extends Application
{
   public static void main(String[] args)
   {
      Application.launch(args);
   }

   @Override
   public void start(Stage stage)
   {
      stage.setTitle("Radiobutton Demo");
      GridPane pane = new GridPane();
      this.initContent(pane);

      Scene scene = new Scene(pane);
      stage.setScene(scene);
      stage.show();
   }

   // -------------------------------------------------------------------------

   private TextField txfResult;
   private Label lblTxt;
   private ToggleGroup group;

   private ListView<Person> lvwPersons;

   private final Controller controller = new Controller();

   private void initContent(GridPane pane)
   {
      // show or hide grid lines
      pane.setGridLinesVisible(false);

      // set padding of the pane
      pane.setPadding(new Insets(20));
      // set horizontal gap between components
      pane.setHgap(10);
      // set vertical gap between components
      pane.setVgap(10);

      txfResult = new TextField();
      pane.add(txfResult, 1, 0, 2, 1);

      lvwPersons = new ListView<Person>();
      pane.add(lvwPersons, 1, 1, 2, 1);
      lvwPersons.setPrefWidth(200);
      lvwPersons.setPrefHeight(200);
      lvwPersons.getItems().setAll(controller.boys);

      ChangeListener<Person> listener = (ov, oldPerson,
            newPerson) -> this.controller.selectionChanged();
      ;
      lvwPersons.getSelectionModel().selectedItemProperty()
            .addListener(listener);

      lvwPersons.getSelectionModel().clearSelection();

      HBox box = new HBox();
      group = new ToggleGroup();
      String[] genders = { "Boy", "Girl" };
      Color[] color1 = { Color.RED, Color.BLUE };
      RadioButton rb;
      for (int i = 0; i < genders.length; i++)
      {
         rb = new RadioButton();
         rb.setToggleGroup(group);
         rb.setText(genders[i]);
         rb.setUserData(color1[i]);
         box.getChildren().add(rb);
      }
      pane.add(box, 0, 0, 4, 1);
      group.getToggles().get(0).setSelected(true);
      group.selectedToggleProperty()
            .addListener(event -> this.controller.toggleRadioButton());

      // add a label to the pane (at col=0, row=0)
      lblTxt = new Label("Radiobutton example");
      lblTxt.setTextFill(color1[0]);
      pane.add(lblTxt, 3, 1);

   }

   // -------------------------------------------------------------------------
   // RadioButtonsactions

   private class Controller
   {
      private ArrayList<Person> boys;
      private ArrayList<Person> girls;

      public Controller()
      {
         initPersons();
      }

      private void initPersons()
      {

         boys = new ArrayList<Person>();
         boys.add(new Person("Gert", "Pantelåner", true));
         boys.add(new Person("Henrik", "Mekaniker", false));
         boys.add(new Person("Dan", "Datamatiker", false));

         girls = new ArrayList<Person>();
         girls.add(new Person("Jane", "Model", false));
         girls.add(new Person("Gertrud", "Feminist", true));
         girls.add(new Person("Jytte", "Husmor", false));

      }

      public void selectionChanged()
      {
         txfResult.setText(
               lvwPersons.getSelectionModel().getSelectedItem().toString());
      }

      private void toggleRadioButton()
      {

         if (group.getSelectedToggle().getUserData().equals("Boy"))
         {
            for (Person b : boys)
            {
               lvwPersons.getItems().add(b);
            }

            for (Person g : girls)
            {
               lvwPersons.getItems().remove(g);
            }
         }
         else if (group.getSelectedToggle().getUserData().equals("Girl"))
         {
            for (Person g : girls)
            {
               lvwPersons.getItems().add(g);
            }

            for (Person b : boys)
            {
               lvwPersons.getItems().remove(b);
            }
         }
      }
   }

}
