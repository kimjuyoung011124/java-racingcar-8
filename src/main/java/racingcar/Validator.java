package racingcar;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

final class Validator {

    private Validator() {}

    // 자동차 이름 검증
    static void validateNames(List<String> names) {
        if (names == null || names.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름이 없습니다.");
        }

        Set<String> seen = new HashSet<>();
        for (String name : names) {
            if (name == null) {
                throw new IllegalArgumentException("빈 이름은 허용되지 않습니다.");
            }

            String n = name.trim();

            if (n.isEmpty()) {
                throw new IllegalArgumentException("빈 이름은 허용되지 않습니다.");
            }

            if (n.length() < 1 || n.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하여야 합니다.");
            }

            if (seen.contains(n)) {
                throw new IllegalArgumentException("중복된 자동차 이름이 존재합니다.");
            }

            seen.add(n);
        }
    }

    // 시도 횟수 검증
    static void validateRounds(int rounds) {
        if (rounds <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }
}
