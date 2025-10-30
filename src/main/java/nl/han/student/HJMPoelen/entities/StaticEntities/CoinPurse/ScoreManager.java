package nl.han.student.HJMPoelen.entities.StaticEntities.CoinPurse;

import java.util.ArrayList;
import java.util.Collections;

public class ScoreManager {
    public static int score;
    private static ArrayList<Integer> highscores = new ArrayList<>();

    public static void addPoints(int points) {
        score += points;
    }

    public static int getScore() {
        return score;
    }

    public static void reset() {
        score = 0;
    }

    public static void saveHighscore() {
        highscores.add(score);
        highscores.sort(Collections.reverseOrder());
        if (highscores.size() > 5) {
            highscores.remove(5);
        }
    }

    public static ArrayList<Integer> getHighscores() {
        return new ArrayList<>(highscores);
    }

}

