package instructions;

import contracts.ViewLoader;
import javafx.stage.Stage;

public class InstructionsLoader extends ViewLoader<InstructionsView> {
    public InstructionsLoader(Stage primaryStage) {
        super(primaryStage);
    }

    @Override
    public String setTitle() {
        return "SpaceRunner - Instructions";
    }

    @Override
    public String getLoaderLocation() {
        return "instructionsView.fxml";
    }

}
