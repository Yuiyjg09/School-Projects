package student;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class StudentApp extends Application
{

   public static void main(String[] args)
   {
      Application.launch(args);
   }

   @Override
   public void start(Stage stage)
   {
      stage.setTitle("Student Administration");
      GridPane pane = new GridPane();
      this.initContent(pane);

      Scene scene = new Scene(pane);
      stage.setScene(scene);
      stage.show();
   }

   // -------------------------------------------------------------------------

   private TextField txfName;
   private TextField txfAge;
   private TextField txfCpr;
   private CheckBox chkActive;
   private TextArea txAInf;

   private Button btnAdd;
   private Button btnSave;
   private Button btnGet;
   private Button btnDelete;
   private Button btnIncAge;

   private Controller controller = new Controller();

   private void initContent(GridPane pane)
   {
      // show or hide grid lines
      pane.setGridLinesVisible(false);
      // set padding of the pane
      pane.setPadding(new Insets(25));
      // set horizontal gap between components
      pane.setHgap(10);
      // set vertical gap between components
      pane.setVgap(10);

      txAInf = new TextArea();
      txAInf.setEditable(false);
      txAInf.setPrefWidth(230);
      txAInf.setPrefHeight(60);
      pane.add(txAInf, 0, 0, 5, 1);

      Label lblName = new Label("Navn");
      pane.add(lblName, 0, 1);
      Label lblAge = new Label("Alder");
      pane.add(lblAge, 0, 2);
      Label lblCpr = new Label("CPR.NR");
      pane.add(lblCpr, 0, 3);
      Label lblActive = new Label("Aktiv");
      pane.add(lblActive, 0, 4);

      txfName = new TextField();
      pane.add(txfName, 1, 1, 4, 1);
      txfAge = new TextField();
      pane.add(txfAge, 1, 2, 4, 1);
      txfCpr = new TextField();
      pane.add(txfCpr, 1, 3, 4, 1);

      chkActive = new CheckBox();
      pane.add(chkActive, 1, 4);

      // add a buttons to the pane
      btnAdd = new Button("Create");
      pane.add(btnAdd, 0, 5);
      btnSave = new Button("Save");
      btnSave.setDisable(true);
      pane.add(btnSave, 1, 5);
      btnGet = new Button("Load");
      btnGet.setDisable(true);
      pane.add(btnGet, 2, 5);
      btnDelete = new Button("Delete");
      pane.add(btnDelete, 3, 5);
      btnDelete.setDisable(true);
      btnIncAge = new Button("Birthday");
      pane.add(btnIncAge, 0, 6);

      // connect a method to the button
      btnAdd.setOnAction(event -> this.controller.addAction());
      btnSave.setOnAction(event -> this.controller.saveAction());
      btnGet.setOnAction(event -> this.controller.getAction());
      btnDelete.setOnAction(event -> this.controller.deleteAction());
      btnIncAge.setOnAction(event -> this.controller.birthday());

   }

   /**
    * This class controls access to the model in this application. In this case,
    * the model is a single Student object.
    */
   private class Controller
   {

      private Student temp = null;
      private ArrayList<Student> students = new ArrayList<>();

      private void addAction()
      {
         temp = new Student(txfName.getText().trim(),
               Integer.parseInt(txfAge.getText()), txfCpr.getText(),
               chkActive.isSelected());

         students.add(temp);
         clearFields();
         txAInf.setText(getDescription());
         btnGet.setDisable(false);

         btnIncAge.setDisable(true);

      }

      private void saveAction()
      {
         if (temp != null)
         {
            temp.setAge(Integer.parseInt(txfAge.getText()));
            temp.setName(txfName.getText());
            temp.setCprNr(txfCpr.getText());
            clearFields();
            txAInf.setText(getDescription());
            btnSave.setDisable(true);
            btnDelete.setDisable(true);
            btnGet.setDisable(false);
            btnIncAge.setDisable(true);
         }
      }

      private void getAction()
      {
         for (Student s : students)
         {
            if (s.getCprNr().equals(txfCpr.getText()))
            {
               temp = s;
            }
            txfName.setText(temp.getName());
            txfAge.setText(temp.getAge() + "");
            txfCpr.setText(temp.getCprNr());
            chkActive.setSelected(temp.isActive());
            txAInf.setText(getDescription());
            btnSave.setDisable(false);
            btnDelete.setDisable(false);
            btnGet.setDisable(true);
            btnIncAge.setDisable(false);
         }

      }

      private void deleteAction()
      {

         if (temp.getCprNr().equals(txfCpr.getText()))
         {
            students.remove(temp);
            clearFields();
            txAInf.clear();
            btnDelete.setDisable(true);
            btnSave.setDisable(true);
            btnIncAge.setDisable(true);
            btnGet.setDisable(true);
            btnAdd.setDisable(false);
         }
      }

      private void clearFields()
      {
         txfName.clear();
         txfAge.clear();
         txfCpr.clear();
         chkActive.setSelected(false);
      }

      private String getDescription()
      {
         String result = "Ingen studerende gemt";
         if (temp != null)
         {
            result = "";
            for (Student s : students)
            {
               result += "\n" + s.toString();
            }
         }
         return result;
      }

      private void birthday()
      {
         if (temp != null)
         {
            int plusEn = Integer.parseInt(txfAge.getText()) + 1;
            temp.setAge(temp.getAge() + 1);
            txfAge.setText(plusEn + "");
         }
      }
   }
}
