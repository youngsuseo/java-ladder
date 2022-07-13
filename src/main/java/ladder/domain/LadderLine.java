package ladder.domain;

import ladder.engine.LineCreator;

import java.util.ArrayList;
import java.util.List;

public class LadderLine implements LineCreator {
    private final int countOfLines;
    private final List<Position> positions; // FIXME 일급컬렉션

    public LadderLine(int countOfLines) {
        this(countOfLines, new ArrayList<>());
    }

    LadderLine(int countOfLines, ConnectingStrategy connectingStrategy) {
        this(countOfLines, new ArrayList<>());
        connect(connectingStrategy);
    }

    public LadderLine(int countOfLines, List<Position> positions) {
        this.countOfLines = countOfLines;
        this.positions = positions;
    }

    public int move(int positionIndex) {
        return positions.get(positionIndex).move();
    }

    @Override
    public void connect(ConnectingStrategy connectingStrategy) {
        Position position = initFirst(connectingStrategy);
        position = getPosition(connectingStrategy, position);
        positions.add(position.last());
    }

    private Position initFirst(ConnectingStrategy connectingStrategy) {
        Position position = Position.first(connectingStrategy.connectable());
        positions.add(position);
        return position;
    }

    private Position getPosition(ConnectingStrategy connectingStrategy, Position position) {
        for (int i = 1; i < countOfLines - 1; i++) { // FIXME 변경
           position = position.next(connectingStrategy);
           positions.add(position);
        }
        return position;
    }

    @Override
    public List<Boolean> getConnectingLines() {
        List<Boolean> lines = new ArrayList<>();
        for (Position position : positions) {
            lines.add(position.movable());
        }
        lines.remove(lines.size() - 1);
        return lines;
    }

    public List<Position> getPositions() {
        return positions;
    }
}