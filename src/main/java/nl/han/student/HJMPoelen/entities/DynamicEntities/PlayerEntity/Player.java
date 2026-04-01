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

    private static final double GROUND_SPEED = 1.0;
    private static final double AIR_SPEED = 0.95;

    private final HAN_Menace hanMenace;
    private boolean isOnGround = false;

    public Player(Coordinate2D initialPosition, Size size, HAN_Menace hanMenace) {
        super(initialPosition, size);
        this.hanMenace = hanMenace;
        setFill(Color.LIGHTGREEN);
        setGravityConstant(0.2);
        setGravityDirection(360);
        setFrictionConstant(0.10);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        double moveSpeed = isOnGround ? GROUND_SPEED : AIR_SPEED;

        if (pressedKeys.contains(KeyCode.A)) {
            addToMotion(moveSpeed, 270d);
        } else if (pressedKeys.contains(KeyCode.D)) {
            addToMotion(moveSpeed, 90d);
        }

        if (pressedKeys.contains(KeyCode.W) && isOnGround) {
            addToMotion(15, 180d);
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
            case LEFT -> setAnchorLocationX(0);
            case RIGHT -> setAnchorLocationX(getSceneWidth() - getWidth());
        }
    }

    @Override
    public void onCollision(List<Collider> colliders) {
        isOnGround = false; // reset here instead of update
        for (Collider collider : colliders) {
            if (collider instanceof Platform platform) {
                double playerBottom = getAnchorLocation().getY() + getHeight();
                double playerTop = getAnchorLocation().getY();
                double platformTop = platform.getAnchorLocation().getY();
                double platformBottom = platform.getAnchorLocation().getY() + platform.getHeight();

                double playerRight = getAnchorLocation().getX() + getWidth();
                double playerLeft = getAnchorLocation().getX();
                double platformLeft = platform.getAnchorLocation().getX();
                double platformRight = platform.getAnchorLocation().getX() + platform.getWidth();

                if (playerBottom <= platformTop + getHeight() * 0.3) { //Top Platform
                    setAnchorLocationY(platformTop - getHeight());
                    isOnGround = true;
                } else if (playerRight <= platformLeft + getWidth() * 0.3) { //Left side Platform
                    setAnchorLocationX(platformLeft - getWidth());
                    addToMotion(1, 270d);
                } else if (playerLeft >= platformRight - getWidth() * 0.3) { //Right side Platform
                    setAnchorLocationX(platformRight);
                    addToMotion(1, 90d);
                } else if (playerTop >= platformBottom - getHeight() * 0.3) { //Bottom Platform
                    setAnchorLocationY(platformBottom);
                    addToMotion(2, 360);
                }
            }
        }

    }
}