package game.Bullet;

import contracts.GameObject;

public class Bullet implements GameObject {
    private final double x;
    private double y;
    private final double speed = -1500;

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
