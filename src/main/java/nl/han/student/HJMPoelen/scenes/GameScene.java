package nl.han.student.HJMPoelen.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.DynamicScene;
import javafx.scene.paint.Color;
import nl.han.student.HJMPoelen.HAN_Menace;
import nl.han.student.HJMPoelen.entities.base.HeaderText;
import nl.han.student.HJMPoelen.entities.base.PlayerEntity.Player;
import nl.han.student.HJMPoelen.entities.base.TestEntities.TestPlatform;

public class GameScene extends DynamicScene{
    protected HAN_Menace hanMenace;

    public GameScene(HAN_Menace hanMenace){
        this.hanMenace = hanMenace;
    }

    @Override
    public void setupScene() {
        setBackgroundColor(Color.GRAY);
    }

    @Override
    public void setupEntities() {
        /// ALL PLATFORMS ENEMIES ETC.
        TestPlatform testPlatform = new TestPlatform(new Coordinate2D(getWidth()/8 , getHeight() - 200), new Size(500, 10));
        Player player = new Player(new Coordinate2D(getWidth()/8, getHeight()/8), new Size(20, 20), hanMenace );
        var titelText = new HeaderText(
                new Coordinate2D( getWidth()/2 , getHeight() / 3),
                "GAMESCENE"
        );
        addEntity(titelText);
        addEntity(player);
        addEntity(testPlatform);
    }
}

