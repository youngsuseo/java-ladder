package ladder.domain;

import java.util.Arrays;
import java.util.List;

public class Names {

    public static List<String> create(String names) {
        if (names == null || names.isBlank()) {
            throw new IllegalArgumentException("이름은 빈 값을 입력 할 수 없습니다.");
        }

        String[] nameArray = names.split("\\s*,\\s*");

        for (String name : nameArray) {
            if (name.length() < 1  || name.length() > 6) {
                throw new IllegalArgumentException("이름은 1 ~ 5 글자만 허용됩니다.");
            }
        }

        return Arrays.asList(nameArray);
    }
}
