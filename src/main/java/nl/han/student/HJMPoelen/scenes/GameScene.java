package nl.han.student.HJMPoelen.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.DynamicScene;
import javafx.scene.paint.Color;
import nl.han.student.HJMPoelen.HAN_Menace;
import nl.han.student.HJMPoelen.entities.DynamicEntities.KillBoxEntities.Enemies.Boss;
import nl.han.student.HJMPoelen.entities.DynamicEntities.KillBoxEntities.Enemies.GhostEntity;
import nl.han.student.HJMPoelen.entities.DynamicEntities.KillBoxEntities.Enemies.EnemyEntity;

import nl.han.student.HJMPoelen.entities.DynamicEntities.KillBoxEntities.Rocket.RocketSpawner;
import nl.han.student.HJMPoelen.entities.StaticEntities.Items.Coin;
import nl.han.student.HJMPoelen.entities.StaticEntities.Platform.Platform;
import nl.han.student.HJMPoelen.entities.DynamicEntities.PlayerEntity.Player;
import nl.han.student.HJMPoelen.entities.DynamicEntities.UI.LivesDisplay;
import nl.han.student.HJMPoelen.entities.DynamicEntities.UI.ScreenFlash;

public class GameScene extends DynamicScene implements EntitySpawnerContainer {
    protected HAN_Menace hanMenace;
    private Player player;

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
        double yGapBtwnPlat = getHeight()/7;
        double xGapBtwnPlat = getWidth()/7;

        //Layers to place platform enemies coins etc on.
        double layer0y = getHeight()-platThickness;
        double layer1Y = layer0y - yGapBtwnPlat;
        double layer2Y = layer1Y - yGapBtwnPlat;
        double layer3Y = layer2Y - yGapBtwnPlat;
        double layer4Y = layer3Y - yGapBtwnPlat;
        double layer5Y = layer4Y - yGapBtwnPlat;

        //Platforms
        Platform BottomPlatform = new Platform(new Coordinate2D(0,layer0y),new Size(getWidth(),platThickness));
        addEntity(BottomPlatform);

        createSplitPlatforms(layer1Y, getWidth()-(xGapBtwnPlat*1.5), xGapBtwnPlat, platThickness);

        createSplitPlatforms(layer2Y, getWidth()/7, xGapBtwnPlat, platThickness);

        createSplitPlatforms(layer3Y, getWidth()/7 * 3, xGapBtwnPlat, platThickness);

        createSplitPlatforms(layer4Y, getWidth()/7 * 5, xGapBtwnPlat, platThickness);

        createSplitPlatforms(layer5Y, getWidth()/7 * 2, xGapBtwnPlat, platThickness);


        ///  Dynamic (Moveable) entities
        player = new Player(new Coordinate2D(getWidth()/7, getHeight() - 50 ), new Size(30, 30), hanMenace);

        //Boss
        Boss boss = new Boss(
                new Coordinate2D(getWidth() / 2 - 25, layer5Y - 80),
                new Size(50, 50),
                hanMenace
        );
        addEntity(boss);

        LivesDisplay livesDisplay = new LivesDisplay(new Coordinate2D(10, 10), player.getLives());
        addEntity(livesDisplay);

        ScreenFlash screenFlash = new ScreenFlash(new Coordinate2D(0, 0), new Size(getWidth(), getHeight()));
        addEntity(screenFlash);

        player.setLivesListener(lives -> {
            livesDisplay.updateLives(lives);
            screenFlash.flash();
        });

        addEntity(player);

        addCoins(layer1Y, layer2Y, layer3Y, layer4Y, layer0y);

        //Enemies
        addEntity(new GhostEntity(new Coordinate2D(getWidth() / 2 + 50, layer5Y - 80), hanMenace));

        addEntity(new EnemyEntity(new Coordinate2D(getWidth() / 7 * 4, layer1Y), hanMenace));
        addEntity(new EnemyEntity(new Coordinate2D(getWidth() / 3 * 2, layer2Y), hanMenace));
        addEntity(new EnemyEntity(new Coordinate2D(getWidth() / 5 * 3, layer3Y), hanMenace));
        addEntity(new EnemyEntity(new Coordinate2D(getWidth() / 7 * 3, layer4Y), hanMenace));
    }

    @Override
    public void setupEntitySpawners() {
    // EntistySpawnerContainer needed to use this setup and adder
        addEntitySpawner(new RocketSpawner(2000, player, getWidth())); //2 seconds between spawning of coins.
    }


    /// FUNCTIONS
    private void addCoins(double layer1Y, double layer2Y, double layer3Y, double layer4Y, double groundY) {
        //Place all coins with the same value.
        double coinValue = 100;
        double offsetY = 30;

        addEntity(new Coin(new Coordinate2D(getWidth() / 5, layer1Y - offsetY), (int) coinValue));
        addEntity(new Coin(new Coordinate2D(getWidth() / 2, layer2Y - offsetY), (int) coinValue));
        addEntity(new Coin(new Coordinate2D(getWidth() / 3, layer3Y - offsetY), (int) coinValue));
        addEntity(new Coin(new Coordinate2D(getWidth() / 1.3, layer4Y - offsetY), (int) coinValue));

    }

    public void createSplitPlatforms(double platformY, double gapX, double gapWidth, double platformThickness) {
        /// Function to make platform layer with a gap in between.

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

    }
}

