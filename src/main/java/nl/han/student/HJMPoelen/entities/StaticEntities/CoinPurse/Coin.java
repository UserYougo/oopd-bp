package nl.han.student.HJMPoelen.entities.StaticEntities.CoinPurse;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.CircleEntity;
import javafx.scene.paint.Color;
import nl.han.student.HJMPoelen.entities.DynamicEntities.PlayerEntity.Player;

import java.util.List;

public class Coin extends CircleEntity implements Collided {
    private final int value;

    public Coin(Coordinate2D initialLocation, int value) {
        super(initialLocation);
        this.value = value;
        setRadius(10);
        setFill(Color.PALEGOLDENROD);
    }

    private void addToScore() {
        ScoreManager.addPoints(value);
    }

    @Override
    public void onCollision(List<Collider> colliders) {
        for (Collider collider : colliders) {
            if (collider instanceof Player) {
                addToScore();
                remove();
                break;
            }
        }
    }
}