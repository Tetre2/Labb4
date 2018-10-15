package pong.model;

public abstract class AbstractMovable extends AbstractPositionable {

    private double dx;
    private double dy;
    private  double speed;

    public AbstractMovable(double x, double y, double dx, double dy, double width, double height, double speed) {
        super(x, y, width, height);
        this.speed = speed;
        this.dx = dx;
        this.dy = dy;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getSpeed() {
        return speed;
    }

    public double getDx() {
        return dx;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public double getDy() {
        return dy;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }
}
