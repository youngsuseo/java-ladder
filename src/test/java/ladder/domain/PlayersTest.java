package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

public class PlayersTest {
    private static List<String> names;

    @BeforeEach
    void setup() {
        names = new ArrayList<>() {
            {
                add("user1");
                add("user2");
                add("user3");
            }
        };
    }

    @DisplayName("입력 값을 통해 player map 생성 확인")
    @ParameterizedTest
    @ValueSource(ints = {3, 5})
    void construct(int numberOfMoves) {
//        Players players = new Players(names, numberOfMoves);
    }
}
