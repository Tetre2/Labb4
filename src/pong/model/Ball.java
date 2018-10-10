package pong.model;

import java.util.Random;

import static pong.model.Pong.GAME_HEIGHT;
import static pong.model.Pong.GAME_WIDTH;

/*
 * A Ball for the Pong game
 * A model class
 */
public class Ball implements IPositionable {

    public static final double WIDTH = 40;
    public static final double HEIGT = 40;
    private double speed;
    private double directionX;
    private double directionY;


    private double x;
    private double y;


    public Ball(double x, double y) {
        Random r = new Random();

        this.speed = (r.nextDouble() * 2) + 1;
        this.x = x;
        this.y = y;


        this.directionX = (r.nextDouble()*2) - 1;
        this.directionY = (r.nextDouble()*2) - 1;


    }


    private void isColliding() {

    }

    public boolean isOutOfBounds() {
        return x < - WIDTH * 1.5 ||
               x > GAME_WIDTH + WIDTH * 0.5;
    }

    public void move() {
        y += directionY * speed;
        x += directionX * speed;
    }

    public void incSpeed() {

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
        return WIDTH;
    }

    @Override
    public double getHeight() {
        return HEIGT;
    }
}
