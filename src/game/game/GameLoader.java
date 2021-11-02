package game.game;

import contracts.ViewLoader;
import javafx.stage.Stage;

public class GameLoader extends ViewLoader<GameView> {
    public GameLoader(Stage primaryStage) {
        super(primaryStage);
        getView().setGameControls();
    }

    @Override
    public String setTitle() {
        return "SpaceRunner - Game";
    }

    @Override
    public String getLoaderLocation() {
        return "gameView.fxml";
    }

}
