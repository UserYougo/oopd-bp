package nl.han.student.HJMPoelen.entities.DynamicEntities.KillBoxEntities.Ghost;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.scenes.SceneBorder;
import nl.han.student.HJMPoelen.entities.DynamicEntities.KillBoxEntities.AbstractEnemy;
import nl.han.student.HJMPoelen.entities.DynamicEntities.KillBoxEntities.Enemies.EnemyEntityText;

import java.util.List;

public class GhostEntity extends AbstractEnemy {

    public GhostEntity(Coordinate2D initialPosition) {
        super(initialPosition);
        setMotion(2, Direction.DOWN_LEFT);
    }

    @Override
    protected void setupAppearance() {
        addEntity(new GhostEntityAppearance(new Coordinate2D(0, 0), new Size(width, height)));
        addEntity(new EnemyEntityText(new Coordinate2D(width / 2, height / 2), "Ghost"));
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border) {
        switch (border) {
            case LEFT, RIGHT -> setMotion(getSpeed(), (360 - getDirection()) % 360);
            case TOP, BOTTOM -> setMotion(getSpeed(), (540 - getDirection()) % 360);
        }
    }

    @Override
    public void onCollision(List<Collider> list) {
        // Ghost floats freely, ignores platforms
    }
}