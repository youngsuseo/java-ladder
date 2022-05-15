package ladder.domain;

import ladder.domain.HorizontalLine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class HorizontalLineTest {
    private static final boolean INITIAL_CONNECT_VALUE = false;
    private static final int INITIAL = 0;
    private static final int COUNT_OF_PEOPLE = 5;

    private List<Boolean> lines;

    @BeforeEach
    void setup() {
        lines = new ArrayList<>() {
            {
                for (int i = INITIAL; i < COUNT_OF_PEOPLE; i++) {
                    add(INITIAL_CONNECT_VALUE);
                }
            }
        };

    }

    // TODO 조건 검증하고, 랜덤으로 생성되므로 완전한 검증 불가
    @DisplayName("사다리 세로선 사이 가로선을 생성한다.")
    @Test
    void connect() {
        HorizontalLine horizontalLine = new HorizontalLine(lines);
        List<Boolean> connect = horizontalLine.connect();
        assertThat(connect).hasSize(5);
    }



}
