package opgave4Shapes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
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
      Pane root = this.initContent();
      Scene scene = new Scene(root);

      stage.setTitle("Shapes");
      stage.setScene(scene);
      stage.show();
   }

   private Pane initContent()
   {
      Pane pane = new Pane();
      pane.setPrefSize(400, 400);
      this.drawShapes(pane);
      return pane;
   }

   // ------------------------------------------------------------------------

   private void drawShapes(Pane pane)
   {
      // Definerer position og farve
      int pixelForrykning = 100;
      Color minFarve = Color.BEIGE;

      // Tegner hoved
      Circle hoved = new Circle(pixelForrykning, pixelForrykning, 100);
      pane.getChildren().add(hoved);
      hoved.setFill(minFarve);
      hoved.setStroke(Color.BLACK);

      // Tegner mund
      Line minLinje = new Line(70, 140, 140, 140);
      pane.getChildren().add(minLinje);

      // Tegner venstre øje
      Circle minEneCirkel = new Circle(pixelForrykning - 25,
            pixelForrykning - 25, 10);
      pane.getChildren().add(minEneCirkel);
      minEneCirkel.setFill(Color.BLACK);
      minEneCirkel.setStroke(Color.BLACK);

      // Tegner højre øje
      Circle minAndenCirkel = new Circle(pixelForrykning + 25,
            pixelForrykning - 25, 10);
      pane.getChildren().add(minAndenCirkel);
      minAndenCirkel.setFill(Color.BLACK);
      minAndenCirkel.setStroke(Color.BLACK);

      // Tegner teksten: "Make America Great Again!"
      Text usa = new Text(100, 250, "MAKE AMERICA GREAT AGAIN!");
      pane.getChildren().add(usa);
      usa.setScaleX(1.8);
      usa.setFill(Color.RED);

      // Tegner hår
      Arc haar = new Arc(100, 150, 175, 150, 60, 75);
      pane.getChildren().add(haar);
      haar.setFill(Color.YELLOW);

   }
}
