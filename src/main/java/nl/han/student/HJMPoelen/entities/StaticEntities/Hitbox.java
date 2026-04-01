package nl.han.student.HJMPoelen.entities.StaticEntities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;

public class Hitbox extends RectangleEntity implements Collider {
    public Hitbox(Coordinate2D initialPosition, Size size) {
        super(initialPosition, size);
        this.setFill(Color.RED);
    }

    protected void setHitBoxWidth(double width) {
        this.setWidth(width);
    }
    protected void setHitBoxHeight(double height) {
        this.setHeight(height);
    }
}
