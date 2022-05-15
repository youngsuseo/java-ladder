package ladder.domain;

import ladder.domain.Names;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class NamesTest {

    @DisplayName("입력한 데이터를 , 구분자로 하여 나눈다.")
    @ParameterizedTest
    @ValueSource(strings = "user1, user2, user3")
    void create(String names) { // FIXME 우선 팩터리 메서드로 생성하고 추후 생성자로 이동
        List<String> nameList = Names.create(names);
        assertThat(nameList).hasSize(3);
    }

    @DisplayName("입력한 사용자의 이름이 null 일 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "   "})
    void create_inputBlank(String names) {
        assertThatIllegalArgumentException().isThrownBy(() -> Names.create(names))
                .withMessageContaining("이름은 빈 값을 입력 할 수 없습니다.");
    }

    @DisplayName("입력한 사용자의 이름은 5글자 이하만 사용 가능하다.")
    @ParameterizedTest
    @ValueSource(strings = "user12345, user2")
    void create_invalidUserName(String names) {
        assertThatIllegalArgumentException().isThrownBy(() -> Names.create(names))
                .withMessageContaining("이름은 1 ~ 5 글자만 허용됩니다.");
    }
}
