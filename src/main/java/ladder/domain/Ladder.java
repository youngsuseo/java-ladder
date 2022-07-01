package ladder.domain;

import ladder.engine.LadderCreator;
import ladder.engine.LineCreator;

import java.util.List;

public class Ladder implements LadderCreator {
    private List<HorizontalLines> verticalLines;

    public Ladder(List<LineCreator> verticalLines, ConnectingStrategy connectingStrategy) {
        this.verticalLines = verticalLines;
        create(connectingStrategy);
    }

//    public Ladder(List<HorizontalLines> verticalLines, ConnectingStrategy connectingStrategy) {
//        this.verticalLines = verticalLines;
//        create(connectingStrategy);
//    }

    @Override
    public Ladder create(ConnectingStrategy connectingStrategy) {
        for (LineCreator verticalLine : verticalLines) {
            verticalLine.connect(connectingStrategy);
        }
        return this;
    }

    public List<HorizontalLines> getLines() {
        return verticalLines;
    }
}
