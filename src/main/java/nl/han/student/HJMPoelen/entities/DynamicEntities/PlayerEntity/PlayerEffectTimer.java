package nl.han.student.HJMPoelen.entities.DynamicEntities.PlayerEntity;

import com.github.hanyaeger.api.Timer;

public class PlayerEffectTimer extends Timer {

    private final Player player;

    public PlayerEffectTimer(Player player) {
        super(50);
        this.player = player;
    }

    @Override
    public void onAnimationUpdate(long timestamp) {
        player.updateEffects();
    }
}
