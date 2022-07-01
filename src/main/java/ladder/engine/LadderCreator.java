package ladder.engine;

import ladder.domain.ConnectingStrategy;
import ladder.domain.Ladder;

import java.util.List;

public interface LadderCreator {
    Ladder create(ConnectingStrategy connectingStrategy);

    List<? extends LineCreator> getLines();
}