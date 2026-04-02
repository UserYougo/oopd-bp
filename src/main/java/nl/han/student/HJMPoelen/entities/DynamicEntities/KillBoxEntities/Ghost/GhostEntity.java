package nl.han.student.HJMPoelen.entities.DynamicEntities.KillBoxEntities.Ghost;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.scenes.SceneBorder;
import nl.han.student.HJMPoelen.HAN_Menace;
import nl.han.student.HJMPoelen.entities.DynamicEntities.KillBoxEntities.DynamicKillBox;
import nl.han.student.HJMPoelen.entities.DynamicEntities.KillBoxEntities.Enemies.EnemyEntityText;

import java.util.List;

public class GhostEntity extends DynamicCompositeEntity implements Collider, Collided, SceneBorderTouchingWatcher {

    private final double width  = 30;
    private final double height = 30;

    public GhostEntity(Coordinate2D initialPosition) {
        super(initialPosition);
        setMotion(2, Direction.DOWN_LEFT);
        setAnchorPoint(AnchorPoint.BOTTOM_CENTER);
    }

    @Override
    protected void setupEntities() {
        addEntity(new DynamicKillBox(new Coordinate2D(0, 0), new Size(width, height)));
        addEntity(new GhostEntityAppearance(new Coordinate2D(0, 0), new Size(width, height)));
        addEntity(new EnemyEntityText(new Coordinate2D(width/2,height/2), "Ghost"));
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