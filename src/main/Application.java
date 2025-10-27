package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String namesInput = Console.readLine();
        List<String> names = InputParser.parseNames(namesInput);
        Validator.validateNames(names);

        System.out.println("시도할 횟수는 몇 회인가요?");
        String attemptInput = Console.readLine();
        int attemptCount = InputParser.parseAttemptCount(attemptInput);
        Validator.validateAttemptCount(attemptCount);

        // 실제 게임 시작
        System.out.println("실행 결과");
        List<Car> cars = names.stream()
                              .map(Car::new)
                              .toList();

        RacingGame game = new RacingGame(cars, new MissionRandomNumberGenerator());

        for (int i = 0; i < attemptCount; i++) {
            game.moveOnce();
            for (Car car : game.getCars()) {
                System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
            }
            System.out.println();
        }

        List<Car> winners = game.findWinners();
        System.out.println("최종 우승자 : " +
                String.join(", ", winners.stream().map(Car::getName).toList()));
    }
}
