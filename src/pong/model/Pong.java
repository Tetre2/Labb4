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
    private List<Wall> walls;

    private int pointsLeft;
    private int pointsRight;

    public Pong(Ball ball, Paddle leftPlayer, Paddle rightPaddle, List<Wall> walls) {
        this.walls = walls;
        this.ball = ball;
        this.leftPlayer = leftPlayer;
        this.rigthPlayer = rightPaddle;
    }


    // --------  Game Logic -------------

    private long timeForLastHit = 0;         // To avoid multiple collisions

    public void update(long now) {
        ball.move();
        leftPlayer.move();
        rigthPlayer.move();
        if (ball.isOutOfBounds()) {
            addPoints();
            ball = new Ball(GAME_WIDTH / 2, GAME_HEIGHT / 2, 5);
        }
        for (Wall w : walls) {
            if (ball.intersect(w)) {
                ball.setDy(-ball.getDy());
            }
        }

        if(now - timeForLastHit > HALF_SEC){
            if (ball.intersect(leftPlayer) || ball.intersect(rigthPlayer)) {
                timeForLastHit = now;
                ball.setDx(-ball.getDx());
                ball.incSpeed();
            }
        }

        // TODO Most game logic here, i.e. move paddles etc.
    }

    private void addPoints() {
        if (ball.getX() < GAME_WIDTH / 2) {
            pointsRight++;
        } else {
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

    public void setDirRightPaddle(double dy) {
        rigthPlayer.setDir(dy);
    }

    public void setDirLeftPaddle(double dy) {
        leftPlayer.setDir(dy);
    }
}
