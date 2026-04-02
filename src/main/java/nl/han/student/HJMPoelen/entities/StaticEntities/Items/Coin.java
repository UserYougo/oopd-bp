package nl.han.student.HJMPoelen.entities.StaticEntities.Items;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.paint.Color;
import nl.han.student.HJMPoelen.entities.StaticEntities.ScoreManager;

public class Coin extends Item {
    private final int value = 100;

    public Coin(Coordinate2D initialLocation){
        super(initialLocation);
        setRadius(10);
        setFill(Color.PALEGOLDENROD);
    }

    @Override
    public void onPickup() {
        ScoreManager.addPoints(value);
        remove();
    }
}
