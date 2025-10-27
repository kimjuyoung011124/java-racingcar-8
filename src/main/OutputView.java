package racingcar;

import java.util.List;

public class OutputView {

    public void printExecutionHeader() {
        System.out.println("실행 결과");
    }

    public void printRound(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(Formatter.carLine(car));
        }
        System.out.println(); // 라운드 간 빈 줄
    }

    public void printWinners(List<Car> winners) {
        System.out.println(Formatter.winnersLine(winners));
    }
}
