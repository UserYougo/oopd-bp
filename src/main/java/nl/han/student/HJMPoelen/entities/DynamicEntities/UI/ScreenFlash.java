package nl.han.student.HJMPoelen.entities.DynamicEntities.UI;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;
import javafx.animation.FadeTransition;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class ScreenFlash extends DynamicRectangleEntity {

    public ScreenFlash(Coordinate2D position, Size size) {
        super(position, size);
        setFill(Color.RED);
        setOpacity(0);
    }

    public void flash() {
        setOpacity(0.4);
        // FadeTransition is used here because Yaeger doesn't have built-in opacity animation that i know of.
        // getNode() exposes the underlying JavaFX node so we can apply JavaFX transitions directly.
        // Might be a bit crude but it works :) -h
        FadeTransition fade = new FadeTransition(Duration.millis(600), getNode().get());
        fade.setFromValue(0.4);
        fade.setToValue(0);
        fade.play();
    }
}