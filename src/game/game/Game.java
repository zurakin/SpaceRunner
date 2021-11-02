package game.game;

import Utils.CustomAnimationTimer;
import game.Bullet.Bullet;
import game.GamePresenter;
import game.Ship.Ship;
import javafx.animation.AnimationTimer;

import java.util.ArrayList;

public class Game {
    private final GamePresenter presenter;
    private double deltaTime;
    private double pastTick = 0;
    private Ship ship = new Ship(473, 546, this);
    private ArrayList<Bullet> activeBullets = new ArrayList<>();
    private final int animationFPS = 60;


    public Game(GamePresenter p){
        presenter = p;
    }

    public Ship getShip() {
        return ship;
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

    public void startGameThread(){
        CustomAnimationTimer gameThread = new CustomAnimationTimer(1/animationFPS)
        {
            @Override
            public void customHandle( long now )
            {
                if (now - pastTick < 16_000_000){
                    return;
                }
                updateDeltaTime(now);
                ship.update(deltaTime);
                for (Bullet b: activeBullets){
                    b.update(deltaTime);
                }
                presenter.renderShip();
                presenter.renderBullets();
            }
        };
        gameThread.start();
    }

    public void createBullet(Bullet b){
        activeBullets.add(b);
        presenter.addBulletToMap(b);
    }
}
