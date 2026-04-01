package nl.han.student.HJMPoelen.entities.DynamicEntities.KillBoxEntities.Enemies;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import javafx.scene.paint.Color;
import nl.han.student.HJMPoelen.HAN_Menace;
import nl.han.student.HJMPoelen.entities.DynamicEntities.KillBoxEntities.DynamicKillBox;

public class EnemyEntityDamage extends DynamicKillBox {
    //Separate class so if we want to change the behavior we can
    protected EnemyEntityDamage(Coordinate2D initialPosition, Size size, HAN_Menace app) {
        super(initialPosition, size, app);
        setFill(Color.TRANSPARENT);
    }
}
