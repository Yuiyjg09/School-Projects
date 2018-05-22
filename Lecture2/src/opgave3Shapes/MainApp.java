package opgave3Shapes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
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
      int minRadius = 10;
      Color minFarve = Color.BLACK;

      for (int i = 5; i >= 0; i--)
      {

         Circle skydeskive = new Circle(100, 100, i * minRadius);

         if (i % 2 == 0)
         {

            minFarve = Color.WHITE;

         }
         else
         {

            minFarve = Color.BLACK;

         }

         pane.getChildren().add(skydeskive);
         skydeskive.setFill(minFarve);

      }

   }
}
