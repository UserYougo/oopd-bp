package nl.han.student.HJMPoelen.entities.base.TestEntities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;
import javafx.scene.paint.Color;

public class TestPlatform extends DynamicRectangleEntity implements Collider {

    public TestPlatform(Coordinate2D position, Size size) {
        super(position, size);
        setFill(Color.GOLD);
    }
}