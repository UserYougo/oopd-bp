package nl.han.student.HJMPoelen.entities.StaticEntities.UI.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import nl.han.student.HJMPoelen.HAN_Menace;
import nl.han.student.HJMPoelen.entities.StaticEntities.ScoreManager;
import nl.han.student.HJMPoelen.entities.StaticEntities.UI.buttons.baseButton.BaseButton;

public class Button extends BaseButton {
    protected HAN_Menace hanMenace;
    private int setScene;


    public Button(final Coordinate2D initialLocation, final HAN_Menace hanMenace, String text, int setScene) {
        super(initialLocation, text);
        this.hanMenace = hanMenace;
        this.setScene = setScene;
    }

    public Button(final Coordinate2D initialLocation, final HAN_Menace hanMenace, String text, int setScene, Color backgroundColor, Color textColor) {
        super(initialLocation, text, new Size(100, 50), backgroundColor, textColor);
        this.hanMenace = hanMenace;
        this.setScene = setScene;
    }
    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        ScoreManager.reset();
        hanMenace.setActiveScene(setScene);
    }
}