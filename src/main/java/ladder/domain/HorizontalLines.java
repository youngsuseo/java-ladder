package ladder.domain;

import ladder.engine.LineCreator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HorizontalLines implements LineCreator {
    private static final boolean DEFAULT_VALUE = false;

    private final int countOfLines;
    private final List<Boolean> horizontalLines;

    public HorizontalLines(int countOfLines) {
        this(countOfLines, new ArrayList<>());
    }

    public HorizontalLines(int countOfLines, ConnectingStrategy connectingStrategy) {
        this(countOfLines, new ArrayList<>());
        connect(connectingStrategy);
    }

    public HorizontalLines(int countOfLines, List<Boolean> horizontalLines) {
        this.countOfLines = countOfLines;
        this.horizontalLines = horizontalLines;
    }

    @Override
    public void connect(ConnectingStrategy connectingStrategy) {
        for (int i = 0; i < countOfLines; i++) {
            connectLine(connectingStrategy, i);
        }
    }

    private void connectLine(ConnectingStrategy connectingStrategy, int index) {
        if (isFirstOrConnectableLine(index)) {
            horizontalLines.add(connectingStrategy.connectable());
            return;
        }
        horizontalLines.add(DEFAULT_VALUE);
    }

    private boolean isFirstOrConnectableLine(int index) {
        return index == 0 || !horizontalLines.get(index - 1);
    }

    public List<Boolean> getHorizontalLines() {
        return Collections.unmodifiableList(horizontalLines);
    }
}
