package game;

import contracts.GameObjectView;
import javafx.scene.layout.Pane;

public class ShipView implements GameObjectView {
    private Pane shipPane;
    private GameController controller;

    public ShipView(Pane shipPane, GameController controller){
        this.shipPane = shipPane;
        this.controller = controller;
    }

    @Override
    public void updateView(double x, double y) {
        controller.getShipPane().setLayoutX(x);
        controller.getShipPane().setLayoutY(y);
    }
}
