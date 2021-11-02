package game;

import contracts.Presenter;
import game.Bullet.Bullet;
import game.Bullet.BulletView;
import game.Ship.ShipView;
import game.game.Game;
import game.game.GameView;
import java.util.HashMap;
import java.util.Map;


public class GamePresenter implements Presenter<GameView> {
    private GameView gameView;
    private ShipView shipView;

    private final Game game = new Game(this);
    private HashMap<Bullet, BulletView> bulletsMap = new HashMap();

    public GamePresenter(GameView view) {
        this.gameView = view;
    }

    public void renderShip(){
        shipView.updateView(game.getShip().getX(), game.getShip().getY());
    }

    public void renderBullets(){
        for(Map.Entry<Bullet,BulletView> entry : bulletsMap.entrySet()) {
            BulletView bulletView = entry.getValue();
            Bullet bullet = entry.getKey();
            bulletView.updateView(bullet.getX(), bullet.getY());
        }
    }

    public void startGame(){
        game.start();
        shipView = new ShipView(this);
    }

    public void addBulletToMap(Bullet b){
        BulletView bv = new BulletView();
        bulletsMap.put(b, bv);
        gameView.loadBullet(bv);
    }

    public void updateShipLayout(double x, double y){
        gameView.updateShipLayout(x, y);
    }

    public Game getGame() {
        return game;
    }
}
