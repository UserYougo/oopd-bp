package nl.han.student.HJMPoelen.entities.DynamicEntities.KillBoxEntities.Rocket;


import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import javafx.scene.paint.Color;
import nl.han.student.HJMPoelen.HAN_Menace;
import nl.han.student.HJMPoelen.entities.DynamicEntities.DynamicHitbox;
import nl.han.student.HJMPoelen.entities.DynamicEntities.KillBoxEntities.DynamicKillBox;
import nl.han.student.HJMPoelen.entities.DynamicEntities.PlayerEntity.Player;

import static nl.han.student.HJMPoelen.HAN_Menace.LOSTSCENE;


import java.util.List;


public class RocketEntityDamage extends DynamicKillBox {
    //Separate class so if we want to change the behavior we can
    protected RocketEntityDamage(Coordinate2D initialPosition, Size size, HAN_Menace app) {
        super(initialPosition, size, app);
        setFill(Color.TRANSPARENT);
    }
}