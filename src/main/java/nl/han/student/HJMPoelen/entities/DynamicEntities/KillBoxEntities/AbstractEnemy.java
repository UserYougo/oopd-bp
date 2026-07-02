package nl.han.student.HJMPoelen.entities.DynamicEntities.KillBoxEntities;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;

public abstract class AbstractEnemy extends DynamicCompositeEntity
        implements Collider, Collided, SceneBorderTouchingWatcher {

    protected final double width;
    protected final double height;

    protected AbstractEnemy(Coordinate2D initialPosition) {
        this(initialPosition, 30, 30);
    }

    protected AbstractEnemy(Coordinate2D initialPosition, double width, double height) {
        super(initialPosition);
        this.width = width;
        this.height = height;
        setAnchorPoint(AnchorPoint.BOTTOM_CENTER);
    }

    @Override
    protected void setupEntities() {
        addEntity(new DynamicDamageBox(new Coordinate2D(0, 0), new Size(width, height)));
        setupAppearance();
    }

    protected abstract void setupAppearance();
}