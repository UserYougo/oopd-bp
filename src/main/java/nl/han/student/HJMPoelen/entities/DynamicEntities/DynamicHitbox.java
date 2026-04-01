package nl.han.student.HJMPoelen.entities.DynamicEntities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;
import javafx.scene.paint.Color;

public class DynamicHitbox extends DynamicRectangleEntity implements Collider {
    protected DynamicHitbox(Coordinate2D initialPosition, Size size) {
        super(initialPosition, size);
        this.setFill(Color.ORANGE);
    }
    protected void setHitBoxWidth(double width) {
        this.setWidth(width);
    }
    protected void setHitBoxHeight(double height) {
        this.setHeight(height);
    }


}
