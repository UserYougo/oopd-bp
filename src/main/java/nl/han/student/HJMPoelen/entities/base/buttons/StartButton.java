package nl.han.student.HJMPoelen.entities.base.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.MouseButton;
import nl.han.student.HJMPoelen.HAN_Menace;

import java.awt.*;


public class StartButton extends BaseButton{
    protected HAN_Menace hanMenace;


    public StartButton(final Coordinate2D initialLocation, final HAN_Menace hanMenace) {
        super(initialLocation, "Start");
        this.hanMenace = hanMenace;
    }
    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        hanMenace.setActiveScene(1);
    }

}
