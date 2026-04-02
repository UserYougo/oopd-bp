package nl.han.student.HJMPoelen.entities.StaticEntities.Platform;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import javafx.scene.paint.Color;
import nl.han.student.HJMPoelen.entities.StaticEntities.Hitbox;

public class Platform extends Hitbox {

    public Platform(Coordinate2D initialPosition, Size size) {
        super(initialPosition, size);
        setFill(Color.BLACK);
        setStrokeColor(Color.BLACK);
    }
}
