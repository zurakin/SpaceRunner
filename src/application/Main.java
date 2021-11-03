package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import menu.MenuLoader;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage){
        initializePrimaryStage(primaryStage);
        new MenuLoader(primaryStage).load();
    }

    private void initializePrimaryStage(Stage primaryStage) {
        primaryStage.setOnCloseRequest(event->{
            System.exit(0);
        });
        Scene scene = new Scene(new AnchorPane(), 1280, 720);

        setFullScreenToggleButton(primaryStage, scene);

        primaryStage.setScene(scene);
        primaryStage.setFullScreen(false);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private void setFullScreenToggleButton(Stage primaryStage, Scene scene) {
        scene.setOnKeyPressed((keyEvent) -> {
            if (keyEvent.getCode() == KeyCode.F11){
                primaryStage.setFullScreen(!primaryStage.isFullScreen());
            }
        });
        primaryStage.setFullScreenExitHint("Press F11 to toggle full screen");
        primaryStage.setFullScreenExitKeyCombination(new KeyCodeCombination(KeyCode.ESCAPE));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
