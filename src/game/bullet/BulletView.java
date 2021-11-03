package game.bullet;

import contracts.GameObjectView;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class BulletView implements GameObjectView {
    private Pane bulletPane;

    public BulletView(){
        loadBulletImage();
    }

    private void loadBulletImage(){
        try {
            bulletPane = new FXMLLoader(getClass().getResource("bulletView.fxml")).load();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public Pane getBulletPane() {
        return bulletPane;
    }

    @Override
    public void updateView(double x, double y) {
        bulletPane.setLayoutX(x);
        bulletPane.setLayoutY(y);
    }

}
