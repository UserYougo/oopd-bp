package nl.han.student.HJMPoelen.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import nl.han.student.HJMPoelen.HAN_Menace;
import nl.han.student.HJMPoelen.entities.StaticEntities.UI.HeaderText;
import nl.han.student.HJMPoelen.entities.StaticEntities.CoinPurse.ScoreManager;
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
    }

    @Override
    public void setupEntities() {
        int currentScore = ScoreManager.getScore();
        ArrayList<Integer> highscores = ScoreManager.getHighscores();

        var title = new HeaderText(new Coordinate2D(getWidth() / 2, getHeight() / 5), "You Win!");
        addEntity(title);

        var scoreText = new HeaderText(new Coordinate2D(getWidth() / 2, getHeight() / 3),
                "Your score: " + currentScore);
        addEntity(scoreText);

        StringBuilder hsText = new StringBuilder("Top 5 Highscores:\n");
        for (int i = 0; i < highscores.size(); i++) {
            hsText.append(i + 1).append(". ").append(highscores.get(i)).append("\n");
        }

        var hsEntity = new HeaderText(new Coordinate2D(getWidth() / 2, getHeight() / 2.2), hsText.toString());
        hsEntity.setFill(Color.DARKBLUE);
        addEntity(hsEntity);

        var restartButton = new Button(
                new Coordinate2D(getWidth() / 2, getHeight() / 1.3),
                hanMenace,
                "Play Again",
                HAN_Menace.GAMESCENE
        );
        addEntity(restartButton);

        var homeButton = new Button(
                new Coordinate2D(getWidth() / 2, getHeight() / 1.15),
                hanMenace,
                "Back to Home",
                HAN_Menace.TITELSCENE
        );
        addEntity(homeButton);
    }
}
