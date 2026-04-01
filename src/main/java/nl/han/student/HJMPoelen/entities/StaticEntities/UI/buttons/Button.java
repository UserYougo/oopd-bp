package nl.han.student.HJMPoelen.entities.StaticEntities.UI.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.MouseButton;
import nl.han.student.HJMPoelen.HAN_Menace;
import nl.han.student.HJMPoelen.entities.StaticEntities.CoinPurse.ScoreManager;
import nl.han.student.HJMPoelen.entities.StaticEntities.UI.buttons.baseButton.BaseButton;


public class Button extends BaseButton {
    protected HAN_Menace hanMenace;
    private String text;
    private int setScene;

    public Button(final Coordinate2D initialLocation, final HAN_Menace hanMenace, String text, int setScene) {
        super(initialLocation, text);
        this.hanMenace = hanMenace;
        this.setScene = setScene;
        this.text = text;
    }
    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        ScoreManager.reset();
        hanMenace.setActiveScene(setScene);
    }

}
