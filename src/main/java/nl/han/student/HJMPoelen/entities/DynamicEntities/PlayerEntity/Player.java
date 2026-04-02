package nl.han.student.HJMPoelen.entities.DynamicEntities.PlayerEntity;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.TimerContainer;
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
import nl.han.student.HJMPoelen.entities.DynamicEntities.UI.LivesListener;
import nl.han.student.HJMPoelen.entities.StaticEntities.Platform.Platform;

import java.util.List;
import java.util.Set;

public class Player extends DynamicEllipseEntity
        implements SceneBorderTouchingWatcher, KeyListener, Newtonian, Collider, Collided, TimerContainer{

    private static final double GROUND_SPEED = 1.0;
    private static final double AIR_SPEED = 0.95;
    private final Color DEFAULT_COLOR = Color.LIGHTGREEN;
    private final HAN_Menace hanMenace;
    private final Coordinate2D startPosition;

    private boolean isOnGround = false;
    private boolean isSlowed = false;
    private int lives = 3;
    private LivesListener livesListener;
    private int flashFrames = 0;
    private int slowFrames = 0;

    public Player(Coordinate2D initialPosition, Size size, HAN_Menace hanMenace) {
        super(initialPosition, size);
        this.hanMenace = hanMenace;
        this.startPosition = initialPosition;
        setFill(DEFAULT_COLOR);
        setGravityConstant(0.2);
        setGravityDirection(360);
        setFrictionConstant(0.10);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        double moveSpeed = isOnGround ? GROUND_SPEED : AIR_SPEED;
        if (isSlowed) moveSpeed *= 0.5; //half the movementspeed when poisoned

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
            hanMenace.setActiveScene(HAN_Menace.LOSTSCENE); //player is dead
        } else {
            setAnchorLocation(startPosition);
            setSpeed(0);
            isOnGround = false;
        }
    }
    public void gainLife() {
        lives++;
        if (livesListener != null) livesListener.onLivesChanged(lives);
    }

    public void flash(Color flashColor) {
        setFill(flashColor);
        flashFrames = 5;
    }

    public void slow() {
        isSlowed = true;
        slowFrames = 60; // ~3 seconds at 50ms ticks
    }

    public void updateEffects() {
        if (flashFrames > 0) {
            flashFrames--;
            if (flashFrames <= 0) {
                setFill(DEFAULT_COLOR);
            }
        }

        if (slowFrames > 0) {
            slowFrames--;
            if (slowFrames <= 0) {
                isSlowed = false;
            }
        }
    }

    @Override
    public void setupTimers() {
        addTimer(new PlayerEffectTimer(this));
    }
}