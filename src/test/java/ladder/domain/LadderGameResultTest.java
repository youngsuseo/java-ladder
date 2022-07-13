package ladder.domain;

import ladder.engine.LadderCreator;
import ladder.engine.LadderResult;
import ladder.factory.LadderFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderGameResultTest {

    @Test
    void result() {
        Players players = new Players("user1, user2, user3, user4");
        LadderCreator ladderCreator = LadderFactory.create(5, players.countOfPlayers(), new RandomConnectingStrategy());
        LadderResult ladderResult = new LadderGameResult("1,2,3,4");
        Players result = ladderResult.result(players, ladderCreator);
    }
}