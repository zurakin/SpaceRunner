package instructions;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class InstructionsView {
    public InstructionsView(Stage primaryStage) {
        try {
            FXMLLoader loader = getLoader();
            Parent root = loader.load();

            root.setOnKeyPressed(keyEvent -> System.out.println(keyEvent.getCode()));

            Scene scene = primaryStage.getScene();
            scene.setRoot(root);

            passParametersToController(primaryStage, loader);;

            changeStageTitle(primaryStage);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void changeStageTitle(Stage primaryStage) {
        primaryStage.setTitle("SpaceRunner - instructions");
    }

    private void passParametersToController(Stage primaryStage, FXMLLoader loader) {
        ((InstructionsController) loader.getController()).setPrimaryStage(primaryStage);
    }

    private FXMLLoader getLoader() {
        return new FXMLLoader(getClass().getResource("instructionsView.fxml"));
    }

}
