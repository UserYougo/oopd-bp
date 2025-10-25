package nl.han.student.HJMPoelen;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import nl.han.student.HJMPoelen.scenes.GameScene;
import nl.han.student.HJMPoelen.scenes.LostScene;
import nl.han.student.HJMPoelen.scenes.TitelScene;


public class HAN_Menace extends YaegerGame{
    public static final int GAMESCENE = 1;

    public static void main(String[] args) {
        YaegerGame.launch(args);
    }
    @Override
    public void setupGame() {
        setGameTitle("Han_Menace v0.1");
        setSize(new Size(1920/2,1080/2));
    }
    @Override
    public void setupScenes() {
        addScene(0, new TitelScene(this));
        addScene(GAMESCENE, new GameScene(this));
        addScene(2, new LostScene(this));
    }

}
