package nl.han.student.HJMPoelen.entities.DynamicEntities.KillBoxEntities.Rocket;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import nl.han.student.HJMPoelen.HAN_Menace;

public class RocketEntity extends DynamicCompositeEntity {
    private HAN_Menace hanMenace;
    private double width = 8;
    private double height = 15;

    public RocketEntity(Coordinate2D initialLocation, HAN_Menace hanMenace) {
        super(initialLocation);
        this.hanMenace = hanMenace;
        move();
    }

    public void move(){
        setMotion(2, Direction.DOWN);
    }

    @Override
    protected void setupEntities() {
        var RocketHitbox = new RocketEntityDamage(new Coordinate2D(0,0), new Size(width, height),  hanMenace);
        addEntity(RocketHitbox);

        var RocketEntityAppearance = new RocketEntityAppearance(new Coordinate2D(0,0), new Size(width, height));
        addEntity(RocketEntityAppearance);
    }
}