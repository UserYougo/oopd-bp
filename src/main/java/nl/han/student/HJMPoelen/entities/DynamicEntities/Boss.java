package nl.han.student.HJMPoelen.entities.DynamicEntities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;
import javafx.scene.paint.Color;
import nl.han.student.HJMPoelen.HAN_Menace;
import nl.han.student.HJMPoelen.entities.DynamicEntities.PlayerEntity.Player;
import nl.han.student.HJMPoelen.entities.StaticEntities.ScoreManager;

import java.util.List;

public class Boss extends DynamicRectangleEntity implements Collider, Collided {

    private final HAN_Menace hanMenace;

    public Boss(Coordinate2D location, Size size, HAN_Menace hanMenace) {
        super(location, size);
        this.hanMenace = hanMenace;
        setFill(Color.DARKRED);
    }

    @Override
    public void onCollision(List<Collider> colliders) {
        for (Collider collider : colliders) {
            if (collider instanceof Player player) {
                ScoreManager.addPoints(player.getLives() * 150); //bonus for each live the player still has
                ScoreManager.addPoints(200); //point for getting to the boss
                ScoreManager.saveHighscore();

                hanMenace.setActiveScene(HAN_Menace.WINSCENE);
            }
        }
    }
}
