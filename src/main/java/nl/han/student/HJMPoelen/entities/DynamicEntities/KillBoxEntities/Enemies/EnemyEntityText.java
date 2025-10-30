package nl.han.student.HJMPoelen.entities.DynamicEntities.KillBoxEntities.Enemies;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicTextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class EnemyEntityText extends DynamicTextEntity {
    protected EnemyEntityText(Coordinate2D initialPosition, String text) {
        super(initialPosition, text);
        setFill(Color.WHITE);
        setFont(Font.font("Roboto", FontWeight.BOLD, 8));
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }
}
