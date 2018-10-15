package pong.model;

public class Wall extends AbstractPositionable {

    public Wall(double x, double y) {
        super(x, y, Pong.GAME_WIDTH, 20);
    }
}
