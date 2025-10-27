package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class InputParserTest {

    @Test
    @DisplayName("쉼표로 구분된 자동차 이름을 파싱하고 trim 처리한다")
    void parseNames_basic() {
        List<String> names = InputParser.parseNames(" pobi,  woni ,jun ");
        assertThat(names).containsExactly("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("빈 문자열 입력 시 예외 발생")
    void parseNames_blank() {
        assertThatThrownBy(() -> InputParser.parseNames("   "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도 횟수를 trim 후 정수로 파싱한다")
    void parseRounds_ok() {
        int rounds = InputParser.parseRounds(" 5 ");
        assertThat(rounds).isEqualTo(5);
    }

    @Test
    @DisplayName("시도 횟수에 숫자가 아닌 값을 넣으면 예외 발생")
    void parseRounds_notNumber() {
        assertThatThrownBy(() -> InputParser.parseRounds("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
