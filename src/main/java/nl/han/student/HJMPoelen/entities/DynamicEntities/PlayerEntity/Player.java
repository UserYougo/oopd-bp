package nl.han.student.HJMPoelen.entities.DynamicEntities.PlayerEntity;

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
import javafx.scene.paint.Color;
import nl.han.student.HJMPoelen.HAN_Menace;
import nl.han.student.HJMPoelen.entities.StaticEntities.Platform.Platform;

import java.util.List;
import java.util.Set;

public class Player extends DynamicEllipseEntity
        implements SceneBorderTouchingWatcher, KeyListener, Newtonian, Collider, Collided {

    private final HAN_Menace hanMenace;
    private boolean isOnGround = false;

    public Player(Coordinate2D initialPosition, Size size, HAN_Menace hanMenace) {
        super(initialPosition, size);
        this.hanMenace = hanMenace;
        setFill(Color.LIGHTGREEN);
        setGravityConstant(0.3);
        setGravityDirection(360);
        setFrictionConstant(0);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {

        double moveSpeed = isOnGround ? 2.0 : 0.8;

        if (pressedKeys.contains(KeyCode.A)) {
            addToMotion(moveSpeed, 270d);
        } else if (pressedKeys.contains(KeyCode.D)) {
            addToMotion(moveSpeed, 90d);
        }

        if (pressedKeys.contains(KeyCode.W) && isOnGround) {
            setMotion(10, 180d);
            isOnGround = false;
        }
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border) {
        switch (border) {
            case TOP -> {
                setAnchorLocationY(0);
                setSpeed(0);
            }
            case BOTTOM -> {
                setAnchorLocationY(getSceneHeight() - getHeight());
                setSpeed(0);
                isOnGround = true;
            }
            case LEFT -> {
                setAnchorLocationX(0);
                setSpeed(0);
            }
            case RIGHT -> {
                setAnchorLocationX(getSceneWidth() - getWidth());
                setSpeed(0);
            }
        }
    }

    @Override
    public void onCollision(List<Collider> colliders) {
        for (Collider collider : colliders) {
            if (collider instanceof Platform platform) {
                double playerBottom = getAnchorLocation().getY() + getHeight();
                double platformTop = platform.getAnchorLocation().getY();

                if (playerBottom <= platformTop + 10) {
                    setAnchorLocationY(platformTop - getHeight());
                    setSpeed(0);
                    isOnGround = true;
                }
            }
        }

        if (isOnGround && getSpeed() < 0.5) {
            setSpeed(0);
        }
    }
}
