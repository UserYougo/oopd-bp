package nl.han.student.HJMPoelen.entities.StaticEntities.UI.buttons.baseButton;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class BaseButtonText extends TextEntity {

    private Color textColor;

    public BaseButtonText(final Coordinate2D initialPosition, final String text, final Color textColor, final int textSize) {
        super(initialPosition, text);
        setTextColor(textColor);
        setFill(textColor);
        setFont(Font.font("Roboto", FontWeight.EXTRA_BOLD, textSize));
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }

    public void onMouseEntered() {
        setFill(Color.RED);
    }

    public void onMouseExited() {
        setFill(textColor); /// revert to original color
    }

    protected void setTextColor(final Color textColor) {
        this.textColor = textColor;
    }
}
