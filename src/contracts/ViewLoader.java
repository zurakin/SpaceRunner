package contracts;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class ViewLoader<ViewT extends View> {
    private ViewT view;
    public  ViewT load(){
        return view;
    }

    public abstract String setTitle();
    public abstract String getLoaderLocation();

    public ViewT getView() {
        return view;
    }

    public ViewLoader(Stage primaryStage){
        FXMLLoader loader = getLoader();
        Parent root  = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        changeTitle(primaryStage);

        Scene scene = primaryStage.getScene();
        scene.setRoot(root);

        view = loader.getController();
        view.setPrimaryStage(primaryStage);

        root.requestFocus();
    }

    private void changeTitle(Stage primaryStage) {
        primaryStage.setTitle(setTitle());
    }
    private FXMLLoader getLoader() {
        return new FXMLLoader(getClass().getResource(getLoaderLocation()));
    }
}
