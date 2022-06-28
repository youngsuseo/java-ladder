package ladder.engine;

import ladder.domain.ConnectingStrategy;

public interface LineCreator {
    void connect(ConnectingStrategy connectingStrategy);
}