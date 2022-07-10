package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PointTest {

    @Test
    void right() {
        Point point = Point.first(false).next(true);
        assertThat(point.move()).isEqualTo(Direction.RIGHT);
    }

    @Test
    void left() {
        Point point = Point.first(true).next(false);
        assertThat(point.move()).isEqualTo(Direction.LEFT);
    }

    @Test
    void pass() {
        Point point = Point.first(false).next(false);
        assertThat(point.move()).isEqualTo(Direction.PASS);
    }

    @Test
    void invalid() {
        assertThatThrownBy(() -> Point.first(true).next(true))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("양쪽에 사다리 선이 생성될 수 없습니다.");
    }

    @Test
    void first() {
        Point point = Point.first(true);
        assertThat(point.move()).isEqualTo(Direction.RIGHT);
    }

    @Test
    void last() {
        Point point = Point.first(true).last();
        assertThat(point.move()).isEqualTo(Direction.LEFT);
    }
}
