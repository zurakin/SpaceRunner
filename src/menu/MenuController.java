package menu;

import contracts.Controller;
import game.GameView;
import instructions.InstructionsView;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class MenuController extends Controller<MenuView> {
    public void play(){
        ((MenuView)getView()).toGameView();
    }

    public void showInstructions(){
        ((MenuView)getView()).toInstructionsView();
    }

    public void showLeaderboard(){
        ((MenuView)getView()).toLeaderBoardView();
    }
}
