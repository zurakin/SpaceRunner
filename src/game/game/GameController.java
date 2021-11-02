package game.game;

import contracts.Controller;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class GameController extends Controller<GameView> {
    private @FXML AnchorPane background;
    private @FXML AnchorPane shipPane;

    public AnchorPane getShipPane() {
        return shipPane;
    }

    public AnchorPane getBackground() {
        return background;
    }
}
