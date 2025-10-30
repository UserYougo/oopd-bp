package nl.han.student.HJMPoelen.entities.DynamicEntities.KillBoxEntities.Enemies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import javafx.scene.paint.Color;
import nl.han.student.HJMPoelen.entities.StaticEntities.Hitbox;

public class EnemyMovementBoundyHitbox extends Hitbox {
    //Hitbox to make the Enemy bounce on
    public EnemyMovementBoundyHitbox(Coordinate2D initialPosition, Size size) {
        super(initialPosition, size);
        this.setFill(Color.LIGHTGRAY);
        this.setOpacity(0.01);
    }
}
