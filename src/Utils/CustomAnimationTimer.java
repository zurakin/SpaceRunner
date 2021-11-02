package Utils;
import javafx.animation.AnimationTimer;

public abstract class CustomAnimationTimer extends AnimationTimer {

    private long sleepNs = 0;

    long prevTime = 0;

    public CustomAnimationTimer(long sleepMs) {
        this.sleepNs = sleepMs * 1_000_000;
    }

    @Override
    public void handle(long now) {

        if ((now - prevTime) < sleepNs) {
            return;
        }

        prevTime = now;

        customHandle(now);
    }

    public abstract void customHandle(long now);

}