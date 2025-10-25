package nl.han.student.HJMPoelen.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.SceneBorder;
import javafx.scene.paint.Color;
import nl.han.student.HJMPoelen.HAN_Menace;
import nl.han.student.HJMPoelen.entities.base.HeaderText;
import nl.han.student.HJMPoelen.entities.base.KillBoxEntities.EnemyEntity;
import nl.han.student.HJMPoelen.entities.base.KillBoxEntities.RocketEntity;

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
       // RocketEntity rocket = new RocketEntity();
        EnemyEntity enemy = new EnemyEntity(new Coordinate2D(getWidth()/4,getHeight() / 4), new Size(20,20));
        var titelText = new HeaderText(
                new Coordinate2D( getWidth()/2 , getHeight() / 3),
                "GAMESCENE"
        );
        addEntity(titelText);
        addEntity(enemy);
        //addEntity(rocket);
        enemy.notifyBoundaryTouching(SceneBorder.LEFT);
        enemy.notifyBoundaryTouching(SceneBorder.RIGHT);
    }
}

