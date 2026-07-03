package nl.han.student.HJMPoelen.entities.StaticEntities.UI;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.han.student.HJMPoelen.HAN_Menace;


/// Text for header in Title- and Endscreens.
public class HeaderText extends TextEntity {
    public HeaderText(Coordinate2D initialLocation, String inputText) {
        super(initialLocation, inputText);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setFill(HAN_Menace.HAN_COLOR);
        setStrokeColor(Color.color(0,0,0));
        setFont(Font.font("Roboto", FontWeight.BOLD, 50));
    }
}
