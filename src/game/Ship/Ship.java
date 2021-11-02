package game.Ship;

import contracts.GameObject;
import game.Bullet.Bullet;
import game.game.Game;

public class Ship implements GameObject {
    private double x;
    private double y;
    private final double vx = 500;
    private final double vy = 500;
    private final boolean[] controlsArr = new boolean[5];
    private double shootingTimeout = 0;
    private final double shootingTimeoutValue = .2;
    private Game game;

    public Ship(double x, double y, Game game) {
        this.x = x;
        this.y = y;
        this.game = game;
    }

    public boolean[] getControlsArray() {
        return controlsArr;
    }

    @Override
    public void update(double deltaTime){
        updateShootingTimeout(deltaTime);
        if (controlsArr[4]){
            shoot();
        }
        x += getDX(deltaTime);
        y += getDY(deltaTime);
    }

    private double getDX(double deltaTime){
        int dirX = ((controlsArr[3]) ? 1 : 0) + ((controlsArr[2]) ? -1 : 0);
        return dirX * vx * deltaTime;
    }

    private double getDY(double deltaTime){
        int dirY = ((controlsArr[1]) ? 1 : 0) + ((controlsArr[0]) ? -1 : 0);
        return dirY * vy * deltaTime;
    }

    private void updateShootingTimeout(double deltaTime) {
        shootingTimeout -= deltaTime;
    }

    public void shoot(){
        if (shootingTimeout < 0) {
            System.out.println("pew");
            Bullet b = new Bullet(x+21, y-40);
            game.createBullet(b);
            shootingTimeout = shootingTimeoutValue;
        }
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
