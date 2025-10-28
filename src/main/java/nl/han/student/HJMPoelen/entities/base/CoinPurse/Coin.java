package nl.han.student.HJMPoelen.entities.base.CoinPurse;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.CircleEntity;
import javafx.scene.paint.Color;

import java.util.List;

public class Coin extends CircleEntity implements Collided {
    int value;
    static int score;

    public Coin(Coordinate2D initialLocation, int value) {
        super(initialLocation);
        this.value = value;
        setFill(Color.PALEGOLDENROD);

    }

    public void scoreCounter() {
        score += value;
    }

    @Override
    public void onCollision(List<Collider> list) {
        scoreCounter();
    }
}
