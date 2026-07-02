package nl.han.student.HJMPoelen.entities.DynamicEntities.KillBoxEntities.Rocket;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;
import nl.han.student.HJMPoelen.entities.DynamicEntities.KillBoxEntities.DynamicDamageBox;

import java.util.Random;

public class RocketEntity extends DynamicCompositeEntity implements SceneBorderTouchingWatcher {
    private final double width = 8;
    private final double height = 15;
    private final double sceneWidth;
    private final Random random = new Random();

    public RocketEntity(Coordinate2D initialLocation, double sceneWidth) {
        super(initialLocation);
        this.sceneWidth = sceneWidth;
        setMotion(0, Direction.DOWN);
    }

    @Override
    protected void setupEntities() {
        addEntity(new DynamicDamageBox(new Coordinate2D(0, 0), new Size(width, height)));
        addEntity(new RocketEntityAppearance(new Coordinate2D(0, 0), new Size(width, height)));
    }

    public void launch(double playerX) {
        double spawnX = playerX - 50 + random.nextDouble() * 100;
        spawnX = Math.max(0, Math.min(spawnX, sceneWidth));
        setAnchorLocation(new Coordinate2D(spawnX, 0));
        setMotion(2, Direction.DOWN);
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border) {
        if (border == SceneBorder.BOTTOM) {
            setAnchorLocation(new Coordinate2D(-999, -999));
            setMotion(0, Direction.DOWN);
        }
    }
}