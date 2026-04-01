package nl.han.student.HJMPoelen.entities.StaticEntities.UI.buttons.baseButton;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.CompositeEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.Cursor;
import javafx.scene.paint.Color;



public abstract class BaseButton extends CompositeEntity implements MouseEnterListener, MouseExitListener, MouseButtonPressedListener {
    // Default Colours
    private Color defaultTextColor = Color.BLACK;
    private Color defaultBackgroundColor = Color.GREY;

    private final double width;
    private final double height;
    private final String text;
    private BaseButtonText baseButtonText;


    public BaseButton(Coordinate2D initialLocation, String text, Size size) {
        super(initialLocation);
        this.text = text;
        this.width = size.width();
        this.height = size.height();

        setViewOrder(5); //FROM Yeager Tutorial, Maybe not needed\
    }

    public BaseButton(Coordinate2D initialLocation, String text) {
        super(initialLocation);
        this.text = text;
        this.width = 100; // moet nog ff kijken of dit 200 of iets moet zijn, of dat je het in de constructor zet van childs
        this.height = 50;

        setViewOrder(5);
    }


    @Override
    protected void setupEntities() {
        var baseButtonBox = new BaseButtonBox(new Coordinate2D(0, 0), new Size(width, height), defaultBackgroundColor);
        addEntity(baseButtonBox);

        baseButtonText = new BaseButtonText(new Coordinate2D(0, 0), text, defaultTextColor, 30);
        addEntity(baseButtonText);
    }

    @Override
    public void onMouseEntered() {
        setCursor(Cursor.HAND);
        baseButtonText.onMouseEntered();
    }

    @Override
    public void onMouseExited() {
        setCursor(Cursor.DEFAULT);
        baseButtonText.onMouseExited();
    }

}
