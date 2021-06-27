package game;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GameView {
    private final Ship ship = new Ship(473, 546);
    private double deltaTime;
    private double pastTick = 0;
    private GameController controller;

    public GameView(Stage primaryStage) {
        try {
            FXMLLoader loader = getLoader();
            Parent root = loader.load();

            setGameControls(root);

            Scene scene = primaryStage.getScene();
            scene.setRoot(root);

            passParametersToController(primaryStage, loader);

            startGameThread();

            changeStageTitle(primaryStage);

            root.requestFocus();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setGameControls(Parent root) {
        GameControls gameControls = new GameControls(ship);
        root.setOnKeyPressed(gameControls);
        root.setOnKeyReleased(gameControls);
    }

    private void changeStageTitle(Stage primaryStage) {
        primaryStage.setTitle("SpaceRunner - Game");
    }

    private void passParametersToController(Stage primaryStage, FXMLLoader loader) {
        controller = loader.getController();
        controller.setPrimaryStage(primaryStage);
        controller.setShip(ship);
    }

    private FXMLLoader getLoader() {
        return new FXMLLoader(getClass().getResource("gameView.fxml"));
    }

    public void startGameThread(){
        AnimationTimer gameThread = new AnimationTimer()
        {

            @Override
            public void handle( long now )
            {
                updateDeltaTime(now);
                controller.render(deltaTime);
            }
        };
        gameThread.start();
    }


    private void updateDeltaTime(long currentTimeMillis) {
        if (pastTick == 0){
            pastTick = currentTimeMillis;
            deltaTime = 0;
            return;
        }
        deltaTime = (double) ((currentTimeMillis - pastTick) / 1e9);
        pastTick = currentTimeMillis;
    }
}
