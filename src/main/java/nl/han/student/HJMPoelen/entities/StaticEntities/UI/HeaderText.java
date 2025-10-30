package nl.han.student.HJMPoelen.entities.StaticEntities.UI;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.han.student.HJMPoelen.HAN_Menace;


/// Text for header in Title- and Endscreen.
public class HeaderText extends TextEntity {
    private HAN_Menace hanMenace;
    private String text;
    public HeaderText(Coordinate2D initialLocation, String inputText) {
        super(initialLocation, inputText);
        this.text = inputText;
        this.hanMenace = hanMenace;
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setFill(Color.color(0.89,0,0.33));
        setStrokeColor(Color.color(0,0,0));
        setFont(Font.font("Roboto", FontWeight.BOLD, 50));
    }
}
