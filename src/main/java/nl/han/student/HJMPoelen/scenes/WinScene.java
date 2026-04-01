package nl.han.student.HJMPoelen.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import nl.han.student.HJMPoelen.HAN_Menace;
import nl.han.student.HJMPoelen.entities.StaticEntities.CoinPurse.ScoreManager;
import nl.han.student.HJMPoelen.entities.StaticEntities.UI.HeaderText;
import nl.han.student.HJMPoelen.entities.StaticEntities.UI.buttons.Button;

import java.util.ArrayList;

public class WinScene extends StaticScene {
    private final HAN_Menace hanMenace;

    public WinScene(HAN_Menace hanMenace) {
        this.hanMenace = hanMenace;
    }

    @Override
    public void setupScene() {
        setBackgroundColor(Color.LIGHTGREEN);
        ScoreManager.saveHighscore();
    }

    @Override
    public void setupEntities() {
        var title = new HeaderText(
                new Coordinate2D(getWidth() * 0.42, getHeight() * 0.15),
                "You Win!"
        );
        addEntity(title);

        var currentScoreText = new TextEntity(
                new Coordinate2D(getWidth() * 0.3, getHeight() * 0.25),
                "Score: " + ScoreManager.getScore()
        );
        currentScoreText.setFill(Color.BLACK);
        addEntity(currentScoreText);

        ArrayList<Integer> highscores = ScoreManager.getHighscores();
        double startY = getHeight() * 0.35;
        double spacing = getHeight() * 0.05;

        for (int i = 0; i < highscores.size(); i++) {
            var text = new TextEntity(
                    new Coordinate2D(getWidth() * 0.3, startY + i * spacing),
                    (i + 1) + ". " + highscores.get(i)
            );
            text.setFill(Color.BLACK);
            addEntity(text);
        }

        var restartButton = new Button(
                new Coordinate2D(getWidth() * 0.45, getHeight() * 0.75),
                hanMenace,
                "restart?",
                1
        );
        addEntity(restartButton);

        var backButton = new Button(
                new Coordinate2D(getWidth() * 0.45, getHeight() * 0.85),
                hanMenace,
                "Home",
                0
        );
        addEntity(backButton);
    }
}
