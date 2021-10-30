package instructions;

import contracts.View;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import menu.MenuView;

import java.io.IOException;

public class InstructionsView implements View {

    private Stage primaryStage;

    public InstructionsView(Stage primaryStage) {
        try {
            this.primaryStage = primaryStage;
            FXMLLoader loader = getLoader();
            Parent root = loader.load();

            Scene scene = primaryStage.getScene();
            scene.setRoot(root);

            passViewToController(loader);

            changeStageTitle(primaryStage);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void changeStageTitle(Stage primaryStage) {
        primaryStage.setTitle("SpaceRunner - instructions");
    }

    private void passViewToController(FXMLLoader loader) {
        ((InstructionsController) loader.getController()).setView(this);
    }

    private FXMLLoader getLoader() {
        return new FXMLLoader(getClass().getResource("instructionsView.fxml"));
    }

    public void toMenuView(){
        new MenuView(primaryStage);
    }
}
