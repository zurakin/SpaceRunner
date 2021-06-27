package application;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import menu.MenuView;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        initializePrimaryStage(primaryStage);
        new MenuView(primaryStage);
    }

    private void initializePrimaryStage(Stage primaryStage) {
        primaryStage.setOnCloseRequest(event->{
            System.exit(0);
        });
        Scene scene = new Scene(new AnchorPane(), 1280, 720);

        setFullScreenToggleButton(primaryStage, scene);

        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);

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
