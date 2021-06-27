package menu;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuView {
    public MenuView(Stage primaryStage) {
        try {
            FXMLLoader loader = getLoader();
            Parent root  = loader.load();

            passParametersToController(primaryStage, loader);

            changeTitle(primaryStage);
            Scene scene = primaryStage.getScene();
            scene.setRoot(root);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void changeTitle(Stage primaryStage) {
        primaryStage.setTitle("SpaceRunner - main menu");
    }

    private void passParametersToController(Stage primaryStage, FXMLLoader loader) {
        ((MenuController) loader.getController()).setPrimaryStage(primaryStage);
    }

    private FXMLLoader getLoader() {
        return new FXMLLoader(getClass().getResource("menuView.fxml"));
    }
}
