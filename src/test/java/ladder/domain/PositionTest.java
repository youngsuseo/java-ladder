package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @Test
    void first() {
        Position position = Position.first(true);
        assertThat(position.move()).isEqualTo(1);
    }

    @Test
    void next() {
        Position position = Position.first(true).next(false);
        assertThat(position.move()).isEqualTo(0);
    }

    @Test
    void last() {
        Position position = Position.first(true).next(false).last();
        assertThat(position.move()).isEqualTo(2);
    }
}