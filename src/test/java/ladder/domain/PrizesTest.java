package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PrizesTest {

    @Test
    void construct() {
        Prizes prizes = new Prizes("1, 2, 3, 4");
        assertThat(prizes.getPrizes()).hasSize(4);
    }

    @Test
    void resultPrize() {
        Players players = new Players("user1, user2, user3, user4");
        List<String> arrayList = Arrays.asList("a", "b", "c", "d");
        Prizes prizes = new Prizes(arrayList);
        Ladder ladder = new Ladder(4, 5, new SequentialConnectionStratrgy()); // countOfPerson -> player로?

        Players result = prizes.resultPrize(players, ladder);

        assertThat(result.getPlayers().get(new PlayerName("user1"))).isEqualTo("b");
        assertThat(result.getPlayers().get(new PlayerName("user2"))).isEqualTo("a");
        assertThat(result.getPlayers().get(new PlayerName("user3"))).isEqualTo("d");
        assertThat(result.getPlayers().get(new PlayerName("user4"))).isEqualTo("c");
    }

}