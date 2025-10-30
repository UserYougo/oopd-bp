package nl.han.student.HJMPoelen.entities.StaticEntities.CoinPurse;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ScoreText extends TextEntity {

    public ScoreText(Coordinate2D location) {
        super(location, "Score: 0");
        setFill(Color.WHITE);
        setFont(Font.font(20));
    }

    public void refresh() {
        setText("Score: " + ScoreManager.getScore());
    }
}
