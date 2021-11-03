package Utils;
import javafx.animation.AnimationTimer;

public abstract class CustomAnimationTimer extends AnimationTimer {

    private long sleepNs = 0;

    long prevTime = 0;

    public CustomAnimationTimer(long sleepMs) {
        this.sleepNs = sleepMs * 1_000_000;
    }
    private double deltaTime;
    private double pastTick = 0;

    private void updateDeltaTime(long currentTimeMillis) {
        if (pastTick == 0) {
            pastTick = currentTimeMillis;
            deltaTime = 0;
            return;
        }
        deltaTime = (currentTimeMillis - pastTick) / 1e9;
        pastTick = currentTimeMillis;
    }
    @Override
    public void handle(long now) {

        if ((now - prevTime) < sleepNs) {
            return;
        }
        updateDeltaTime(now);
        prevTime = now;

        customHandle(deltaTime);
    }

    public abstract void customHandle(double deltaTime);

}