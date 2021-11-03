package game.game;

import contracts.View;
import game.Bullet.BulletView;
import game.GamePresenter;
import game.Ship.ShipControls;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class GameView extends View {
    private @FXML AnchorPane background;
    private @FXML AnchorPane shipPane;
    private GamePresenter presenter = new GamePresenter(this);

    public void updateShipLayout(double x, double y){
        shipPane.setLayoutX(x);
        shipPane.setLayoutY(y);
    }

    public void deleteBulletView(BulletView bv){
        background.getChildren().remove(bv.getBulletPane());
    }
    public void setGameControls() {
        ShipControls shipControls = new ShipControls(presenter.getGame().getShip());
        background.setOnKeyPressed(shipControls);
        background.setOnKeyReleased(shipControls);
    }

    public void loadBullet(BulletView bv){
        background.getChildren().add(bv.getBulletPane());
    }
}
