package game;

import contracts.Controller;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;


public class GameController extends Controller<GameView> {
    private final Game game = new Game(this);
    @FXML ImageView shipImage;

    public ImageView getShipImage() {
        return shipImage;
    }

    public void renderShip(){
        (getView()).renderShip(game.getShip().getX(), game.getShip().getY());
    }

    public void startGame(){
        game.start();
    }


    public Game getGame() {
        return game;
    }
}
