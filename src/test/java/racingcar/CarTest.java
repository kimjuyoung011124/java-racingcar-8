package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("랜덤값이 4 이상이면 전진한다")
    void moveIf_ge4() {
        Car car = new Car("pobi");
        car.moveIf(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("랜덤값이 3 이하면 멈춘다")
    void moveIf_lt4() {
        Car car = new Car("pobi");
        car.moveIf(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
