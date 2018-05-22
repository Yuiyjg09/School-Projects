package opg1;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application
{
   public static void main(String[] args)
   {
      Application.launch(args);
   }

   @Override
   public void start(Stage stage)
   {
      stage.setTitle("ListView Demo3");
      GridPane pane = new GridPane();
      this.initContent(pane);

      input = new PersonInputWindow("Add a person", stage);
      Scene scene = new Scene(pane);
      stage.setScene(scene);
      stage.show();
   }

   // -------------------------------------------------------------------------

   private TextField txfResult;
   private PersonInputWindow input;

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

      // add a listView to the pane(at col=1, row=0)
      lvwPersons = new ListView<Person>();
      pane.add(lvwPersons, 1, 1, 2, 1);
      lvwPersons.setPrefWidth(200);
      lvwPersons.setPrefHeight(200);
      lvwPersons.getItems().setAll(controller.persons);

      ChangeListener<Person> listener = (ov, oldPerson,
            newPerson) -> this.controller.selectionChanged();
      lvwPersons.getSelectionModel().selectedItemProperty()
            .addListener(listener);

      lvwPersons.getSelectionModel().clearSelection();

      Button btnDelete = new Button("Delete");
      pane.add(btnDelete, 6, 3);

      // connect a method to the button
      btnDelete.setOnAction(event -> this.controller.deleteAction());

      Button btnCreateMovie = new Button("Create movie");
      pane.add(btnCreateMovie, 1, 2);
      GridPane.setMargin(btnCreateMovie, new Insets(10, 10, 0, 10));

      // connect a method to the button
      btnCreateMovie.setOnAction(event -> this.controller.createMovieAction());

   }

   /**
    * This class controls access to the model in this application. In this case,
    * the model is a list of Person object.
    */
   private class Controller
   {
      private ArrayList<Person> persons;

      public Controller()
      {
         initPersons();
      }

      // -------------------------------------------------------------------------
      // Button actions

      public void selectionChanged()
      {
         txfResult.setText(
               lvwPersons.getSelectionModel().getSelectedItem().toString());
      }

      private void deleteAction()
      {
         int index = lvwPersons.getSelectionModel().getSelectedIndex();
         if (index >= 0)
         {
            persons.remove(index);
            lvwPersons.getItems().remove(index);

         }
      }

      private void initPersons()
      {
         persons = new ArrayList<Person>();
         persons.add(new Person("Gert", "Pantelåner", true));
         persons.add(new Person("Henrik", "Mekaniker", false));
         persons.add(new Person("Dan", "Datamatiker", false));

      }

      // -------------------------------------------------------------------------
      // Selectionchange actions

      private void createMovieAction()
      {
         input.showAndWait();
         if (input.getActualPerson() != null)
         {
            txfResult.setText(input.getActualPerson().toString());
            lvwPersons.getItems().add(input.getActualPerson());

         }

      }
   }
}