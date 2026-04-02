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
    private final Coordinate2D startPosition;
    private boolean isOnGround = false;
    private int lives = 3;
    private LivesListener livesListener;

    public Player(Coordinate2D initialPosition, Size size, HAN_Menace hanMenace) {
        super(initialPosition, size);
        this.hanMenace = hanMenace;
        this.startPosition = initialPosition;
        setFill(Color.LIGHTGREEN);
        setGravityConstant(0.2);
        setGravityDirection(360);
        setFrictionConstant(0.10);
    }

    public int getLives() {
        return lives;
    }

    public void setLivesListener(LivesListener listener) {
        this.livesListener = listener;
    }

    public void loseLife() {
        lives--;
        if (livesListener != null) livesListener.onLivesChanged(lives);
        if (lives <= 0) {
            hanMenace.setActiveScene(HAN_Menace.LOSTSCENE);
        } else {
            setAnchorLocation(startPosition);
            setSpeed(0);
            isOnGround = false;
        }
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
        isOnGround = false;
        for (Collider collider : colliders) {
            if (collider instanceof Platform platform) {
                double playerTop    = getAnchorLocation().getY();
                double playerBottom = playerTop + getHeight();
                double playerLeft   = getAnchorLocation().getX();
                double playerRight  = playerLeft + getWidth();

                double platformTop    = platform.getAnchorLocation().getY();
                double platformBottom = platformTop + platform.getHeight();
                double platformLeft   = platform.getAnchorLocation().getX();
                double platformRight  = platformLeft + platform.getWidth();

                double xOverlap = Math.min(playerRight, platformRight) - Math.max(playerLeft, platformLeft);
                double yOverlap = Math.min(playerBottom, platformBottom) - Math.max(playerTop, platformTop);

                if (yOverlap < xOverlap) {
                    // Vertical collision ]
                    if (playerTop + getHeight() / 2 < platformTop + platform.getHeight() / 2) {
                        setAnchorLocationY(platformTop - getHeight());
                        isOnGround = true;
                    } else {
                        setAnchorLocationY(platformBottom);
                        addToMotion(2, 360);
                    }
                } else {
                    // Horizontal collision
                    if (playerLeft + getWidth() / 2 < platformLeft + platform.getWidth() / 2) {
                        setAnchorLocationX(platformLeft - getWidth());
                    } else {
                        setAnchorLocationX(platformRight);
                    }
                }
            }
        }
    }
}