package racingcar;

import java.util.ArrayList;
import java.util.List;

final class InputParser {

    private InputParser() {}

    // 자동차 이름 파싱
    static List<String> parseNames(String raw) {
        if (raw == null) {
            throw new IllegalArgumentException("입력이 null일 수 없습니다.");
        }

        String trimmed = raw.trim();
        if (trimmed.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름 입력이 비어 있습니다.");
        }

        String[] tokens = trimmed.split(",");
        List<String> result = new ArrayList<>();

        for (String token : tokens) {
            // 공백 제거
            String name = token.trim();
            result.add(name);
        }

        return result;
    }

    // 시도 횟수 파싱
    static int parseRounds(String raw) {
        if (raw == null) {
            throw new IllegalArgumentException("시도 횟수 입력이 null일 수 없습니다.");
        }

        String s = raw.trim();
        if (s.isEmpty()) {
            throw new IllegalArgumentException("시도 횟수 입력이 비어 있습니다.");
        }

        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 입력할 수 있습니다.");
        }
    }
}
