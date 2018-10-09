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
    private int directionX;
    private int directionY;
    private float velocityX;
    private float velocityY;
    private double x;
    private double y;

    public Ball(double speed, double x, double y) {
        this.speed = speed;
        this.x = x;
        this.y = y;
    }


    private void isColliding(){

    }

    public void incSpeed(){

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
