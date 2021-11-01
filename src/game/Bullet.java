package game;

import contracts.GameObject;

public class Bullet implements GameObject {
    private final double x;
    private double y;
    private final double speed = -600;

    public Bullet(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void update(double deltaTime){
        y += deltaTime * speed;
    }

}
