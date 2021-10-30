package game;

import contracts.View;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class GameView implements View {
    private GameController controller;
    private ImageView shipImage;

    public GameView(Stage primaryStage) {
        try {
            FXMLLoader loader = getLoader();
            Parent rootNode = loader.load();
            controller = loader.getController();
            passViewToController(loader);
            shipImage = controller.getShipImage();

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

    public void renderShip(double x, double y){
        shipImage.setLayoutX(x);
        shipImage.setLayoutY(y);
    }

    private void setGameControls(Parent root) {
        GameControls gameControls = new GameControls(controller.getGame().getShip());
        root.setOnKeyPressed(gameControls);
        root.setOnKeyReleased(gameControls);
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
