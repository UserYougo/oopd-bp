package nl.han.student.HJMPoelen.entities.DynamicEntities.KillBoxEntities.Enemies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.scenes.SceneBorder;
import nl.han.student.HJMPoelen.entities.DynamicEntities.KillBoxEntities.AbstractEnemy;
import nl.han.student.HJMPoelen.entities.StaticEntities.Platform.Platform;

import java.util.List;

public class EnemyEntity extends AbstractEnemy {
    private Direction currentDirection = Direction.LEFT;

    public EnemyEntity(Coordinate2D initialPosition) {
        super(initialPosition);
        setMotion(3, Direction.LEFT);
    }

    @Override
    protected void setupAppearance() {
        addEntity(new EnemyEntityAppearance(new Coordinate2D(0, 0), new Size(width, height)));
        addEntity(new EnemyEntityText(new Coordinate2D(width / 2, height / 2), "Enemy"));
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