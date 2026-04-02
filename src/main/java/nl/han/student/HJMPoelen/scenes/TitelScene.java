package nl.han.student.HJMPoelen.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import nl.han.student.HJMPoelen.HAN_Menace;
import nl.han.student.HJMPoelen.entities.StaticEntities.UI.HeaderText;
import nl.han.student.HJMPoelen.entities.StaticEntities.UI.buttons.Button;
import nl.han.student.HJMPoelen.entities.StaticEntities.UI.buttons.ExitButton;

public class TitelScene extends StaticScene {
    protected HAN_Menace hanMenace;

    public TitelScene(HAN_Menace hanMenace) {
        this.hanMenace = hanMenace;
    }

    @Override
    public void setupScene() {
        setBackgroundColor(Color.GRAY);
    }

    @Override
    public void setupEntities() {
        var titleText = new HeaderText(
                new Coordinate2D(getWidth() / 2, getHeight() / 3),
                "HAN_ Menace"
        );
        addEntity(titleText);

        var startButton = new Button(
                new Coordinate2D(getWidth() / 2, getHeight() / 2),
                hanMenace,
                "Start",
                HAN_Menace.GAMESCENE,
                HAN_Menace.HAN_COLOR,
                Color.WHITE
        );
        addEntity(startButton);

        var exitButton = new ExitButton(
                new Coordinate2D(getWidth() - 50, getHeight() - 30)
        );
        addEntity(exitButton);
    }
}