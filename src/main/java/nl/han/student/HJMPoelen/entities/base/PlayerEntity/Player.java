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

import java.util.List;
import java.util.Set;

public class Player extends DynamicEllipseEntity implements SceneBorderTouchingWatcher, KeyListener, Newtonian, Collider, Collided {

    private final HAN_Menace hanMenace;

    public Player(Coordinate2D initialPosition, Size size, HAN_Menace hanMenace) {
        super(initialPosition, size);
        this.hanMenace = hanMenace;
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.A)) {
            addToMotion(1, 270d);
        } else if (pressedKeys.contains(KeyCode.D)) {
            addToMotion(1, 90d);
        } else if (pressedKeys.contains(KeyCode.W)) {
            addToMotion(1, 180d);
        }

    }

    @Override
    public void notifyBoundaryTouching(final SceneBorder border) {
        if (border == SceneBorder.BOTTOM) {
            setSpeed(0);
            hanMenace.setActiveScene(2);
        }
    }

    @Override
    public void onCollision(List<Collider> list) {
    // iets van winnen en dood gaan en winnen indien de 'boss' aanraken
    }
}