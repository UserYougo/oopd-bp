package nl.han.student.HJMPoelen.entities.StaticEntities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.IntConsumer;

/**
 * Global Score
 * Score is intentionally static because it represents a single score per game
 * that must be accessible across multiple scenes (GameScene, WinScene, LostScene) and mutltiple classes
 * without passing references through the entire object graph.
 * This is a deliberate design choice
 * Otherwise we would have to pass ScoreManager through every constructor eg HAN_menace > Gamescreen > Item > Coin
 * This would be a lot of unnecessary
 * We added a reset to it clears between game attempts.
 */


public class ScoreManager {
    private static int score; //Can be private nowhere used directly only with get, add and remove
    private final static ArrayList<Integer> highscores = new ArrayList<>(); //final to prevent making a new list, static because should always be the same across screens
    private static java.util.function.IntConsumer scoreListener;

    public static void setScoreListener(IntConsumer listener) {
        scoreListener = listener;
    }

    public static void addPoints(int points) {
        score += points;
        if (scoreListener != null) scoreListener.accept(score);
    }

    public static void removePoints(int points) {
        if (score - points > 0) {
            score -= points;
        } else {
            score = 0; //so it doesnt go into the negative points.
        }
        if (scoreListener != null) scoreListener.accept(score);
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

    public static List<Integer> getHighscores() {
        return Collections.unmodifiableList(highscores);
    }
}