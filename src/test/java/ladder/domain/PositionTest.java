package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @Test
    void move_right() {
        Point point = Point.first(true);
        Position position = new Position(0, point);
        assertThat(position.move()).isEqualTo(1);
    }

    @Test
    void move_left() {
        Point point = Point.first(true).next(false);
        Position position = new Position(1, point);
        assertThat(position.move()).isEqualTo(0);
    }

    @Test
    void move_pass() {
        Point point = Point.first(false).next(false);
        Position position = new Position(1, point);
        assertThat(position.move()).isEqualTo(1);
    }

    @Test
    void first() {
        Position position = Position.first(false);
        assertThat(position.move()).isEqualTo(0);
    }

    @Test
    void next() {
        Position position = Position.first(true).next();
        assertThat(position.move()).isEqualTo(0);
    }
}