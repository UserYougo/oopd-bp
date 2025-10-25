package nl.han.student.HJMPoelen.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import nl.han.student.HJMPoelen.HAN_Menace;
import nl.han.student.HJMPoelen.entities.base.HeaderText;
import nl.han.student.HJMPoelen.entities.base.buttons.RestartButton;
import nl.han.student.HJMPoelen.entities.base.buttons.StartButton;

public class LostScene extends StaticScene {
    protected HAN_Menace hanMenace;

    public LostScene(HAN_Menace hanMenace) {
        this.hanMenace = hanMenace;
    }

    @Override
    public void setupScene() {
        setBackgroundColor(Color.LIGHTGRAY);
    }

    @Override
    public void setupEntities() {
        var titelText = new HeaderText(
                new Coordinate2D( getWidth()/2 , getHeight() / 3),
                "Dare to try again?"
        );
        addEntity(titelText);
        var restartButton = new RestartButton(
                new Coordinate2D(getWidth()/ 2, getHeight()/ 2),
                hanMenace
        );
        addEntity(restartButton);

    }
}
