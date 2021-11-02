package menu;

import contracts.ViewLoader;
import javafx.stage.Stage;


public class MenuLoader extends ViewLoader<MenuView> {
    public MenuLoader(Stage primaryStage) {
        super(primaryStage);
    }

    @Override
    public String setTitle() {
        return "SpaceRunner - main menu";
    }

    @Override
    public String getLoaderLocation() {
        return "menuView.fxml";
    }
}
