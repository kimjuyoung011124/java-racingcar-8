package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ValidatorTest {

    @Test
    @DisplayName("이름이 1~5자 이내가 아니면 예외 발생")
    void nameLength_outOfRange() {
        assertThatThrownBy(() -> Validator.validateNames(List.of("aaaaaa")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1자 이상 5자");
    }

    @Test
    @DisplayName("빈 이름이 존재하면 예외 발생(a,,b 형태 포함)")
    void emptyName_throwsException() {
        assertThatThrownBy(() -> Validator.validateNames(List.of("a", "", "b")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈 이름");
    }

    @Test
    @DisplayName("중복된 이름이 존재하면 예외 발생")
    void duplicatedNames_throwsException() {
        assertThatThrownBy(() -> Validator.validateNames(List.of("pobi", "pobi")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된");
    }

    @Test
    @DisplayName("시도 횟수가 0 이하일 경우 예외 발생")
    void invalidRounds_throwsException() {
        assertThatThrownBy(() -> Validator.validateRounds(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 이상");
    }

    @Test
    @DisplayName("정상 입력은 예외가 발생하지 않는다")
    void validInput_ok() {
        List<String> names = List.of("pobi", "woni", "jun");
        assertThatCode(() -> {
            Validator.validateNames(names);
            Validator.validateRounds(5);
        }).doesNotThrowAnyException();
    }
}
