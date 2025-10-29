package nl.han.student.HJMPoelen.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import nl.han.student.HJMPoelen.HAN_Menace;
import nl.han.student.HJMPoelen.entities.base.HeaderText;
import nl.han.student.HJMPoelen.entities.base.ScoreManager;
import nl.han.student.HJMPoelen.entities.base.buttons.BackHomeButton;
import nl.han.student.HJMPoelen.entities.base.buttons.RestartButton;

import java.util.ArrayList;

public class LostScene extends StaticScene {
    protected HAN_Menace hanMenace;

    public LostScene(HAN_Menace hanMenace) {
        this.hanMenace = hanMenace;
    }

    @Override
    public void setupScene() {
        setBackgroundColor(Color.LIGHTGRAY);
        ScoreManager.saveHighscore();
    }

    @Override
    public void setupEntities() {
        int currentScore = ScoreManager.getScore();
        ArrayList<Integer> topScores = ScoreManager.getHighscores();

        var titleText = new HeaderText(
                new Coordinate2D(getWidth() / 2, getHeight() / 4),
                "Dare to try again?"
        );
        addEntity(titleText);

        var scoreText = new HeaderText(
                new Coordinate2D(getWidth() / 2, getHeight() / 3),
                "Your score: " + currentScore
        );
        addEntity(scoreText);

        StringBuilder highscoreTextBuilder = new StringBuilder("Top 5 Highscores:\n");
        for (int i = 0; i < topScores.size(); i++) {
            highscoreTextBuilder.append(i + 1).append(". ").append(topScores.get(i)).append("\n");
        }

        var highscoreText = new HeaderText( // moet nog kijken of het anders dan headertext kan, was voor nu een snelle oplossing
                new Coordinate2D(getWidth() / 2, getHeight() / 3),
                highscoreTextBuilder.toString()
        );
        highscoreText.setFill(Color.MEDIUMVIOLETRED); //willekeurige kleur
        addEntity(highscoreText);

        var restartButton = new RestartButton(
                new Coordinate2D(getWidth() / 2, getHeight()/ 0.5), hanMenace); // button plekken moet nog ff overna gedacht worden
        addEntity(restartButton);

        var backHomeButton = new BackHomeButton(new Coordinate2D( getWidth()/ 2, getHeight()/ 0.5), hanMenace);
        addEntity(backHomeButton);
    }
}
