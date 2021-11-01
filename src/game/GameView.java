package game;

import contracts.View;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GameView implements View {
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

            controller.startGame();

            changeStageTitle(primaryStage);

            rootNode.requestFocus();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setGameControls(Parent root) {
        ShipControls shipControls = new ShipControls(controller.getGame().getShip());
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

    private FXMLLoader getLoader() {
        return new FXMLLoader(getClass().getResource("gameView.fxml"));
    }

}
