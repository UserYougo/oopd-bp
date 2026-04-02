package nl.han.student.HJMPoelen.entities.DynamicEntities.KillBoxEntities.Rocket;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;
import nl.han.student.HJMPoelen.HAN_Menace;
import nl.han.student.HJMPoelen.entities.DynamicEntities.KillBoxEntities.DynamicKillBox;

public class RocketEntity extends DynamicCompositeEntity implements SceneBorderTouchingWatcher {
    private final double width = 8;
    private final double height = 15;

    public RocketEntity(Coordinate2D initialLocation) {
        super(initialLocation);
        setMotion(2, Direction.DOWN);
    }

    @Override
    protected void setupEntities() {
        var hitbox = new DynamicKillBox(new Coordinate2D(0,0), new Size(width, height));
        addEntity(hitbox);

        var appearance = new RocketEntityAppearance(new Coordinate2D(0,0), new Size(width, height));
        addEntity(appearance);


    }
    @Override
    public void notifyBoundaryTouching(SceneBorder border) {
        if (border == SceneBorder.BOTTOM) {
            remove();
        }
    }
}
