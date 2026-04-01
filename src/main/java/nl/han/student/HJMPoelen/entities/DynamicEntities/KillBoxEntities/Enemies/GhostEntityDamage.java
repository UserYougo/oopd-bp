package nl.han.student.HJMPoelen.entities.DynamicEntities.KillBoxEntities.Enemies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import nl.han.student.HJMPoelen.HAN_Menace;
import nl.han.student.HJMPoelen.entities.DynamicEntities.KillBoxEntities.DynamicKillBox;
import javafx.scene.paint.Color;

public class GhostEntityDamage extends DynamicKillBox {
    protected GhostEntityDamage(Coordinate2D initialPosition, Size size, HAN_Menace app) {
        super(initialPosition, size);
        setFill(Color.TRANSPARENT);
    }
}