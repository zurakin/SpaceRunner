package game.bullet;

import contracts.GameObject;

public class Bullet implements GameObject {
    private final double x;
    private double y;
    public static final double speed = -1500;
    public static double dy;

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
        y += dy;
    }

}
