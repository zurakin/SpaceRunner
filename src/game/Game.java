package game;

import javafx.animation.AnimationTimer;

public class Game {
    private final GameController controller;
    private double deltaTime;
    private double pastTick = 0;
    Ship ship = new Ship(473, 546);

    public Game(GameController c){
        controller = c;
    }

    public Ship getShip() {
        return ship;
    }

    public void startGameThread(){
        AnimationTimer gameThread = new AnimationTimer()
        {

            @Override
            public void handle( long now )
            {
                updateDeltaTime(now);
                ship.update(deltaTime);
                controller.renderShip();
            }
        };
        gameThread.start();
    }


    private void updateDeltaTime(long currentTimeMillis) {
        if (pastTick == 0){
            pastTick = currentTimeMillis;
            deltaTime = 0;
            return;
        }
        deltaTime = (currentTimeMillis - pastTick) / 1e9;
        pastTick = currentTimeMillis;
    }

    public void start(){
        startGameThread();
    }
}
