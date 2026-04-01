package nl.han.student.HJMPoelen.entities.DynamicEntities.KillBoxEntities.Enemies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicEllipseEntity;
import javafx.scene.paint.Color;

public class GhostEntityAppearance extends DynamicEllipseEntity {
    protected GhostEntityAppearance(Coordinate2D initialLocation, Size size) {
        super(initialLocation, size);
        setFill(Color.WHITE);
        setOpacity(0.5);
    }
}