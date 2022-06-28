package ladder.domain;

import ladder.engine.LadderCreator;

import java.util.ArrayList;
import java.util.List;

public class Ladder implements LadderCreator {
    private int countOfPerson;
    private int numberOfMoves;
    private List<HorizontalLines> verticalLines;

    public Ladder(int countOfPerson, int numberOfMoves, ConnectingStrategy connectingStrategy) {
        this.countOfPerson = countOfPerson;
        this.numberOfMoves = numberOfMoves;
        create(connectingStrategy);
    }

    private void create(ConnectingStrategy connectingStrategy) {
        verticalLines = new ArrayList<>();
        for (int index = 0; index < numberOfMoves; index++) {
            HorizontalLines horizontalLines = new HorizontalLines();
            horizontalLines.connect(countOfPerson - 1, connectingStrategy);
            verticalLines.add(horizontalLines);
        }
    }

    public List<HorizontalLines> getVerticalLines() {
        return verticalLines;
    }
}
