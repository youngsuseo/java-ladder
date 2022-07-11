package ladder.domain;

public class Position {
    private int index;
    private Point point;

    private Position(int index, Point point) {
        this.index = index;
        this.point = point;
    }

    public static Position first(boolean right) {
        return new Position(0, Point.first(right));
    }

    public int move() {
        switch (point.move()) {
            case LEFT : return --index;
            case RIGHT: return ++index;
            case PASS : return index;
            default   : return index; // TODO
        }
    }

    public Position next(boolean right) {
        return new Position(++index, point.next(right));
    }

    public Position last() {
        return new Position(++index, point.last());
    }
}
