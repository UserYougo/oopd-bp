package nl.han.student.HJMPoelen;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import nl.han.student.HJMPoelen.scenes.GameScene;
import nl.han.student.HJMPoelen.scenes.LostScene;
import nl.han.student.HJMPoelen.scenes.TitelScene;
import nl.han.student.HJMPoelen.scenes.WinScene;


public class HAN_Menace extends YaegerGame{
    public static final int TITELSCENE = 0;
    public static final int GAMESCENE = 1;
    public static final int LOSTSCENE = 2;
    public static final int WINSCENE = 3;

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
        addScene(TITELSCENE, new TitelScene(this));
        addScene(GAMESCENE, new GameScene(this));
        addScene(LOSTSCENE, new LostScene(this));
        addScene(WINSCENE, new WinScene(this));

    }
}
