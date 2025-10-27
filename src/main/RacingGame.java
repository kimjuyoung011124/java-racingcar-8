package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> cars;
    private final NumberGenerator generator;

    public RacingGame(List<Car> cars, NumberGenerator generator) {
        if (cars == null || cars.isEmpty()) {
            throw new IllegalArgumentException("자동차 목록이 비어 있습니다.");
        }
        if (generator == null) {
            throw new IllegalArgumentException("난수 생성기가 필요합니다.");
        }
        this.cars = cars;
        this.generator = generator;
    }

    public void moveOnce() {
        for (Car car : cars) {
            int n = generator.next0to9();
            car.moveIf(n);
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> findWinners() {
        int max = 0;
        for (Car car : cars) {
            if (car.getPosition() > max) {
                max = car.getPosition();
            }
        }
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == max) {
                winners.add(car);
            }
        }
        return winners;
    }
}
