package game;

public class Ship {
    private double x;
    private double y;
    private final double vx = 500;
    private final double vy = 500;
    private boolean[] controls = new boolean[5];
    private double shootingTimeout = 0;

    public Ship(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public boolean[] getControls() {
        return controls;
    }

    public void update(double deltaTime){
        updateShootingTimeout(deltaTime);
        if (controls[4]){
            shoot();
        }
        x += getDX(deltaTime);
        y += getDY(deltaTime);
    }

    private double getDX(double deltaTime){
        int dirX = ((controls[3]) ? 1 : 0) + ((controls[2]) ? -1 : 0);
        return dirX * vx * deltaTime;
    }

    private double getDY(double deltaTime){
        int dirY = ((controls[1]) ? 1 : 0) + ((controls[0]) ? -1 : 0);
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
