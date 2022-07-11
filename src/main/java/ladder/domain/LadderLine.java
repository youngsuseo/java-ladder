package ladder.domain;

import ladder.engine.LineCreator;

import java.util.ArrayList;
import java.util.List;

public class LadderLine implements LineCreator {
    private final int countOfLines;
    private final List<Position> positions;

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
        for (int i = 1; i < countOfLines - 1; i++) {
            positions.add(position.next(connectingStrategy.connectable()));
        }
        positions.add(position.last());
    }

    void connectLine(ConnectingStrategy connectingStrategy, int index) {
        if (isFirstOrConnectableLine(index)) {
            lines.add(connectingStrategy.connectable());
            return;
        }
        lines.add(DEFAULT_VALUE);
    }

    private boolean isFirstOrConnectableLine(int index) {
        return index == 0 || !lines.get(index - 1); //-> Direction enum에서 찾아오기
    }


    @Override
    public List<Boolean> getConnectingLines() {
        return null;
    }


}