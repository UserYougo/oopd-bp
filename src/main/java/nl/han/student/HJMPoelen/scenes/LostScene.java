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

public class LostScene extends StaticScene {
    private final HAN_Menace hanMenace;

    public LostScene(HAN_Menace hanMenace) {
        this.hanMenace = hanMenace;
    }

    @Override
    public void setupScene() {
        setBackgroundColor(Color.LIGHTGRAY);  // was LIGHTGREEN
        ScoreManager.saveHighscore();
    }

    @Override
    public void setupEntities() {
        var title = new HeaderText(
                new Coordinate2D(getWidth() / 2, getHeight() * 0.15),
                "DEAD!"
        );
        addEntity(title);

        var currentScoreText = new TextEntity(
                new Coordinate2D(getWidth() * 0.35, getHeight() * 0.38),
                "Score:    " + ScoreManager.getScore() + " EC"
        );
        currentScoreText.setFill(Color.BLACK);
        addEntity(currentScoreText);

        // Side-by-side buttons (same Y, different X)
        var restartButton = new Button(
                new Coordinate2D(getWidth() * 0.3, getHeight() * 0.65),
                hanMenace,
                "Restart",
                1
        );
        addEntity(restartButton);

        var exitButton = new Button(
                new Coordinate2D(getWidth() * 0.6, getHeight() * 0.65),
                hanMenace,
                "Exit",
                0
        );
        addEntity(exitButton);

        // Branding at bottom
        var branding = new HeaderText(
                new Coordinate2D(getWidth() / 2, getHeight() * 0.85),
                "HAN_ Menace"
        );
        branding.setFill(Color.web("#E8005A"));  // pink/magenta from screenshot
        addEntity(branding);
    }
}
