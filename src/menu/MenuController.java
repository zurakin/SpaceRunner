package menu;

import game.GameView;
import instructions.InstructionsView;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class MenuController {
    private Stage primaryStage;

    public void play(){
        new GameView(primaryStage);
    }

    public void showInstructions(){
        new InstructionsView(primaryStage);
    }

    public void showLeaderboard(){
        System.out.println("Leaderboard : First place: Zurakin");
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
}
