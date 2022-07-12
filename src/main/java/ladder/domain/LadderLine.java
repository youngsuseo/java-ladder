package ladder.domain;

import ladder.engine.LineCreator;

import java.util.ArrayList;
import java.util.List;

public class LadderLine implements LineCreator {
    private final int countOfLines;
    private final List<Position> positions;

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
        Position position = Position.first(connectingStrategy.connectable());
        positions.add(position);
        for (int i = 1; i < countOfLines; i++) { // FIXME 변경
           position = position.next(connectingStrategy);
           positions.add(position);
        }
        positions.add(position.last());
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
}