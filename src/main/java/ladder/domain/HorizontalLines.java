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

    public void connect(int countOfLines) {
        for (int index = 0; index < countOfLines; index++) {
            if (connectable(index)) {
                continue;
            }
            horizontalLines.add(DEFAULT_VALUE);
        }
    }

    private boolean connectable(int index) {
        if (isFirstOrConnectableLine(index)) {
            randomlyConnectable();
            return true;
        }
        return false;
    }

    private void randomlyConnectable() {
        if (random.nextBoolean()) {
            horizontalLines.add(true);
        }
    }

    private void connect(boolean connectable) {
        if (connectable) {
            horizontalLines.add(true);
        }
    }

    private boolean isFirstOrConnectableLine(int i) {
        return i == 0 || !horizontalLines.get(i - 1);
    }

    public List<Boolean> getHorizontalLines() {
        return Collections.unmodifiableList(horizontalLines);
    }
}
