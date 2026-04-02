package nl.han.student.HJMPoelen.entities.StaticEntities.Items;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.paint.Color;
import nl.han.student.HJMPoelen.entities.DynamicEntities.PlayerEntity.Player;

public class PoisonPotion extends Item {

    public PoisonPotion(Coordinate2D initialLocation) {
        super(initialLocation);
        setRadius(7);
        setFill(Color.DARKBLUE);
    }

    @Override
    public void onPickup(Player player) {
        player.slow();
        player.flash(Color.DEEPSKYBLUE);
        remove();
    }
}
