package pong.model;

import static pong.model.Pong.GAME_HEIGHT;

/*
 * A Paddle for the Pong game
 * A model class
 *
 */
public class Paddle extends AbstractMovable {

    public static final double PADDLE_WIDTH = 10;
    public static final double PADDLE_HEIGHT = 60;
    public static final double PADDLE_SPEED = 5;

    public Paddle(double x, double y, double dx, double dy, double width, double height) {
        super(x, y, dx, dy, width, height, PADDLE_SPEED);
    }

    public Paddle(double x, double y) {
        this(x, y, 0,0 , PADDLE_WIDTH, PADDLE_HEIGHT);
    }

    public void setDir(double d){
        setDy(getSpeed()*d);
    }

    public void move(){
        if(getY() + getDy() > 0 && getY() + getDy() + PADDLE_HEIGHT < Pong.GAME_HEIGHT){
            setY(getY() + getDy());
        }

    }

}
