package example1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
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
      int pixelForrykning = 100;
      Color minFarve = Color.YELLOW;

      Circle circle = new Circle(pixelForrykning, 70, 30);
      pane.getChildren().add(circle);
      circle.setFill(minFarve);
      circle.setStroke(Color.BLACK);

      Rectangle minRektangel = new Rectangle(pixelForrykning, 140, 30, 80);
      pane.getChildren().add(minRektangel);
      minRektangel.setFill(minFarve);
      minRektangel.setStroke(Color.BROWN);

      Line minLinje = new Line(pixelForrykning, 140, 210, 210);
      pane.getChildren().add(minLinje);
      minLinje.setStroke(minFarve);

   }
}
