package pong.model;

import java.util.Random;

import static pong.model.Pong.GAME_HEIGHT;
import static pong.model.Pong.GAME_WIDTH;

/*
 * A Ball for the Pong game
 * A model class
 */
public class Ball extends AbstractMovable {

    public static final double WIDTH = 40;
    public static final double HEIGHT = 40;

    public Ball(double x, double y, double dx, double dy, double width, double height, double speed) {
        super(x, y, dx, dy, width, height, speed);

        Random r = new Random();
        setDx(((r.nextDouble()*2) - 1));
        setDy(((r.nextDouble()*2) - 1));

    }

    public Ball(double x, double y, double speed) {
        this(x, y, 0,0 , WIDTH, HEIGHT, speed);
    }


    public boolean isOutOfBounds() {
        return getX() < - WIDTH * 1.5 ||
                getX() > GAME_WIDTH + WIDTH * 0.5;
    }

    public void move() {
        setY(getY() + getDy() * getSpeed());
        setX(getX() + getDx() * getSpeed());
    }

    public void incSpeed() {
        setSpeed(getSpeed() * 1.05);
    }


}
