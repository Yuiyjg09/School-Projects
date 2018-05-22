package opgave2Shapes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
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
      int pixelForrykning = 100;
      Color minFarve = Color.YELLOW;

      Rectangle minRektangel = new Rectangle(pixelForrykning, 140, 100, 50);
      pane.getChildren().add(minRektangel);
      minRektangel.setFill(minFarve);
      minRektangel.setStroke(Color.BROWN);

      Text mitNavn = new Text(pixelForrykning + 25, 170, "TOMAS");
      pane.getChildren().add(mitNavn);
      mitNavn.setStyle("-fx-font: 20 arialbold");

   }
}
