package game;

import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.input.KeyEvent;

public class ShipControls implements EventHandler<KeyEvent> {

    private final boolean[] pressedKeys;

    public ShipControls(Ship ship){
        pressedKeys = ship.getControlsArray();
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        EventType type = keyEvent.getEventType();
        boolean pressed = type == KeyEvent.KEY_PRESSED;
        switch(keyEvent.getCode()){
            case UP:
                pressedKeys[0] = pressed;
                break;
            case DOWN:
                pressedKeys[1] = pressed;
                break;
            case LEFT:
                pressedKeys[2] = pressed;
                break;
            case RIGHT:
                pressedKeys[3] = pressed;
                break;
            case SPACE:
                pressedKeys[4] = pressed;
            default:
                break;
        }
    }
}
