package racingcar;

import java.util.List;
import java.util.stream.Collectors;

final class Formatter {

    private Formatter() {}

    static String carLine(Car car) {
        return car.getName() + " : " + "-".repeat(car.getPosition());
    }

    static String winnersLine(List<Car> winners) {
        String names = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        return "최종 우승자 : " + names;
    }
}
