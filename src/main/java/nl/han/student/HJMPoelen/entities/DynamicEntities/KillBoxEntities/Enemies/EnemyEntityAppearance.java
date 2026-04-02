package nl.han.student.HJMPoelen.entities.DynamicEntities.KillBoxEntities.Enemies;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicEllipseEntity;
import javafx.scene.paint.Color;
import nl.han.student.HJMPoelen.HAN_Menace;

public class EnemyEntityAppearance extends DynamicEllipseEntity {
    protected EnemyEntityAppearance(Coordinate2D initialLocation, Size size) {
        super(initialLocation, size);
        this.setFill(HAN_Menace.HAN_COLOR);
    }
}