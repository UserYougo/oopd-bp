package nl.han.student.HJMPoelen.entities.StaticEntities.UI.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import nl.han.student.HJMPoelen.entities.StaticEntities.UI.buttons.baseButton.BaseButton;

public class ExitButton extends BaseButton {

    public ExitButton(Coordinate2D initialLocation) {
        super(initialLocation, "Exit", new Size(80, 40), Color.BLACK, Color.WHITE);
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        System.exit(0);
    }
}