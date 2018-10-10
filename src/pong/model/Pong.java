package pong.model;


import pong.event.Event;
import pong.event.EventService;

import java.util.ArrayList;
import java.util.List;

/*
 * Logic for the Pong Game
 * Model class representing the "whole" game
 * Nothing visual here
 *
 */
public class Pong {

    public static final double GAME_WIDTH = 600;
    public static final double GAME_HEIGHT = 400;
    public static final double BALL_SPEED_FACTOR = 1.02;
    public static final long HALF_SEC = 500_000_000;
    private Ball ball;
    private Paddle leftPlayer;
    private Paddle rigthPlayer;
    private Floor floor;
    private Ceiling ceiling;

    private int pointsLeft;
    private int pointsRight;

    public Pong(Ball ball, Paddle leftPlayer, Paddle rightPaddle, Floor floor, Ceiling ceiling) {
        this.ball = ball;
        this.leftPlayer = leftPlayer;
        this.rigthPlayer = rightPaddle;
        this.floor = floor;
        this.ceiling = ceiling;
    }


    // --------  Game Logic -------------

    private long timeForLastHit;         // To avoid multiple collisions

    public void update(long now) {
        rigthPlayer.move();
        leftPlayer.move();
        ball.move();
        if(ball.isOutOfBounds()){
            addPoints();
            ball = new Ball( GAME_WIDTH/2, GAME_HEIGHT/2);
        }
      // TODO Most game logic here, i.e. move paddles etc.
    }

    private void addPoints(){
        if(ball.getX() < GAME_WIDTH / 2){
            pointsRight++;
        }else {
            pointsLeft++;
        }
    }



    // --- Used by GUI  ------------------------

    public List<IPositionable> getPositionables() {
        List<IPositionable> drawables = new ArrayList<>();
        drawables.add(ball);
        drawables.add(rigthPlayer);
        drawables.add(leftPlayer);

        return drawables;
    }

    public int getPointsLeft() {
        return pointsLeft;
    }

    public int getPointsRight() {
        return pointsRight;
    }

    public void setSpeedRightPaddle(double dy) {
        rigthPlayer.setSpeed(dy);
    }

    public void setSpeedLeftPaddle(double dy) {
        leftPlayer.setSpeed(dy);
    }
}
