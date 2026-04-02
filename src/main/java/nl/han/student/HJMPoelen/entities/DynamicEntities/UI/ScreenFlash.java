package nl.han.student.HJMPoelen.entities.DynamicEntities.UI;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;
import javafx.scene.paint.Color;

public class ScreenFlash extends DynamicRectangleEntity implements TimerContainer {

    private boolean flashing = false;

    public ScreenFlash(Coordinate2D position, Size size) {
        super(position, size);
        setFill(Color.RED);
        setOpacity(0);
    }

    public void flash() {
        setOpacity(0.4);
        flashing = true;
    }

    public void updateFlash() {
        if (flashing) {
            double current = getOpacity();
            if (current > 0) {
                setOpacity(current - 0.03);
            } else {
                setOpacity(0);
                flashing = false;
            }
        }
    }

    @Override
    public void setupTimers() {
        addTimer(new ScreenFlashTimer(this));
    }
}
