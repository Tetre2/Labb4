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

    private int pointsLeft;
    private int pointsRight;

    public Pong(Ball ball, Paddle leftPlayer, Paddle rigthPlayer) {
        this.ball = ball;
        this.leftPlayer = leftPlayer;
        this.rigthPlayer = rigthPlayer;
    }


    // --------  Game Logic -------------

    private long timeForLastHit;         // To avoid multiple collisions

    public void update(long now) {
        rigthPlayer.move();
        leftPlayer.move();
      // TODO Most game logic here, i.e. move paddles etc.
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
