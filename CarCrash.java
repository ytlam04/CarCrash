import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.lang.*;

import java.util.ArrayList;
import java.util.List;

public class CarCrash extends Application {
   @Override
    public void start(Stage stage) throws Exception {
     Pane carCrashPane = new CarCrashPane();
     carCrashPane.setPrefSize(800, 600);
     
     carCrashPane.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.UP){
                carCrashPane.lookup("#people").setTranslateY(carCrashPane.lookup("#people").getTranslateY() - 40);}
            else if (event.getCode() == KeyCode.DOWN)
                carCrashPane.lookup("#people").setTranslateY(carCrashPane.lookup("#people").getTranslateY() + 40);
            else if (event.getCode() == KeyCode.LEFT)
                carCrashPane.lookup("#people").setTranslateX(carCrashPane.lookup("#people").getTranslateX() - 40);
            else if (event.getCode() == KeyCode.RIGHT)
                carCrashPane.lookup("#people").setTranslateX(carCrashPane.lookup("#people").getTranslateX() + 40);

        });
     Scene scene = new Scene(carCrashPane, 250, 150);
     stage.setScene(scene);
     stage.show();
     }  
public static void main(String[] args) {
    launch(args);
  }
}