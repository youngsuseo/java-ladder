package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class HorizontalLine {
    private static final Random random = new Random();

    private List<Boolean> horizontalLines;

    public HorizontalLine(List<Boolean> horizontalLines) {
        this.horizontalLines = horizontalLines;
    }

    public List<Boolean> connect() {
        for (int i = 0; i < horizontalLines.size(); i++) {
            if (i == 0) {
                horizontalLines.set(i, random.nextBoolean());
                continue;
            }

            if (!horizontalLines.get(i - 1)) {
                horizontalLines.set(i, random.nextBoolean());
            }
        }
        return Collections.unmodifiableList(horizontalLines);
    }
}
