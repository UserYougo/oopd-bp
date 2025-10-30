package nl.han.student.HJMPoelen.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import nl.han.student.HJMPoelen.HAN_Menace;
import nl.han.student.HJMPoelen.entities.StaticEntities.UI.HeaderText;

import nl.han.student.HJMPoelen.entities.StaticEntities.UI.buttons.Button;
import nl.han.student.HJMPoelen.entities.StaticEntities.UI.buttons.StartButton;

public class TitelScene extends StaticScene {
     protected HAN_Menace hanMenace;

    public TitelScene(HAN_Menace hanMenace) {
        this.hanMenace = hanMenace;
    }

    @Override
    public void setupScene() {
        setBackgroundColor(Color.BEIGE);
    }

    @Override
    public void setupEntities() {
        var titelText = new HeaderText(
                new Coordinate2D( getWidth()/2 , getHeight() / 3),
                "Welcome to HAN_Menace!"
        );
        addEntity(titelText);
        var startButton = new Button(
                new Coordinate2D(getWidth()/ 2, getHeight()/ 2),
                hanMenace,
                "start",
                1
        );
        addEntity(startButton);

    }
}
