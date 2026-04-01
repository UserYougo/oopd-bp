package nl.han.student.HJMPoelen.entities.DynamicEntities.KillBoxEntities.Enemies;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.scenes.SceneBorder;
import nl.han.student.HJMPoelen.HAN_Menace;

import java.util.List;

public class GhostEntity extends DynamicCompositeEntity implements Collider, Collided, SceneBorderTouchingWatcher {

    private final HAN_Menace app;
    private final double width  = 30;
    private final double height = 30;

    public GhostEntity(Coordinate2D initialPosition, HAN_Menace app) {
        super(initialPosition);
        this.app = app;
        setMotion(2, Direction.DOWN_LEFT);
        setAnchorPoint(AnchorPoint.BOTTOM_CENTER);
    }

    @Override
    protected void setupEntities() {
        addEntity(new GhostEntityDamage(new Coordinate2D(0, 0), new Size(width, height), app));
        addEntity(new GhostEntityAppearance(new Coordinate2D(0, 0), new Size(width, height)));
        addEntity(new EnemyEntityText(new Coordinate2D(width/2,height/2), "Ghost"));
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border) {
        switch (border) {
            case LEFT -> addToMotion(2, Direction.RIGHT);
            case RIGHT -> addToMotion(2, Direction.LEFT);
            case TOP -> addToMotion(2, Direction.DOWN);
            case BOTTOM -> addToMotion(2, Direction.UP);
        }
    }

    @Override
    public void onCollision(List<Collider> list) {
        // Ghost floats freely, ignores platform edges
    }
}