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

public class CarCrashPane extends Pane {
    private AnimationTimer timer;

    private ArrayList<Node> carList = new ArrayList<>();
    private Node people;
    
public CarCrashPane(){
    people = initPeople();
    this.getChildren().add(people);

    timer = new AnimationTimer() {
    @Override
      public void handle(long now) {
       for (Node car : carList)
            car.setTranslateX(car.getTranslateX() + Math.random() * 10);

        if (Math.random() < 0.075) {
            carList.add(initCar());
        }
        
       for (Node car : carList) {
            if (car.getBoundsInParent().intersects(people.getBoundsInParent())) {
                people.setTranslateX(0);
                car.setTranslateY(600 - 39);
                return;
            }
        }

        if (people.getTranslateY() <= 0) {
            timer.stop();
            String win = "YOU WIN";

            HBox hBox = new HBox();
            hBox.setTranslateX(300);
            hBox.setTranslateY(250);
            this.getChildren().add(hBox);

            for (int i = 0; i < win.toCharArray().length; i++) {
                char letter = win.charAt(i);

                Text text = new Text(String.valueOf(letter));
                text.setFont(Font.font(48));
                text.setOpacity(0);

                hBox.getChildren().add(text);

                FadeTransition ft = new FadeTransition(Duration.seconds(0.66), text);
                ft.setToValue(1);
                ft.setDelay(Duration.seconds(i * 0.15));
                ft.play();
            }
        }
            }
        };
        timer.start();
}

   private Node initPeople() {
     Rectangle rect = new Rectangle(38, 38, Color.GREEN);
     rect.setTranslateY(600 - 39);

     return rect;
    }

   private Node initCar() {
      Rectangle rect = new Rectangle(40, 40, Color.RED);
      rect.setTranslateY((int)(Math.random() * 14) * 40);

      this.getChildren().add(rect);
      return rect;
    }

}