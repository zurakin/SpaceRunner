package game.Bullet;

import contracts.GameObjectView;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class BulletView implements GameObjectView {
    private Pane bulletImage;

    public BulletView(){
        loadBulletImage();
    }

    private void loadBulletImage(){
        try {
            bulletImage = new FXMLLoader(getClass().getResource("bulletView.fxml")).load();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public Pane getBulletImage() {
        return bulletImage;
    }

    @Override
    public void updateView(double x, double y) {
        bulletImage.setLayoutX(x);
        bulletImage.setLayoutY(y);
    }

}
