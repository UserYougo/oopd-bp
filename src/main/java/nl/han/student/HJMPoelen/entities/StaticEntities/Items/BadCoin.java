package nl.han.student.HJMPoelen.entities.StaticEntities.Items;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.paint.Color;
import nl.han.student.HJMPoelen.entities.DynamicEntities.PlayerEntity.Player;
import nl.han.student.HJMPoelen.entities.StaticEntities.ScoreManager;

public class BadCoin extends Item{
        private final int value = 150;

        public BadCoin(Coordinate2D initialLocation){
            super(initialLocation);
            setRadius(7);
            setFill(Color.PURPLE);
        }

        @Override
        public void onPickup(Player player) {
            player.flash(Color.DARKMAGENTA);
            ScoreManager.removePoints(value);
            remove();
        }
}
