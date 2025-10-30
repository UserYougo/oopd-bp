package nl.han.student.HJMPoelen.entities.DynamicEntities.KillBoxEntities.Enemies;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;
import com.github.hanyaeger.api.entities.impl.DynamicTextEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import nl.han.student.HJMPoelen.HAN_Menace;
import nl.han.student.HJMPoelen.entities.StaticEntities.Hitbox;

import java.util.List;

public class EnemyEntity extends DynamicCompositeEntity implements Collider, Collided ,SceneBorderTouchingWatcher {
    private final HAN_Menace app;
    private double width  = 30;
    private double height = 30;

    private Direction currentDirection = Direction.LEFT;
    private double distanceMoved = 0;

    public EnemyEntity(Coordinate2D initialPosition, HAN_Menace app) {
        super(initialPosition);
        this.app = app;
        setMotion(3, Direction.LEFT);
        setAnchorPoint(AnchorPoint.BOTTOM_CENTER);
    }

    @Override
    protected void setupEntities() {
        EnemyEntityDamage enemyEntityDamage = new EnemyEntityDamage(new Coordinate2D(0,0), new Size(width, height), app);
        addEntity(enemyEntityDamage);

        EnemyEntityAppearance enemyEntityAppearance = new EnemyEntityAppearance(new Coordinate2D(0,0), new Size(width,height) );
        addEntity(enemyEntityAppearance);

        EnemyEntityText enemyEntityText = new EnemyEntityText(new Coordinate2D(width/2,height/2), "Enemy");
        addEntity(enemyEntityText);
    }

    @Override
    public void notifyBoundaryTouching(final SceneBorder border) {
        changeDirection(180); //change direction when hitting border of screen
    }


    @Override
    public void onCollision(List<Collider> list) {
        for (Collider collider : list) {
            if(collider instanceof EnemyMovementBoundyHitbox){
                changeDirection(180); //change direction when hitting the EnemyMovementBoundyHitbox
                /// Could probably be implemented better with collision check with the platform, and when not colliding anymore turn around?
            }
        }
    }
}
