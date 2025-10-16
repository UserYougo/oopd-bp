package nl.han.student.HJMPoelen.entities.base.buttons;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;

public class BaseButtonBox extends RectangleEntity {
    public BaseButtonBox(Coordinate2D initialPosition, final Size size, Color  backgroundColor) {
        super(initialPosition);
        setWidth(size.width());
        setHeight(size.height());
        setFill(backgroundColor);
        setStrokeWidth(0);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }
}
