package game;

import contracts.Controller;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public class GameController extends Controller<GameView> {
    private final Game game = new Game(this);
    @FXML AnchorPane background;
    @FXML AnchorPane shipPane;
    private ShipView shipView;
    private HashMap<Bullet, BulletView> bulletsTree = new HashMap();

    public AnchorPane getShipPane() {
        return shipPane;
    }

    public AnchorPane getBackground() {
        return background;
    }

    public void renderShip(){
        shipView.updateView(game.getShip().getX(), game.getShip().getY());
    }

    public void renderBullets(){
        for(Map.Entry<Bullet,BulletView> entry : bulletsTree.entrySet()) {
            BulletView bulletView = entry.getValue();
            Bullet bullet = entry.getKey();
            bulletView.updateView(bullet.getX(), bullet.getY());
        }
    }

    public void startGame(){
        game.start();
        shipView = new ShipView(shipPane, this);
    }

    public void addBulletToTree(Bullet b){
        BulletView bv = new BulletView();
        bulletsTree.put(b, bv);
        bv.loadView(background);
    }

    public Game getGame() {
        return game;
    }
}
