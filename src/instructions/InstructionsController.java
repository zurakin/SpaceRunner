package instructions;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;
import menu.MenuView;

public class InstructionsController {

    private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void back(ActionEvent e){
        Stage primaryStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        new MenuView(primaryStage);
    }
}
