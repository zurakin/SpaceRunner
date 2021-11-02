package game.game;

import contracts.View;
import game.Bullet.BulletView;
import game.GamePresenter;
import game.Ship.ShipControls;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GameView implements View {
    private GamePresenter presenter = new GamePresenter(this);
    private GameController controller;


    public GameView(Stage primaryStage) {
        try {
            FXMLLoader loader = getLoader();
            Parent rootNode = loader.load();
            controller = loader.getController();
            passViewToController(loader);

            setGameControls(rootNode);

            Scene scene = primaryStage.getScene();
            scene.setRoot(rootNode);

            presenter.startGame();

            changeStageTitle(primaryStage);

            rootNode.requestFocus();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateShipLayout(double x, double y){
        controller.getShipPane().setLayoutX(x);
        controller.getShipPane().setLayoutY(y);
    }

    private void setGameControls(Parent root) {
        ShipControls shipControls = new ShipControls(presenter.getGame().getShip());
        root.setOnKeyPressed(shipControls);
        root.setOnKeyReleased(shipControls);
    }

    private void changeStageTitle(Stage primaryStage) {
        primaryStage.setTitle("SpaceRunner - Game");
    }

    private void passViewToController(FXMLLoader loader) {
        controller = loader.getController();
        controller.setView(this);
    }

    public void loadBullet(BulletView bv){
        controller.getBackground().getChildren().add(bv.getBulletImage());
    }

    private FXMLLoader getLoader() {
        return new FXMLLoader(getClass().getResource("gameView.fxml"));
    }

}
