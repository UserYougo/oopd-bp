package nl.han.student.HJMPoelen.entities.DynamicEntities.KillBoxEntities.Rocket;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import nl.han.student.HJMPoelen.entities.DynamicEntities.PlayerEntity.Player;

import java.util.Random;

public class RocketSpawner extends EntitySpawner {

    private final Player player;
    private final double sceneWidth;
    private final Random random = new Random();

    public RocketSpawner(long intervalInMs, Player player, double sceneWidth) {
        super(intervalInMs);
        this.player = player;
        this.sceneWidth = sceneWidth;
    }

    @Override
    protected void spawnEntities() {
        double playerX = player.getAnchorLocation().getX();
        double spawnX = playerX - 50 + random.nextDouble() * 100;
        spawnX = Math.max(0, Math.min(spawnX, sceneWidth));
        spawn(new RocketEntity(new Coordinate2D(spawnX, 0)));
    }
}
