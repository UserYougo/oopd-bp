package nl.han.student.HJMPoelen.entities.StaticEntities.Items;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.paint.Color;
import nl.han.student.HJMPoelen.entities.StaticEntities.ScoreManager;

public class BadCoin extends Item{
        private final int value = 150;

        public BadCoin(Coordinate2D initialLocation){
            super(initialLocation);
            setRadius(10);
            setFill(Color.PALEGOLDENROD);
        }

        @Override
        public void onPickup() {
            ScoreManager.removePoints(value);
            remove();
        }
}
