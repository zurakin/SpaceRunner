package game.game;

import game.GamePresenter;
import game.bullet.Bullet;
import java.util.ArrayList;

public class BulletsManager {
    private ArrayList<Bullet> activeBullets = new ArrayList<>();
    private ArrayList<Bullet> queuedBulletsForDeletion = new ArrayList<>();
    private Game game;
    private GamePresenter presenter;

    public BulletsManager(Game game, GamePresenter presenter) {
        this.game = game;
        this.presenter = presenter;
    }

    public void queueBulletForDeletion(Bullet b) {
        queuedBulletsForDeletion.add(b);
    }

    public void deleteQueuedBullets() {
        for (Bullet b : queuedBulletsForDeletion) {
            activeBullets.remove(b);
            presenter.deleteBulletView(b);
        }
        queuedBulletsForDeletion.clear();
    }
    public void addBullet(Bullet b) {
        activeBullets.add(b);
        presenter.createBulletView(b);
    }

    public void updateBullets(double deltaTime){
        Bullet.dy = deltaTime * Bullet.speed;
        for (Bullet b : activeBullets) {
            b.update(deltaTime);
            if (b.getY() < -40) {
                queueBulletForDeletion(b);
            }
        }
        deleteQueuedBullets();
    }
}
