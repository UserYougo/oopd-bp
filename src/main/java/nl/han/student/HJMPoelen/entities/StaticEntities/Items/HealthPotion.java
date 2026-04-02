package nl.han.student.HJMPoelen.entities.StaticEntities.Items;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.paint.Color;
import nl.han.student.HJMPoelen.entities.DynamicEntities.PlayerEntity.Player;

public class HealthPotion extends Item {

    public HealthPotion(Coordinate2D initialLocation) {
        super(initialLocation);
        setRadius(10);
        setFill(Color.SPRINGGREEN);
    }

    @Override
    public void onPickup(Player player) {
        player.gainLife();
        remove();
    }
}
