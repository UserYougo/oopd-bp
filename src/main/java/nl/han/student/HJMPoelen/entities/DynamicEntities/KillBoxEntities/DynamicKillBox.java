package nl.han.student.HJMPoelen.entities.DynamicEntities.KillBoxEntities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import javafx.scene.paint.Color;
import nl.han.student.HJMPoelen.entities.DynamicEntities.DynamicHitbox;
import nl.han.student.HJMPoelen.entities.DynamicEntities.PlayerEntity.Player;

import java.util.List;

/// Dynamic hitbox to kill / damage if player collids with it game gets set to Endscreen.
public class DynamicKillBox extends DynamicHitbox implements Collided {
    protected DynamicKillBox(Coordinate2D initialPosition, Size size) {
        super(initialPosition, size);
        setFill(Color.ORANGE);
        setOpacity(0.01);
    }

    @Override
    public void onCollision(List<Collider> list) {
        for (Collider collider : list) {
            if (collider instanceof Player player) {
                player.loseLife();
            }
        }
    }
}
