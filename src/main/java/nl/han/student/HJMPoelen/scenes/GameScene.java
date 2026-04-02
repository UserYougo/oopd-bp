package nl.han.student.HJMPoelen.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.DynamicScene;
import javafx.scene.paint.Color;
import nl.han.student.HJMPoelen.HAN_Menace;
import nl.han.student.HJMPoelen.entities.DynamicEntities.Boss;
import nl.han.student.HJMPoelen.entities.DynamicEntities.KillBoxEntities.Ghost.GhostEntity;
import nl.han.student.HJMPoelen.entities.DynamicEntities.KillBoxEntities.Enemies.EnemyEntity;

import nl.han.student.HJMPoelen.entities.DynamicEntities.KillBoxEntities.Rocket.RocketSpawner;
import nl.han.student.HJMPoelen.entities.StaticEntities.Items.BadCoin;
import nl.han.student.HJMPoelen.entities.StaticEntities.Items.Coin;
import nl.han.student.HJMPoelen.entities.StaticEntities.Items.HealthPotion;
import nl.han.student.HJMPoelen.entities.StaticEntities.Items.PoisonPotion;
import nl.han.student.HJMPoelen.entities.StaticEntities.Platform.Platform;
import nl.han.student.HJMPoelen.entities.DynamicEntities.PlayerEntity.Player;
import nl.han.student.HJMPoelen.entities.DynamicEntities.UI.LivesDisplay;
import nl.han.student.HJMPoelen.entities.DynamicEntities.UI.ScoreDisplay;
import nl.han.student.HJMPoelen.entities.DynamicEntities.UI.ScreenFlash;
import nl.han.student.HJMPoelen.entities.StaticEntities.ScoreManager;

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

        ///Stationary entities
        double platThickness = getHeight()/40;
        double yGapBtwnPlat = getHeight()/7;
        double xGapBtwnPlat = getWidth()/7;

        //Layers to place platform ,enemies, items, etc on.
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


        double offsetY = 20; //so items are off the platforms a bit

        // Coins
        addEntity(new Coin(new Coordinate2D(getWidth() / 1.5, layer1Y - offsetY)));
        addEntity(new Coin(new Coordinate2D(getWidth() / 5, layer1Y - offsetY)));
        addEntity(new Coin(new Coordinate2D(getWidth() / 1.3, layer2Y - offsetY)));
        addEntity(new Coin(new Coordinate2D(getWidth() / 2, layer2Y - offsetY)));
        addEntity(new Coin(new Coordinate2D(getWidth() / 5, layer3Y - offsetY)));
        addEntity(new Coin(new Coordinate2D(getWidth() / 4, layer4Y - offsetY)));
        addEntity(new Coin(new Coordinate2D(getWidth() / 1.8, layer4Y - offsetY)));
        addEntity(new Coin(new Coordinate2D(getWidth() / 3.5, layer5Y - offsetY)));

        // Poison Potions
        addEntity(new PoisonPotion(new Coordinate2D(getWidth() / 1.4, layer1Y - offsetY)));
        addEntity(new PoisonPotion(new Coordinate2D(getWidth() / 5.5, layer2Y - offsetY)));
        addEntity(new PoisonPotion(new Coordinate2D(getWidth() / 3, layer3Y - offsetY)));
        addEntity(new PoisonPotion(new Coordinate2D(getWidth() / 2.5, layer5Y - offsetY)));

        // Bad Coins
        addEntity(new BadCoin(new Coordinate2D(getWidth() / 2.2, layer1Y - offsetY)));
        addEntity(new BadCoin(new Coordinate2D(getWidth() / 4.5, layer3Y - offsetY)));
        addEntity(new BadCoin(new Coordinate2D(getWidth() / 1.1, layer4Y - offsetY)));

        // Health Potion
        addEntity(new HealthPotion(new Coordinate2D(getWidth() / 3.3, layer2Y - offsetY)));
        addEntity(new HealthPotion(new Coordinate2D(getWidth() / 1.03, layer4Y - offsetY)));

        ///  Dynamic (Moveable) entities
        //Player
        player = new Player(new Coordinate2D(getWidth()/7, getHeight() - 50 ), new Size(30, 30), hanMenace);

        LivesDisplay livesDisplay = new LivesDisplay(new Coordinate2D(10, 10), player.getLives());
        addEntity(livesDisplay);

        ScreenFlash screenFlash = new ScreenFlash(new Coordinate2D(0, 0), new Size(getWidth(), getHeight()));
        addEntity(screenFlash);

        player.setLivesListener
                (lives -> {
            livesDisplay.updateLives(lives);
            screenFlash.flash();
        });

        addEntity(player);

        //Scoreboard
        ScoreDisplay scoreDisplay = new ScoreDisplay(new Coordinate2D(getWidth() - 10, 10), ScoreManager.getScore());
        addEntity(scoreDisplay);
        ScoreManager.setScoreListener(
                score -> scoreDisplay.updateScore(score)
        );

        //Boss
        Boss boss = new Boss(
                new Coordinate2D(getWidth() / 2 - 25, layer5Y - 80),
                new Size(50, 50),
                hanMenace
        );
        addEntity(boss);

        //Enemies
        addEntity(new GhostEntity(new Coordinate2D(getWidth() / 2 + 50, layer5Y - 80)));
        addEntity(new GhostEntity(new Coordinate2D(getWidth() / 2, layer0y)));

        addEntity(new EnemyEntity(new Coordinate2D(getWidth() / 7 * 4, layer1Y)));
        addEntity(new EnemyEntity(new Coordinate2D(getWidth() / 3 * 2, layer2Y)));
        addEntity(new EnemyEntity(new Coordinate2D(getWidth() / 5 * 3, layer3Y)));
        addEntity(new EnemyEntity(new Coordinate2D(getWidth() / 7 * 3, layer4Y)));
    }

    @Override
    public void setupEntitySpawners() {
    // EntitySpawnerContainer needed to use this setup and adder
        addEntitySpawner(new RocketSpawner(2000, player, getWidth())); //2 seconds between spawning of coins.
    }


    /// FUNCTIONS
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