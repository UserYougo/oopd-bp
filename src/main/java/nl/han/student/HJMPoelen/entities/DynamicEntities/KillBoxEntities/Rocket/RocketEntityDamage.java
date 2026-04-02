package nl.han.student.HJMPoelen.entities.DynamicEntities.KillBoxEntities.Rocket;


import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import javafx.scene.paint.Color;
import nl.han.student.HJMPoelen.entities.DynamicEntities.KillBoxEntities.DynamicKillBox;


public class RocketEntityDamage extends DynamicKillBox {
    //Separate class so if we want to change the behavior we can
    protected RocketEntityDamage(Coordinate2D initialPosition, Size size) {
        super(initialPosition, size);
        setFill(Color.TRANSPARENT);
    }
}