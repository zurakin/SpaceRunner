package game;

public class Ship {
    private double x;
    private double y;
    private final double vx = 500;
    private final double vy = 500;
    private boolean[] controlsArr = new boolean[5];
    private double shootingTimeout = 0;

    public Ship(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public boolean[] getControlsArray() {
        return controlsArr;
    }

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
            shootingTimeout = 0.5;
        }
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
