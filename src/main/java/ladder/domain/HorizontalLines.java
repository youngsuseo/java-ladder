package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class HorizontalLines {
    private static final Random random = new Random();
    private static final boolean DEFAULT_VALUE = false;

    private final List<Boolean> horizontalLines;

    HorizontalLines() {
        this(new ArrayList<>());
    }

    public HorizontalLines(List<Boolean> horizontalLines) {
        this.horizontalLines = horizontalLines;
    }

    public void connect(int countOfLines, ConnectingStrategy connectingStrategy) {
        for (int i = 0; i < countOfLines; i++) {
            if (isFirstOrConnectableLine(i)) {
                horizontalLines.add(connectingStrategy.connectable());
                continue;
            }
            horizontalLines.add(DEFAULT_VALUE);
        }
    }

    private boolean isFirstOrConnectableLine(int i) {
        return i == 0 || !horizontalLines.get(i - 1);
    }

    public List<Boolean> getHorizontalLines() {
        return Collections.unmodifiableList(horizontalLines);
    }
}
