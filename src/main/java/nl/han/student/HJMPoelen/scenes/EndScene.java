package nl.han.student.HJMPoelen.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import nl.han.student.HJMPoelen.HAN_Menace;
import nl.han.student.HJMPoelen.entities.StaticEntities.ScoreManager;
import nl.han.student.HJMPoelen.entities.StaticEntities.UI.HeaderText;
import nl.han.student.HJMPoelen.entities.StaticEntities.UI.buttons.Button;
import nl.han.student.HJMPoelen.entities.StaticEntities.UI.buttons.ExitButton;
/// Endscreen we can reuse for win or lose

public abstract class EndScene extends StaticScene {
    protected final HAN_Menace hanMenace;

    public EndScene(HAN_Menace hanMenace) {
        this.hanMenace = hanMenace;
    }

    protected abstract String getTitle();

    @Override
    public void setupScene() {
        setBackgroundColor(Color.LIGHTGRAY);
        ScoreManager.saveHighscore();
    }

    @Override
    public void setupEntities() {
        addEntity(new HeaderText(new Coordinate2D(getWidth() / 2, getHeight() * 0.15), getTitle()));

        var currentScoreText = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() * 0.30),
                "Score:    " + ScoreManager.getScore() + " EC"
        );
        currentScoreText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        currentScoreText.setFill(Color.BLACK);
        addEntity(currentScoreText);

        var highscoresHeader = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() * 0.38),
                "Top Scores:"
        );
        highscoresHeader.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        highscoresHeader.setFill(Color.BLACK);
        addEntity(highscoresHeader);

        var highscores = ScoreManager.getHighscores();
        for (int i = 0; i < highscores.size(); i++) {
            var row = new TextEntity(
                    new Coordinate2D(getWidth() / 2, getHeight() * (0.43 + i * 0.035)),
                    (i + 1) + ":  " + highscores.get(i) + " EC"
            );
            row.setAnchorPoint(AnchorPoint.CENTER_CENTER);
            row.setFill(Color.BLACK);
            addEntity(row);
        }

        addEntity(new Button(
                new Coordinate2D(getWidth() * 0.3, getHeight() * 0.65),
                hanMenace, "Retry", HAN_Menace.GAMESCENE,
                HAN_Menace.HAN_COLOR,
                Color.WHITE
        ));

        addEntity(new ExitButton(new Coordinate2D(getWidth() * 0.6, getHeight() * 0.65)));

        var branding = new HeaderText(new Coordinate2D(getWidth() / 2, getHeight() * 0.85), "HAN_ Menace");
        addEntity(branding);
    }
}