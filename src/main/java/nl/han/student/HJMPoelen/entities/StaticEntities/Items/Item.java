package nl.han.student.HJMPoelen.entities.StaticEntities.Items;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.CircleEntity;
import nl.han.student.HJMPoelen.entities.DynamicEntities.PlayerEntity.Player;

import java.util.List;

public abstract class Item extends CircleEntity implements Collided {

    protected Item(Coordinate2D initialLocation) {
        super(initialLocation);
    }

    public abstract void onPickup();

    @Override
    public void onCollision(List<Collider> colliders) {
        for (Collider collider : colliders) {
            if (collider instanceof Player) {
                onPickup();
            }
        }
    }
}

