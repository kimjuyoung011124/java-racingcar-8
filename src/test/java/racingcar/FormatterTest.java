package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class FormatterTest {

    @Test
    @DisplayName("라운드 한 줄 포맷: '이름 : -----'")
    void carLine_format() {
        Car car = new Car("pobi");
        car.moveIf(5); // pos 1
        car.moveIf(5); // pos 2
        assertThat(Formatter.carLine(car)).isEqualTo("pobi : --");
    }

    @Test
    @DisplayName("최종 우승자 포맷: 단독/공동 모두 지원")
    void winnersLine_format() {
        Car a = new Car("pobi");
        Car b = new Car("jun");
        a.moveIf(5); b.moveIf(5);
        assertThat(Formatter.winnersLine(List.of(a, b)))
                .isEqualTo("최종 우승자 : pobi, jun");
    }
}
