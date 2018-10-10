package pong.model;

public class Floor {

    private final double x;
    private final double y;
    private final double width = Pong.GAME_WIDTH;
    private final double height = 50;

    public Floor(double x, double y){
        this.x = x;
        this.y = y;

    }

}
