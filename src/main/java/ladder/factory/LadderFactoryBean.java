package ladder.factory;

import ladder.domain.HorizontalLines;
import ladder.domain.Ladder;
import ladder.domain.RandomConnectingStrategy;
import ladder.engine.LadderCreator;
import ladder.engine.LineCreator;

public class LadderFactoryBean {
    public static LadderCreator create(int countOfLines) {
        LineCreator lineCreator = new HorizontalLines(countOfLines);
        lineCreator.connect(() -> RandomConnectingStrategy());
        return new Ladder(lineCreator);

    }

}