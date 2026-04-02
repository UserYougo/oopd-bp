package nl.han.student.HJMPoelen.entities.DynamicEntities.UI;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicTextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ScoreDisplay extends DynamicTextEntity {
    public ScoreDisplay(Coordinate2D initialLocation, int score) {
        super(initialLocation);
        setAnchorPoint(AnchorPoint.TOP_LEFT);
        setFill(Color.WHITE);
        setFont(Font.font("Roboto", FontWeight.BOLD, 20));
        updateScore(score);
    }

    public void updateScore(int score) {
        setText("Score: " + score);
    }
}