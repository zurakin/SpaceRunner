package menu;

import contracts.View;
import instructions.InstructionsLoader;
import game.game.GameLoader;
import javafx.stage.Stage;

public class MenuView  extends View {
    private Stage primaryStage;

    public void play(){
        new GameLoader(primaryStage);
    }

    public void showInstructions(){
        new InstructionsLoader(primaryStage);
    }

    public void showLeaderboard(){
        System.out.println("Leaderboard : First place: Zurakin");
    }

    public void setPrimaryStage(Stage primaryStage){
        this.primaryStage = primaryStage;
    }
}
