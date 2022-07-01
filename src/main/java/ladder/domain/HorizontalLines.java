package ladder.domain;

// FIXME engine 이라는 이름
import ladder.engine.LineCreator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HorizontalLines implements LineCreator {
    private static final boolean DEFAULT_VALUE = false;

    private final int countOfLines;
    private final List<Boolean> connectingLines; // FIXME 일급 컬렉션

    public HorizontalLines(int countOfLines) {
        this(countOfLines, new ArrayList<>());
    }

    HorizontalLines(int countOfLines, ConnectingStrategy connectingStrategy) {
        this(countOfLines, new ArrayList<>());
        connect(connectingStrategy);
    }

    private HorizontalLines(int countOfLines, List<Boolean> connectingLines) {
        this.countOfLines = countOfLines;
        this.connectingLines = connectingLines;
    }

    @Override
    public void connect(ConnectingStrategy connectingStrategy) {
        for (int i = 0; i < countOfLines; i++) {
            connectLine(connectingStrategy, i);
        }
    }

    private void connectLine(ConnectingStrategy connectingStrategy, int index) {
        if (isFirstOrConnectableLine(index)) {
            connectingLines.add(connectingStrategy.connectable());
            return;
        }
        connectingLines.add(DEFAULT_VALUE);
    }

    private boolean isFirstOrConnectableLine(int index) {
        return index == 0 || !connectingLines.get(index - 1);
    }

    @Override
    public List<Boolean> getConnectingLines() {
        return Collections.unmodifiableList(connectingLines);
    }
}
