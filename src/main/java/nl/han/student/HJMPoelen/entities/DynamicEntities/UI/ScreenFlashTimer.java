package nl.han.student.HJMPoelen.entities.DynamicEntities.UI;

import com.github.hanyaeger.api.Timer;

public class ScreenFlashTimer extends Timer {

    private final ScreenFlash screenFlash;

    public ScreenFlashTimer(ScreenFlash screenFlash) {
        super(50);
        this.screenFlash = screenFlash;
    }

    @Override
    public void onAnimationUpdate(long timestamp) {
        screenFlash.updateFlash();
    }
}
