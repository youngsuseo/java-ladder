package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    public static List<HorizontalLines> create(int countOfPerson, int numberOfMoves) {
        List<HorizontalLines> lines = new ArrayList<>();
        for (int index = 0; index < numberOfMoves; index++) {
            HorizontalLines horizontalLines = new HorizontalLines();
            horizontalLines.connect(countOfPerson - 1);
            lines.add(horizontalLines);
        }
        return lines;
    }
}
