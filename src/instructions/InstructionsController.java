package instructions;

import contracts.Controller;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;
import menu.MenuView;

public class InstructionsController extends Controller<InstructionsView> {
    public void back(ActionEvent e){
        (getView()).toMenuView();
    }
}
