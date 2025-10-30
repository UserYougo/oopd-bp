package nl.han.student.HJMPoelen.entities.StaticEntities.UI.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.MouseButton;
import nl.han.student.HJMPoelen.HAN_Menace;
import nl.han.student.HJMPoelen.entities.StaticEntities.UI.buttons.baseButton.BaseButton;

public class BackHomeButton extends BaseButton {
        protected HAN_Menace hanMenace;

        public BackHomeButton(final Coordinate2D initialLocation, final HAN_Menace hanMenace) {
            super(initialLocation, "Back Home?"); // de button is te klein voor de tekst
            this.hanMenace = hanMenace;

        }
        @Override
        public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
            hanMenace.setActiveScene(0);
        }

    }