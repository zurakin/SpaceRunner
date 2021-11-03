package game.game;

import Utils.CustomAnimationTimer;
import game.bullet.Bullet;
import game.GamePresenter;
import game.Ship.Ship;

public class Game {
    private final GamePresenter presenter;
    private Ship ship = new Ship(473, 546, this);
    private BulletsManager bulletsManager;
    private final int animationFPS = 60;
    public static final double width = 1280;
    public static final double height = 720;


    public Game(GamePresenter p) {
        presenter = p;
        bulletsManager = new BulletsManager(this, presenter);
    }

    public void addBullet(Bullet b){
        bulletsManager.addBullet(b);
    }

    public Ship getShip() {
        return ship;
    }

    public void startGameThread() {
        CustomAnimationTimer gameThread = new CustomAnimationTimer(1 / animationFPS) {
            @Override
            public void customHandle(double deltaTime) {
                ship.update(deltaTime);
                bulletsManager.updateBullets(deltaTime);

                presenter.renderShip();
                presenter.renderBullets();
            }
        };
        gameThread.start();
    }
}
