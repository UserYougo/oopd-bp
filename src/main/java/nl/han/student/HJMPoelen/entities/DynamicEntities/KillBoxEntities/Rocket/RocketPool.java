package nl.han.student.HJMPoelen.entities.DynamicEntities.KillBoxEntities.Rocket;

import com.github.hanyaeger.api.entities.EntitySpawner;
import nl.han.student.HJMPoelen.entities.DynamicEntities.PlayerEntity.Player;

import java.util.List;

public class RocketPool extends EntitySpawner {
    private final List<RocketEntity> rockets;
    private final Player player;
    private int index = 0;

    public RocketPool(long intervalInMs, List<RocketEntity> rockets, Player player) {
        super(intervalInMs);
        this.rockets = rockets;
        this.player = player;
    }

    @Override
    protected void spawnEntities() {
        rockets.get(index % rockets.size()).launch(player.getAnchorLocation().getX());
        index++;
    }
}