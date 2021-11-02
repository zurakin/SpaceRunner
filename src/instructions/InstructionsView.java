package instructions;

import contracts.View;
import javafx.event.ActionEvent;
import menu.MenuLoader;

public class InstructionsView extends View {
    public void back(ActionEvent e){
        new MenuLoader(getPrimaryStage());
    }
}
