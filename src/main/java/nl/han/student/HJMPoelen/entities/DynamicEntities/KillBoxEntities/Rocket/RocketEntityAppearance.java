package nl.han.student.HJMPoelen.entities.DynamicEntities.KillBoxEntities.Rocket;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;
import static javafx.scene.paint.Color.YELLOW;

public class RocketEntityAppearance extends DynamicRectangleEntity{

    protected RocketEntityAppearance(Coordinate2D initialPosition, Size size) {
        super(initialPosition, size);
        setFill(YELLOW);
    }
}

