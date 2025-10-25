package nl.han.student.HJMPoelen.entities.base.KillBoxEntities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class EnemyEntity extends DynamicRectangleEntity implements SceneBorderTouchingWatcher {


    public EnemyEntity(Coordinate2D initialPosition, Size size) {
        super(initialPosition, size);
        setMotion(3, Direction.LEFT);
    }

    @Override
    public void notifyBoundaryTouching(final SceneBorder border) {
        setSpeed(1);

        switch (border) {
            case LEFT:
                setMotion(3, Direction.RIGHT);
                break;
            case RIGHT:
                setMotion(3, Direction.LEFT);
                break;
//            default:
//                break;
        }
    }
}
