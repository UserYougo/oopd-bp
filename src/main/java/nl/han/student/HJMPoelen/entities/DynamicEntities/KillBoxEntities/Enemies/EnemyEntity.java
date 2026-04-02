package nl.han.student.HJMPoelen.entities.DynamicEntities.KillBoxEntities.Enemies;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.scenes.SceneBorder;
import nl.han.student.HJMPoelen.entities.DynamicEntities.KillBoxEntities.DynamicDamageBox;
import nl.han.student.HJMPoelen.entities.StaticEntities.Platform.Platform;

import java.util.List;

public class EnemyEntity extends DynamicCompositeEntity implements Collider, Collided ,SceneBorderTouchingWatcher {
    private double width  = 30;
    private double height = 30;

    private Direction currentDirection = Direction.LEFT;

    public EnemyEntity(Coordinate2D initialPosition) {
        super(initialPosition);
        setMotion(3, Direction.LEFT);
        setAnchorPoint(AnchorPoint.BOTTOM_CENTER);
    }

    @Override
    protected void setupEntities() {
        //hitbox of the entity
        addEntity(new DynamicDamageBox(new Coordinate2D(0,0), new Size(width, height)));

        //Looks of the entity
        addEntity(new EnemyEntityAppearance(new Coordinate2D(0,0), new Size(width,height) ));

        //Text of entity, should be last to show / draw on top.
        addEntity(new EnemyEntityText(new Coordinate2D(width/2,height/2), "Enemy"));
    }

    @Override
    public void notifyBoundaryTouching(final SceneBorder border) {
        changeDirection(180);
        currentDirection = (currentDirection == Direction.LEFT) ? Direction.RIGHT : Direction.LEFT;
    }

    @Override
    public void onCollision(List<Collider> list) {
        for (Collider collider : list) {
            if (collider instanceof Platform platform) {
                double platformLeft  = platform.getAnchorLocation().getX();
                double platformRight = platformLeft + platform.getWidth();
                double enemyLeft  = getAnchorLocation().getX() - width / 2;
                double enemyRight = getAnchorLocation().getX() + width / 2;

                if (currentDirection == Direction.LEFT && enemyLeft <= platformLeft + 5) {
                    changeDirection(180);
                    currentDirection = Direction.RIGHT;
                } else if (currentDirection == Direction.RIGHT && enemyRight >= platformRight - 5) {
                    changeDirection(180);
                    currentDirection = Direction.LEFT;
                }
            }
        }
    }
}