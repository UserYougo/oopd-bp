package nl.han.student.HJMPoelen.entities.base.KillBoxEntities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;
import com.github.hanyaeger.core.entities.EntityCollection;
import com.google.inject.Injector;

import java.util.List;
import java.util.Random;

public class RocketEntity extends DynamicRectangleEntity implements EntitySpawnerContainer {


    public RocketEntity(Coordinate2D initialPosition, Size size) {
        super(initialPosition, size);
    }

    public Coordinate2D randomSpawn(int layer, int height, int width, int multiplier) {
        double x = new Random().nextInt((int) getWidth() / 2 - width, (int) getWidth() / 2 + width);
        double y = getHeight() - height - (layer * multiplier);
        return new Coordinate2D(x, y);
    }

    @Override
    public void setupEntitySpawners() {

    }

    @Override
    public Injector getInjector() {
        return null;
    }

    @Override
    public EntityCollection getEntityCollection() {
        return null;
    }

    @Override
    public List<EntitySpawner> getSpawners() {
        return List.of();
    }
}

