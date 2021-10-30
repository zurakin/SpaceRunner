package menu;

import contracts.Controller;

public class MenuController extends Controller<MenuView> {
    public void play(){
        getView().toGameView();
    }

    public void showInstructions(){
        getView().toInstructionsView();
    }

    public void showLeaderboard(){
        getView().toLeaderBoardView();
    }
}
