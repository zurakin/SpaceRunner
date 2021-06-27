package game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import menu.MenuView;


public class GameController {

    private Ship ship;
    private Stage primaryStage;
    @FXML ImageView shipImage;

    public void back(ActionEvent e){
        new MenuView(primaryStage);
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void setShip(Ship ship){
        this.ship = ship;
    }

    public void render(double deltaTime){
        ship.update(deltaTime);
        shipImage.setLayoutX(ship.getX());
        shipImage.setLayoutY(ship.getY());
    }

    public void temp(){
        System.out.println(shipImage.getLayoutX());
        shipImage.setLayoutX(100);
        shipImage.setLayoutY(100);
    }
}
