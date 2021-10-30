package instructions;

import contracts.Controller;
import javafx.event.ActionEvent;

public class InstructionsController extends Controller<InstructionsView> {
    public void back(ActionEvent e){
        (getView()).toMenuView();
    }
}
