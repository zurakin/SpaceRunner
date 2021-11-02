package game.Ship;

import contracts.GameObjectView;
import game.GamePresenter;
import game.game.GameView;
import javafx.scene.layout.Pane;

public class ShipView implements GameObjectView {
    private GamePresenter presenter;

    public ShipView(GamePresenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void updateView(double x, double y) {
        presenter.updateShipLayout(x, y);
    }
}
