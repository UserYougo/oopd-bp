package nl.han.student.HJMPoelen.entities.base.PlayerEntity;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicEllipseEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import nl.han.student.HJMPoelen.HAN_Menace;
import nl.han.student.HJMPoelen.entities.base.TestEntities.TestPlatform;

import java.util.List;
import java.util.Set;

public class Player extends DynamicEllipseEntity implements SceneBorderTouchingWatcher, KeyListener, Newtonian, Collider, Collided {

    private final HAN_Menace hanMenace;
    private boolean isOnGround = false;

    public Player(Coordinate2D initialPosition, Size size, HAN_Menace hanMenace) {
        super(initialPosition, size);
        this.hanMenace = hanMenace;

        setGravityConstant(0.3);
        setGravityDirection(360);
        // de speler vertraagt steeds op platform, ik kom er maar niet uit.
        setFrictionConstant(0.05);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {

        if (pressedKeys.contains(KeyCode.A)) {
            addToMotion(0.3, 270d);
        } else if (pressedKeys.contains(KeyCode.D)) {
            addToMotion(0.3, 90d);
        }

        if (pressedKeys.contains(KeyCode.W) && isOnGround) {
            setMotion(8, 180d);
            isOnGround = false;
        }
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border) {
        if (border == SceneBorder.BOTTOM) {
            hanMenace.setActiveScene(2);
        }
    }

    @Override
    public void onCollision(List<Collider> colliders) {
        for (Collider collider : colliders) {
            if (collider instanceof TestPlatform platform) {

                double playerBottom = getAnchorLocation().getY() + getHeight();
                double platformTop = platform.getAnchorLocation().getY();

                if (playerBottom <= platformTop + 10) {
                    setAnchorLocationY(platformTop - getHeight());
                    setSpeed(0); // dit zorgt dat de speler niet door een platform valt
                    isOnGround = true;
                }
            }
        }
    }
}