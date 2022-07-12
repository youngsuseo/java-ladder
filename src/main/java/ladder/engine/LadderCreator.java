package ladder.engine;

import ladder.domain.ConnectingStrategy;

import java.util.List;

public interface LadderCreator { // FIXME 상속받는 클래스 필요
    void create(ConnectingStrategy connectingStrategy);

    List<? extends LineCreator> getLines();
}