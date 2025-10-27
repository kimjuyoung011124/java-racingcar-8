package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RacingGameTest {

    @Test
    @DisplayName("한 라운드에서 모든 자동차가 한 번씩 이동 판정을 받는다(고정 난수 5)")
    void moveOnce_allCars() {
        List<Car> cars = List.of(new Car("pobi"), new Car("woni"), new Car("jun"));
        NumberGenerator stubGen = () -> 5; // 항상 5 반환 → 모두 전진
        RacingGame game = new RacingGame(cars, stubGen);

        game.moveOnce();

        assertThat(cars).allSatisfy(car ->
                assertThat(car.getPosition()).isEqualTo(1)
        );
    }

    @Test
    @DisplayName("최대 이동 거리를 가진 자동차가 단독 우승")
    void findWinners_single() {
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");
        pobi.moveIf(5); // 1칸
        pobi.moveIf(5); // 2칸
        woni.moveIf(5); // 1칸

        RacingGame game = new RacingGame(List.of(pobi, woni), () -> 5);

        assertThat(game.findWinners())
                .extracting(Car::getName)
                .containsExactly("pobi");
    }

    @Test
    @DisplayName("최대 이동 거리가 같으면 공동 우승")
    void findWinners_tie() {
        Car pobi = new Car("pobi");
        Car jun = new Car("jun");
        pobi.moveIf(5); // 1칸
        jun.moveIf(5);  // 1칸

        RacingGame game = new RacingGame(List.of(pobi, jun), () -> 5);

        assertThat(game.findWinners())
                .extracting(Car::getName)
                .containsExactlyInAnyOrder("pobi", "jun");
    }
}
