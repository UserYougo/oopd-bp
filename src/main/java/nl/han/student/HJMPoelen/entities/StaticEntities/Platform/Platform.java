package nl.han.student.HJMPoelen.entities.StaticEntities.Platform;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import javafx.scene.paint.Color;

import nl.han.student.HJMPoelen.HAN_Menace;
import nl.han.student.HJMPoelen.entities.StaticEntities.Hitbox;

public class Platform extends Hitbox {
    private HAN_Menace hanMenace;
    private double width;
    private double height;

    public Platform(Coordinate2D initialPosition, Size size) {
        super(initialPosition, size);
        this.width = size.width();
        this.height = size.height();
        initializePlatform();
    }
    private void initializePlatform() {
        setSize();
        setAppearance();
    }
    private void setAppearance(){
        setFill(Color.BLACK);
        setStrokeColor(Color.BLACK);
    }
    private void setSize(){
        setHitBoxWidth(width);
        setHitBoxHeight(height);
    }
    public void updatePlatform(double newWidth, double newHeight){
        this.width = newWidth;
        this.height = newHeight;
        setSize();
    }
}