package pong.model;

import static pong.model.Pong.GAME_HEIGHT;

/*
 * A Paddle for the Pong game
 * A model class
 *
 */
public class Paddle implements IPositionable {

    public static final double PADDLE_WIDTH = 10;
    public static final double PADDLE_HEIGHT = 60;
    public static final double PADDLE_SPEED = 5;
    private double velocity;
    private final double x;
    private double y;

    public Paddle(double x, double y) {
        this.x = x;
        this.y = y;
    }



    public void setSpeed(double d){
        velocity = PADDLE_SPEED*d;
    }

    public void move(){
        y += velocity;
    }


    private void colliding(){

    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public double getWidth() {
        return PADDLE_WIDTH;
    }

    @Override
    public double getHeight() {
        return PADDLE_HEIGHT;
    }
}
