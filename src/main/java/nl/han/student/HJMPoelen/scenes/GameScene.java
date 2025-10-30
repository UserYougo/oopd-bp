package nl.han.student.HJMPoelen.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.DynamicScene;
import javafx.scene.paint.Color;
import nl.han.student.HJMPoelen.HAN_Menace;
import nl.han.student.HJMPoelen.entities.DynamicEntities.KillBoxEntities.Enemies.EnemyEntity;
import nl.han.student.HJMPoelen.entities.DynamicEntities.KillBoxEntities.Enemies.EnemyMovementBoundyHitbox;
import nl.han.student.HJMPoelen.entities.DynamicEntities.KillBoxEntities.Rocket.RocketEntity;
import nl.han.student.HJMPoelen.entities.StaticEntities.CoinPurse.Coin;
import nl.han.student.HJMPoelen.entities.StaticEntities.Hitbox;
import nl.han.student.HJMPoelen.entities.StaticEntities.Platform.Platform;
import nl.han.student.HJMPoelen.entities.StaticEntities.UI.HeaderText;
import nl.han.student.HJMPoelen.entities.DynamicEntities.PlayerEntity.Player;

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

        ///Stationary enteties
        double platThickness = getHeight()/40;
        double yGapBtwnPlat = getHeight()/5.3;
        double xGapBtwnPlat = getWidth()/7;

        double layer0y = getHeight()-platThickness;
        Platform plat0 = new Platform(new Coordinate2D(0,layer0y),new Size(getWidth(),platThickness));
        addEntity(plat0);

        double layer1Y = layer0y - yGapBtwnPlat;
        createSplitPlatforms(layer1Y, getWidth()-(xGapBtwnPlat*1.5), xGapBtwnPlat, platThickness);

        double layer2Y = layer1Y - yGapBtwnPlat;
        createSplitPlatforms(layer2Y, getWidth()/7, xGapBtwnPlat, platThickness);

        double layer3Y = layer2Y - yGapBtwnPlat;
        createSplitPlatforms(layer3Y, getWidth()/7 * 3, xGapBtwnPlat, platThickness);

        double layer4Y = layer3Y - yGapBtwnPlat;
        createSplitPlatforms(layer4Y, getWidth()/7 * 5, xGapBtwnPlat, platThickness);

        var titelText = new HeaderText(
                new Coordinate2D( getWidth()/2 , getHeight() / 3),
                "GAMESCENE"
        );
        addEntity(titelText);


        ///moving entities
        Player player = new Player(new Coordinate2D(getWidth()/7, layer1Y), new Size(30, 30), hanMenace);
        addEntity(player);

        EnemyEntity enemy = new EnemyEntity(new Coordinate2D(getWidth()/7 * 4, layer1Y), hanMenace);
        addEntity(enemy);

        RocketEntity rocket1 = new RocketEntity(new Coordinate2D(getWidth()/2, 0), hanMenace);
        addEntity(rocket1);
        addCoins(layer1Y, layer2Y, layer3Y, layer4Y, layer0y);
    }

    private void addCoins(double layer1Y, double layer2Y, double layer3Y, double layer4Y, double groundY) {
        double coinValue = 100;
        double offsetY = 30;

        addEntity(new Coin(new Coordinate2D(getWidth() / 5, layer1Y - offsetY), (int) coinValue));
        addEntity(new Coin(new Coordinate2D(getWidth() / 2, layer2Y - offsetY), (int) coinValue));
        addEntity(new Coin(new Coordinate2D(getWidth() / 3, layer3Y - offsetY), (int) coinValue));
        addEntity(new Coin(new Coordinate2D(getWidth() / 1.3, layer4Y - offsetY), (int) coinValue));

    }

    public void createSplitPlatforms(double platformY, double gapX, double gapWidth, double platformThickness) { /// Function to make platform layer with a gap in between
        Platform leftPlat = new Platform(
                new Coordinate2D(0, platformY),
                new Size(gapX, platformThickness)
        );
        addEntity(leftPlat);

        Platform rightPlat = new Platform(
                new Coordinate2D(gapX + gapWidth, platformY),
                new Size(getWidth() - (gapX + gapWidth), platformThickness)
        );
        addEntity(rightPlat);

        EnemyMovementBoundyHitbox enemyMovementBoundyHitbox = new EnemyMovementBoundyHitbox(new Coordinate2D(gapX, platformY-platformThickness*3), new Size(gapWidth, platformThickness*4));
        addEntity(enemyMovementBoundyHitbox);
    }
}

