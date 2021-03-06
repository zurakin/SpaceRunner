package game;

import contracts.Presenter;
import game.bullet.Bullet;
import game.bullet.BulletView;
import game.game.Game;
import game.game.GameView;
import java.util.HashMap;
import java.util.Map;


public class GamePresenter implements Presenter<GameView> {
    private final GameView gameView;
    private final Game game = new Game(this);

    private final HashMap<Bullet, BulletView> bulletsMap = new HashMap();

    public GamePresenter(GameView view) {
        this.gameView = view;
        startGame();
    }

    public void deleteBulletView(Bullet b){
        gameView.deleteBulletView(bulletsMap.get(b));
        bulletsMap.remove(b);
    }

    public void renderShip(){
        gameView.updateShipLayout(game.getShip().getX(), game.getShip().getY());
    }

    public void renderBullets(){
        for(Map.Entry<Bullet,BulletView> entry : bulletsMap.entrySet()) {
            BulletView bulletView = entry.getValue();
            Bullet bullet = entry.getKey();
            bulletView.updateView(bullet.getX(), bullet.getY());
        }
    }

    public void startGame(){
        game.startGameThread();
    }

    public void createBulletView(Bullet b){
        BulletView bv = new BulletView();
        bulletsMap.put(b, bv);
        gameView.loadBullet(bv);
    }

    public Game getGame() {
        return game;
    }
}
