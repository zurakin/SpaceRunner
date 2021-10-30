package menu;

import contracts.View;
import game.GameView;
import instructions.InstructionsView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuView implements View {
    Stage primaryStage;

    public MenuView(Stage primaryStage) {
        try {
            this.primaryStage = primaryStage;
            FXMLLoader loader = getLoader();
            Parent root  = loader.load();

            passViewToController(loader);

            changeTitle(primaryStage);
            Scene scene = primaryStage.getScene();
            scene.setRoot(root);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void changeTitle(Stage primaryStage) {
        primaryStage.setTitle("SpaceRunner - main menu");
    }

    private void passViewToController(FXMLLoader loader) {
        ((MenuController) loader.getController()).setView(this);
    }

    private FXMLLoader getLoader() {
        return new FXMLLoader(getClass().getResource("menuView.fxml"));
    }

    public void toGameView(){
        new GameView(primaryStage);
    }

    public void toInstructionsView(){
        new InstructionsView(primaryStage);
    }

    public void toLeaderBoardView(){
        System.out.println("Leaderboard : First place: Zurakin");
    }
}
